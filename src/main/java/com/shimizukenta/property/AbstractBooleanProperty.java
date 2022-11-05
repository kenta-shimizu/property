/**
 * 
 */
package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author kenta-shimizu
 *
 */
public class AbstractBooleanProperty extends AbstractProperty<Boolean, WritableBooleanProperty> implements BooleanProperty {
	
	private static final long serialVersionUID = 3470538189679094943L;
	
	protected AbstractBooleanProperty(boolean initial) {
		super(Boolean.valueOf(initial));
	}
	
	@Override
	public void set(Boolean value) {
		this.__set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(boolean value) {
		this.__set(Boolean.valueOf(value));
	}
	
	private void __set(Boolean f) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(_get(), f) ) {
				this._set(f);
				this._notifyChanged(f);
				this._sync.notifyAll();
			}
		}
	}
	
	@Override
	public boolean booleanValue() {
		return get().booleanValue();
	}
	
	@Override
	public void waitUntil(boolean f) throws InterruptedException {
		synchronized ( this._sync ) {
			if ( _get().booleanValue() == f ) {
				return;
			}
			this._sync.wait();
		}
	}
	
	@Override
	public void waitUntil(boolean f, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		synchronized ( this._sync ) {
			if ( _get().booleanValue() == f ) {
				return;
			}
			unit.timedWait(this._sync, timeout);
			if ( _get().booleanValue() != f ) {
				throw new TimeoutException();
			}
		}
	}
	
	@Override
	public void waitUntil(boolean f, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		waitUntil(f, a.timeout(), a.unit());
	}
	
	@Override
	public void waitUntilTrue() throws InterruptedException {
		waitUntil(true);
	}
	
	@Override
	public void waitUntilTrue(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		waitUntil(true, timeout, unit);
	}
	
	@Override
	public void waitUntilTrue(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException {
		waitUntil(true, p);
	}
	
	@Override
	public void waitUntilFalse() throws InterruptedException {
		waitUntil(false);
	}
	
	@Override
	public void waitUntilFalse(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		waitUntil(false, timeout, unit);
	}
	
	@Override
	public void waitUntilFalse(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException {
		waitUntil(false, p);
	}
	
	@Override
	public String toString() {
		return this.get().toString();
	}
	
}
