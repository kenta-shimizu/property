package com.shimizukenta.property;

import java.util.Objects;
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
	protected void _syncSetAndNotifyChanged(Boolean f) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(f, this._simpleGet()) ) {
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
