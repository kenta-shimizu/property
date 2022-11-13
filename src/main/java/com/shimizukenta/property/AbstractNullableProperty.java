package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AbstractNullableProperty<T> extends AbstractProperty<T, Settable<T>> implements NullableProperty<T> {
	
	private static final long serialVersionUID = -8210275327751090005L;
	
	protected AbstractNullableProperty(T initial) {
		super(initial);
	}
	
	@Override
	public void set(T value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(value, this._get()) ) {
				super.set(value);
				this._notifyChanged(this._get());
				this._sync.notifyAll();
			}
		}
	}

	@Override
	public T waitUntilNotNull() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T waitUntilNotNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void waitUntilNull() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitUntilNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub
		
	}
	
	
}
