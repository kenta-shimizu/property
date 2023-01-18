package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class ObjectWaitUntil extends AbstractWaitUntil {

	protected ObjectWaitUntil() {
		super();
	}
	
	private static final class SingletonHolder {
		private static final ObjectWaitUntil inst = new ObjectWaitUntil();
	}
	
	public static ObjectWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	private class InnerIsNull<T> extends AbstractInner implements ChangeListener<T> {
		
		private T lastObj;
		
		private InnerIsNull(boolean isNull) {
			super(isNull);
			lastObj = null;
		}
		
		@Override
		public void changed(T value) {
			synchronized ( this.sync ) {
				this.lastObj = value;
				this.set(this.lastObj == null);
			}
		}
		
		public T waitUntilAndGet() throws InterruptedException {
			synchronized ( this.sync ) {
				this.waitUntil();
				return this.lastObj;
			}
		}
		
		public T waitUntilAndGet(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				this.waitUntil(timeout, unit);
				return this.lastObj;
			}
		}
		
		public T waitUntilAndGet(TimeGettable p) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				this.waitUntil(p);
				return this.lastObj;
			}
		}
	}
	
	public <T> T isNull(ObjectObservable<T> observable, boolean isNull) throws InterruptedException {
		final InnerIsNull<T> i = new InnerIsNull<>(isNull);
		try {
			observable.addChangeListener(i);
			return i.waitUntilAndGet();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <T> T isNull(ObjectObservable<T> observable, boolean isNull, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerIsNull<T> i = new InnerIsNull<>(isNull);
		try {
			observable.addChangeListener(i);
			return i.waitUntilAndGet(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <T> T isNull(ObjectObservable<T> observable, boolean isNull, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerIsNull<T> i = new InnerIsNull<>(isNull);
		try {
			observable.addChangeListener(i);
			return i.waitUntilAndGet(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
}
