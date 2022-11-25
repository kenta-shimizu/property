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
public abstract class AbstractBooleanProperty extends AbstractProperty<Boolean> implements BooleanProperty {
	
	private static final long serialVersionUID = 3470538189679094943L;
	
	protected AbstractBooleanProperty(boolean initial) {
		super(Boolean.valueOf(initial));
	}
	
	@Override
	public boolean booleanValue() {
		return this._simpleGet().booleanValue();
	}
	
	@Override
	public void set(boolean value) {
		this._syncSetAndNotifyChanged(Boolean.valueOf(value));
	}
	
	protected void _syncSetAndNotifyChanged(Boolean f) {
		synchronized ( this._sync ) {
			if (! Objects.equals(f, this._simpleGet())) {
				this._simpleSet(f);
				this._notifyChanged(f);
				this._sync.notifyAll();
			}
		}
	}
	
	@Override
	public void waitUntil(boolean f) throws InterruptedException {
		synchronized ( this._sync ) {
			if ( f != this.booleanValue() ) {
				this._sync.wait();
			}
		}
	}
	
	@Override
	public void waitUntil(boolean f, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		synchronized ( this._sync ) {
			if ( f != this.booleanValue() ) {
				unit.timedWait(this._sync, timeout);
				if ( f != this.booleanValue() ) {
					throw new TimeoutException();
				}
			}
		}
	}
	
}
