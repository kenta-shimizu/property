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
	 * @param <U> Type
	 * @param observable
	 * @return isEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution computeEqualTo(ObjectObservable<U> observer) {
		return ObjectUtils.computeIsEqualTo(this, observer);
	}
	
	/**
	 * Returns isEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> Type
	 * @param ref
	 * @return isEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution computeEqualTo(U ref) {
		return this.computeEqualTo(ObjectUtils.newUnmodifiable(ref));
	}
	
	/**
	 * Returns isNotEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> Type
	 * @param observable
	 * @return isNotEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution computeNotEqualTo(ObjectObservable<U> observer) {
		return ObjectUtils.computeIsNotEqualTo(this, observer);
	}
	
	/**
	 * Returns isNotEqualTo ComparativeCompution instance.
	 * 
	 * @param <U> Type
	 * @param ref
	 * @return isNotEqualTo ComparativeCompution instance
	 */
	default public <U> ComparativeCompution computeNotEqualTo(U ref) {
		return this.computeNotEqualTo(ObjectUtils.newUnmodifiable(ref));
	}
	
	/**
	 * Wait until value is equal.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is equal, pass through immediately.<br />
	 * </p>
	 * 
	 * @param <U> Type
	 * @param observer
	 * @throws InterruptedException
	 */
	default public <U> void waitUntilEqualTo(
			ObjectObservable<U> observer) throws InterruptedException {
		
		ObjectUtils.waitUntilEqualTo(this, observer);
	}
	
	//TODO
	//comment
	default public <U> void waitUntilEqualTo(
			ObjectObservable<U> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		ObjectUtils.waitUntilEqualTo(this, observer, timeout, unit);
	}

	//TODO
	//comment
	default public <U> void waitUntilEqualTo(
			ObjectObservable<U> observer,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		ObjectUtils.waitUntilEqualTo(this, observer, p);
	}
	
	
	//TODO
	//comment
	default public <U> void waitUntilEqualTo(
			U ref) throws InterruptedException {
		
		this.waitUntilEqualTo(ObjectUtils.newUnmodifiable(ref));
	}
	
	//TODO
	//comment
	default public <U> void waitUntilEqualTo(
			U ref,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntilEqualTo(ObjectUtils.newUnmodifiable(ref), timeout, unit);
	}

	//TODO
	//comment
	default public <U> void waitUntilEqualTo(
			
			U ref,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntilEqualTo(ObjectUtils.newUnmodifiable(ref), p);
	}
	
	//TODO
	//comment
	default public <U> void waitUntilNotEqualTo(
			ObjectObservable<U> observer) throws InterruptedException {
		
		ObjectUtils.waitUntilNotEqualTo(this, observer);
	}
	
	//TODO
	//comment
	default public <U> void waitUntilNotEqualTo(
			ObjectObservable<U> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		ObjectUtils.waitUntilNotEqualTo(this, observer, timeout, unit);
	}
	
	//TODO
	//comment
	default public <U> void waitUntilNotEqualTo(
			ObjectObservable<U> observer,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		ObjectUtils.waitUntilNotEqualTo(this, observer, p);
	}
	
	//TODO
	//comment
	default public <U> void waitUntilNotEqualTo(
			U ref) throws InterruptedException {
		
		this.waitUntilNotEqualTo(ObjectUtils.newUnmodifiable(ref));
	}
	
	//TODO
	//comment
	default public <U> void waitUntilNotEqualTo(
			U ref,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntilNotEqualTo(ObjectUtils.newUnmodifiable(ref), timeout, unit);
	}
	
	//TODO
	//comment
	default public <U> void waitUntilNotEqualTo(
			U ref,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntilNotEqualTo(ObjectUtils.newUnmodifiable(ref), p);
	}
	
	
	//TODO
	//comment
	default public BooleanCompution computeEqualToNull() {
		return ObjectUtils.computeIsNull(this);
	}
	
	//TODO
	//comment
	default public BooleanCompution computeNotEqualToNull() {
		return ObjectUtils.computeIsNotNull(this);
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
		return ObjectUtils.waitUntilNotNull(this);
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
		return ObjectUtils.waitUntilNotNull(this, timeout, unit);
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
		return ObjectUtils.waitUntilNotNull(this, p);
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
		ObjectUtils.waitUntilNull(this);
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
		ObjectUtils.waitUntilNull(this, timeout, unit);
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
		ObjectUtils.waitUntilNull(this, p);
	}
	
}
