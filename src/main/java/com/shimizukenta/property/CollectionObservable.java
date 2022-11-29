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
	default public void waitUntilContains(Object o) throws InterruptedException {
		CollectionWaitUntil.getInstance().contains(this, true, o);
	}
	
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
	default public void waitUntilContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().contains(this, true, o, timeout, unit);
	}
	
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
		CollectionWaitUntil.getInstance().contains(this, true, o, p);
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
	default public void waitUntilNotContains(Object o) throws InterruptedException {
		CollectionWaitUntil.getInstance().contains(this, false, o);
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
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().contains(this, false, o, timeout, unit);
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
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContains(Object o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().contains(this, false, o, p);
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
	default public void waitUntilContainsAll(Collection<?> c) throws InterruptedException {
		CollectionWaitUntil.getInstance().containsAll(this, true, c);
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
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().containsAll(this, true, c, timeout, unit);
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
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().containsAll(this, true, c, p);
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
	default public void waitUntilNotContainsAll(Collection<?> c) throws InterruptedException {
		CollectionWaitUntil.getInstance().containsAll(this, false, c);
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
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().containsAll(this, false, c, timeout, unit);
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
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().containsAll(this, true, c, p);
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
	default public void waitUntilIsEmpty() throws InterruptedException {
		CollectionWaitUntil.getInstance().isEmpty(this, true);
	}
	
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
	default public void waitUntilIsEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().isEmpty(this, true, timeout, unit);
	}
	
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
		CollectionWaitUntil.getInstance().isEmpty(this, true, p);
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
	default public void waitUntilIsNotEmpty() throws InterruptedException {
		CollectionWaitUntil.getInstance().isEmpty(this, false);
	}
	
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
	default public void waitUntilIsNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().isEmpty(this, false, timeout, unit);
	}
	
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
		CollectionWaitUntil.getInstance().isEmpty(this, false, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} == {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} == {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsEqualTo(int value) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsEqualTo(this, value);
	}
	
	/**
	 * Wait until {@link Collection#size()} == {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} == {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsEqualTo(this, value, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} == {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} == {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsEqualTo(this, value, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} != {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} != {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsNotEqualTo(int value) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsNotEqualTo(this, value);
	}
	
	/**
	 * Wait until {@link Collection#size()} != {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} != {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	default public void waitUntilSizeIsNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsNotEqualTo(this, value, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} != {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} != {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	default public void waitUntilSizeIsNotEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsNotEqualTo(this, value, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} < {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} < {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsLessThan(int value) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsLessThan(this, value);
	}
	
	/**
	 * Wait until {@link Collection#size()} < {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} < {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThan(this, value, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} < {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} < {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThan(this, value, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} <= {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} <= {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsLessThanOrEqualTo(int value) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsLessThanOrEqualTo(this, value);
	}
	
	/**
	 * Wait until {@link Collection#size()} <= {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} <= {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutExceptionj if timeout.
	 */
	default public void  waitUntilSizeIsLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThanOrEqualTo(this, value, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} <= {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} <= {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThanOrEqualTo(this, value, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} > {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} > {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsGreaterThan(int value) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThan(this, value);
	}
	
	/**
	 * Wait until {@link Collection#size()} > {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} > {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThan(this, value, timeout, unit);
	}
	
	/**
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThan(this, value, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} >= {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} >= {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsGreaterThanOrEqualTo(int value) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThanOrEqualTo(this, value);
	}
	
	/**
	 * Wait until {@link Collection#size()} >= {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} >= {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThanOrEqualTo(this, value, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} >= {@code value}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} >= {@code value}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThanOrEqualTo(this, value, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} == {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} == {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsEqualTo(IntegerObservable o) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsEqualTo(this, o);
	}
	
	/**
	 * Wait until {@link Collection#size()} == {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} == {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsEqualTo(this, o, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} == {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} == {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsEqualTo(this, o, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} != {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} != {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsNotEqualTo(IntegerObservable o) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsNotEqualTo(this, o);
	}
	
	/**
	 * Wait until {@link Collection#size()} != {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} != {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsNotEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsNotEqualTo(this, o, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} != {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} != {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsNotEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsNotEqualTo(this, o, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} < {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} < {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsLessThan(IntegerObservable o) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsLessThan(this, o);
	}
	
	/**
	 * Wait until {@link Collection#size()} < {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} < {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThan(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThan(this, o, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} < {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} < {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThan(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThan(this, o, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} <= {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} <= {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsLessThanOrEqualTo(IntegerObservable o) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsLessThanOrEqualTo(this, o);
	}
	
	/**
	 * Wait until {@link Collection#size()} <= {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} <= {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThanOrEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThanOrEqualTo(this, o, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} <= {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} <= {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsLessThanOrEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsLessThanOrEqualTo(this, o, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} > {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} > {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsGreaterThan(IntegerObservable o) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThan(this, o);
	}
	
	/**
	 * Wait until {@link Collection#size()} > {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} > {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThan(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThan(this, o, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} > {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} > {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThan(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThan(this, o, p);
	}
	
	/**
	 * Wait until {@link Collection#size()} >= {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} >= {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @throws InterruptedException
	 */
	default public void waitUntilSizeIsGreaterThanOrEqualTo(IntegerObservable o) throws InterruptedException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThanOrEqualTo(this, o);
	}
	
	/**
	 * Wait until {@link Collection#size()} >= {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} >= {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThanOrEqualTo(IntegerObservable o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThanOrEqualTo(this, o, timeout, unit);
	}
	
	/**
	 * Wait until {@link Collection#size()} >= {@code o}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Collection#size()} >= {@code o}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param o
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilSizeIsGreaterThanOrEqualTo(IntegerObservable o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionWaitUntil.getInstance().sizeIsGreaterThanOrEqualTo(this, o, p);
	}
	
}
