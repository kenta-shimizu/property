package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface ObjectObservable<T> extends Observable<T> {
	
	/**
	 * Returns isEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> type
	 * @param observable
	 * @return isEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution isEqualTo(ObjectObservable<U> observable) {
		if ( observable == null ) {
			return ComparativeCompution.equalTo(this, UnmodifiablePropertyBuilder.getInstance().getNullObject());
		} else {
			return ComparativeCompution.equalTo(this, observable);
		}
	}
	
	/**
	 * Returns isEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> type
	 * @param ref
	 * @return isEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution isEqualTo(U ref) {
		return ComparativeCompution.equalTo(this, UnmodifiablePropertyBuilder.getInstance().newObject(ref));
	}
	
	/**
	 * Returns isNotEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> type
	 * @param observable
	 * @return isNotEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution isNotEqualTo(ObjectObservable<U> observable) {
		if ( observable == null ) {
			return ComparativeCompution.notEqualTo(this, UnmodifiablePropertyBuilder.getInstance().getNullObject());
		} else {
			return ComparativeCompution.notEqualTo(this, observable);
		}
	}
	
	/**
	 * Returns isNotEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> type
	 * @param ref
	 * @return isNotEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution isNotEqualTo(U ref) {
		return ComparativeCompution.notEqualTo(this, UnmodifiablePropertyBuilder.getInstance().newObject(ref));
	}
	
	/**
	 * Wait until value is <b>NOT</b> {@code null}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is <b>NOT</b> {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @return value
	 * @throws InterruptedException
	 */
	default public T waitUntilNotNull() throws InterruptedException {
		return ObjectWaitUntil.getInstance().isNull(this, false);
	}
	
	/**
	 * Wait until value is <b>NOT</b> {@code null}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is <b>NOT</b> {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @return value
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public T waitUntilNotNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		return ObjectWaitUntil.getInstance().isNull(this, false, timeout, unit);
	}
	
	/**
	 * Wait until value is <b>NOT</b> {@code null}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is <b>NOT</b> {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @return value
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public T waitUntilNotNull(TimeGettable p) throws InterruptedException, TimeoutException {
		return ObjectWaitUntil.getInstance().isNull(this, false, p);
	}
	
	/**
	 * Wait until value is {@code null}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilNull() throws InterruptedException {
		ObjectWaitUntil.getInstance().isNull(this, true);
	}
	
	/**
	 * Wait until value is {@code null}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ObjectWaitUntil.getInstance().isNull(this, true, timeout, unit);
	}
	
	/**
	 * Wait until value is {@code null}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNull(TimeGettable p) throws InterruptedException, TimeoutException {
		ObjectWaitUntil.getInstance().isNull(this, true, p);
	}
	
}
