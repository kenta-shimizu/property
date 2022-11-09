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
public abstract class AbstractBooleanProperty extends AbstractProperty<Boolean, BooleanSettable> implements BooleanProperty {
	
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
	
}
