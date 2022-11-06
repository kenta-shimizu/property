package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AbstractBooleanCompution extends AbstractCompution<Boolean, BooleanSettable> implements BooleanCompution {

	private static final long serialVersionUID = 2458680400943614137L;

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
