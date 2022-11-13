package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractBooleanCompution extends AbstractCompution<Boolean, BooleanSettable> implements BooleanCompution {
	
	private static final long serialVersionUID = 628986372297013412L;
	
	protected AbstractBooleanCompution(Boolean initial) {
		super(initial);
	}
	
	@Override
	protected void _set(Boolean f) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(this._get(), f) ) {
				super._set(f);
				this._notifyChanged(f);
				this._sync.notifyAll();
			}
		}
	}
	
	protected void _set(boolean f) {
		this._set(Boolean.valueOf(f));
	}
	
	@Override
	public void waitUntil(boolean f) throws InterruptedException {
		synchronized ( this._sync ) {
			if ( f != this._get().booleanValue()) {
				this._sync.wait();
			}
		}
	}

	@Override
	public void waitUntil(boolean f, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		synchronized ( this._sync ) {
			if ( f != this._get().booleanValue() ) {
				unit.timedWait(this._sync, timeout);
				if ( f != this._get().booleanValue() ) {
					throw new TimeoutException();
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return this.get().toString();
	}
	
}
