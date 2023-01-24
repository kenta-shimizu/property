package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiPredicate;

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
	
	private class IsNullInner<T> extends AbstractComparativeCompution<T, Object> {
		
		private static final long serialVersionUID = 6104298618775119632L;
		
		private T last;
		
		public IsNullInner(BiPredicate<Object, Object> compute) {
			super(compute);
			this.last = null;
		}
		
		@Override
		protected void leftChanged(T v) {
			synchronized ( this._sync ) {
				this.last = v;
				super.leftChanged(v);
			}
		}
		
		public T waitUntilAndGet(boolean isNull) throws InterruptedException {
			synchronized ( this._sync ) {
				super.waitUntil(isNull);
				return this.last;
			}
		}
		
		public T waitUntilAndGet(boolean isNull, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this._sync ) {
				super.waitUntil(isNull, timeout, unit);
				return this.last;
			}
		}
		
		public T waitUntilAndGet(boolean isNull, TimeGettable p) throws InterruptedException, TimeoutException {
			synchronized ( this._sync ) {
				super.waitUntil(isNull, p);
				return this.last;
			}
		}
		
	}
	
	private <T> IsNullInner<T> buildIsNullInner(ObjectObservable<T> observer) {
		final IsNullInner<T> i = new IsNullInner<>((a, b) -> Objects.equals(a, b));
		i.bindLeft(observer);
		i.bindRight(UnmodifiablePropertyBuilder.getInstance().getNullObject());
		return i;
	}
	
	public <T> T isNull(ObjectObservable<T> observable, boolean isNull) throws InterruptedException {
		final IsNullInner<T> i = buildIsNullInner(observable);
		try {
			return i.waitUntilAndGet(isNull);
		}
		finally {
			i.unbindLeft(observable);
		}
	}
	
	public <T> T isNull(ObjectObservable<T> observable, boolean isNull, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final IsNullInner<T> i = buildIsNullInner(observable);
		try {
			return i.waitUntilAndGet(isNull, timeout, unit);
		}
		finally {
			i.unbindLeft(observable);
		}
	}
	
	public <T> T isNull(ObjectObservable<T> observable, boolean isNull, TimeGettable p) throws InterruptedException, TimeoutException {
		final IsNullInner<T> i = buildIsNullInner(observable);
		try {
			return i.waitUntilAndGet(isNull, p);
		}
		finally {
			i.unbindLeft(observable);
		}
	}
	
}
