package com.shimizukenta.property;

import java.util.Collection;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;

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
	
	
	//TODO
///	
//	public void waitUntilNotContains(Object o) throws InterruptedException;
//	public void waitUntilNotContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public void waitUntilNotContains(Object o, TimeGettable p) throws InterruptedException, TimeoutException;
//	
//	public void waitUntilContainsAll(Collection<?> c) throws InterruptedException;
//	public void waitUntilContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public void waitUntilContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException;
//	
//	public void waitUntilNotContainsAll(Collection<?> c) throws InterruptedException;
//	public void waitUntilNotContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public void waitUntilNotContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException;
//	
//	public void waitUntilEmpty() throws InterruptedException;
//	public void waitUntilEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public void waitUntilEmpty(TimeGettable p) throws InterruptedException, TimeoutException;
//	
//	public void waitUntilNotEmpty() throws InterruptedException;
//	public void waitUntilNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
//	public void waitUntilNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException;
//	
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
