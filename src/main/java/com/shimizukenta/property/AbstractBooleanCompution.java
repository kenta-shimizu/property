package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractBooleanCompution extends AbstractCompution<Boolean> implements BooleanCompution {
	
	private static final long serialVersionUID = 628986372297013412L;
	
	protected AbstractBooleanCompution(Boolean initial) {
		super(initial);
	}
	
	@Override
	public boolean booleanValue() {
		return this._simpleGet().booleanValue();
	}
	
	@Override
	public void waitUntil(boolean condition) throws InterruptedException {
		synchronized ( this._sync ) {
			if ( this.booleanValue() != condition ) {
				this._sync.wait();
			}
		}
	}
	
	@Override
	public void waitUntil(boolean condition, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		synchronized ( this._sync ) {
			if ( this.booleanValue() != condition ) {
				unit.timedWait(this._sync, timeout);
				if ( this.booleanValue() != condition) {
					throw new TimeoutException();
				}
			}
		}
	}
	
	@Override
	protected void _notifyChanged(Boolean value) {
		super._notifyChanged(value);
		synchronized ( this._sync ) {
			this._sync.notifyAll();
		}
	}
	
}
