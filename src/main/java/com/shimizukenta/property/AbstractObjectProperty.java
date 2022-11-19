package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractObjectProperty<T> extends AbstractProperty<T> implements ObjectProperty<T> {
	
	private static final long serialVersionUID = -8210275327751090005L;
	
	protected AbstractObjectProperty(T initial) {
		super(initial);
	}
	
	protected class Inner implements ChangeListener<T> {
		
		private final Object sync = new Object();
		
		private final boolean waitNull;
		private boolean f;
		private T v;
		
		protected Inner(boolean waitNull) {
			this.waitNull = waitNull;
			this.f = false;
			this.v = null;
		}
		
		public void changed(T value) {
			synchronized ( this.sync ) {
				this.v = value;
				boolean f = value == null;
				if ( f != this.f ) {
					this.f = f;
					this.sync.notifyAll();
				}
			}
		}
		
		protected T waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.f != this.waitNull ) {
					this.sync.wait();
				}
				return this.v;
			}
		}
		
		protected T waitUntil(long timeout, TimeUnit unit) throws InterruptedException , TimeoutException {
			synchronized ( this.sync ) {
				if ( this.f != this.waitNull ) {
					unit.timedWait(this.sync, timeout);
					if ( this.f != this.waitNull ) {
						throw new TimeoutException();
					}
				}
				return this.v;
			}
		}
	}
	
	@Override
	public T waitUntilNotNull() throws InterruptedException {
		final Inner i = new Inner(false);
		try {
			this.addChangeListener(i);
			return i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}

	@Override
	public T waitUntilNotNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = new Inner(false);
		try {
			this.addChangeListener(i);
			return i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}

	@Override
	public void waitUntilNull() throws InterruptedException {
		final Inner i = new Inner(true);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}

	@Override
	public void waitUntilNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = new Inner(true);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public String toString() {
		return Objects.toString(this.get());
	}
}
