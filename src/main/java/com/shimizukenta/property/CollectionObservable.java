package com.shimizukenta.property;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @param <T> Type
 */
public interface CollectionObservable<E, T extends Collection<E>> {
	
	/**
	 * Add change-listener.
	 * 
	 * @param listener
	 * @return {@code true} if add success, otherwise {@code false}.
	 */
	public boolean addChangeListener(ChangeListener<? super T> listener);
	
	/**
	 * Remove change-listener.
	 * 
	 * @param listener
	 * @return {@code true} if remove success, otherwise {@code false}.
	 */
	public boolean removeChangeListener(ChangeListener<? super T> listener);
	
	/**
	 * Wait until {@link Collection#contains(Object)} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#contains(Object)} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	public void waitUntilContains(Object o) throws InterruptedException;
	
	/**
	 * Wait until {@link Collection#contains(Object)} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#contains(Object)} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until {@link Collection#contains(Object)} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#contains(Object)} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilContains(Object o, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilContains(o, a.timeout(), a.unit());
	}
	
	/**
	 * Wait until {@link Collection#contains(Object)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#contains(Object)} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	public void waitUntilNotContains(Object o) throws InterruptedException;
	
	/**
	 * Wait until {@link Collection#contains(Object)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#contains(Object)} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilNotContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until {@link Collection#contains(Object)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#contains(Object)} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContains(Object o, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotContains(o, a.timeout(), a.unit());
	}
	
	/**
	 * Wait until {@link Collection#containsAll(Collection)} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#containsAll(Collection)} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param c
	 * @throws InterruptedException
	 */
	public void waitUntilContainsAll(Collection<?> c) throws InterruptedException;
	
	/**
	 * Wait until {@link Collection#containsAll(Collection)} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#containsAll(Collection)} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param c
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until {@link Collection#containsAll(Collection)} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#containsAll(Collection)} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param c
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilContainsAll(c, a.timeout(), a.unit());
	}
	
	/**
	 * Wait until {@link Collection#containsAll(Collection)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#containsAll(Collection)} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param c
	 * @throws InterruptedException
	 */
	public void waitUntilNotContainsAll(Collection<?> c) throws InterruptedException;
	
	/**
	 * Wait until {@link Collection#containsAll(Collection)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#containsAll(Collection)} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param c
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilNotContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until {@link Collection#containsAll(Collection)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#containsAll(Collection)} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param c
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotContainsAll(c, a.timeout(), a.unit());
	}
	
	/**
	 * Wait until {@link Collection#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#isEmpty()} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void waitUntilIsEmpty() throws InterruptedException;
	
	/**
	 * Wait until {@link Collection#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#isEmpty()} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilIsEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until {@link Collection#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#isEmpty()} is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilIsEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilIsEmpty(a.timeout(), a.unit());
	}
	
	/**
	 * Wait until {@link Collection#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#isEmpty()} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void waitUntilIsNotEmpty() throws InterruptedException;
	
	/**
	 * Wait until {@link Collection#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#isEmpty()} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilIsNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until {@link Collection#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#isEmpty()} is {@code false}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilIsNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilIsNotEmpty(a.timeout(), a.unit());
	}
	
	//TODO
//	public int waitUntilSizeIsEqualTo(int value) throws InterruptedException;
//	public int waitUntilSizeIsEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsNotEqualTo(int value) throws InterruptedException;
//	public int waitUntilSizeIsNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsNotEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThan(int value) throws InterruptedException;
//	public int waitUntilSizeIsLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThan(int value, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThanOrEqualTo(int value) throws InterruptedException;
//	public int waitUntilSizeIsLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThan(int value) throws InterruptedException;
//	public int waitUntilSizeIsGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThan(int value, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThanOrEqualTo(int value) throws InterruptedException;
//	public int waitUntilSizeIsGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException;
//	
	//TODO
//	public int waitUntilSizeIsEqualTo(IntegerObservable o) throws InterruptedException;
//	public int waitUntilSizeIsEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsNotEqualTo(IntegerObservable o) throws InterruptedException;
//	public int waitUntilSizeIsNotEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsNotEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThan(IntegerObservable o) throws InterruptedException;
//	public int waitUntilSizeIsLessThan(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThan(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThanOrEqualTo(IntegerObservable o) throws InterruptedException;
//	public int waitUntilSizeIsLessThanOrEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsLessThanOrEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThan(IntegerObservable o) throws InterruptedException;
//	public int waitUntilSizeIsGreaterThan(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThan(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThanOrEqualTo(IntegerObservable o) throws InterruptedException;
//	public int waitUntilSizeIsGreaterThanOrEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public int waitUntilSizeIsGreaterThanOrEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException;
	
}
