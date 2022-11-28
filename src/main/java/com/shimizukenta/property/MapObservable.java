package com.shimizukenta.property;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key Type
 * @param <V> Value Type
 */
public interface MapObservable<K, V> {
	
	/**
	 * Add change-listener.
	 * 
	 * @param listener
	 * @return {@code true} if add success, otherwise {@code false}.
	 */
	public boolean addChangeListener(ChangeListener<? super Map<K, V>> listener);
	
	/**
	 * Remove change-listener.
	 * 
	 * @param listener
	 * @return {@code true} if remove success, otherwise {@code false}.
	 */
	public boolean removeChangeListener(ChangeListener<? super Map<K, V>> listener);
	
	/**
	 * Wait until {@link Map#containsKey(Object)} is {@code true}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Map#containsKey(Object)} is true, return value immediately.<br />
	 * </p>
	 * 
	 * @param key
	 * @return {@link Map#get(Object)}
	 * @throws InterruptedException
	 */
	default public V waitUntilContainsKey(Object key) throws InterruptedException {
		return MapWaitUntil.getInstance().waitUntilContainsKey(this, true, key);
	}
	
	/**
	 * Wait until {@link Map#containsKey(Object)} is {@code true}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Map#containsKey(Object)} is true, return value immediately.<br />
	 * </p>
	 * 
	 * @param key
	 * @param timeout
	 * @param unit
	 * @return {@link Map#get(Object)}
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public V waitUntilContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		return MapWaitUntil.getInstance().waitUntilContainsKey(this, true, key, timeout, unit);
	}
	
	/**
	 * Wait until {@link Map#containsKey(Object)} is {@code true}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Map#containsKey(Object)} is true, return value immediately.<br />
	 * </p>
	 * 
	 * @param key
	 * @param p
	 * @return {@link Map#get(Object)}
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public V waitUntilContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		return MapWaitUntil.getInstance().waitUntilContainsKey(this, true, key, p);
	}
	
	/**
	 * Wait until {@link Map#containsKey(Object)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Map#containsKey(Object)} is false, pass through immediately.<br />
	 * </p>
	 * 
	 * @param key
	 * @throws InterruptedException
	 */
	default public void waitUntilNotContainsKey(Object key) throws InterruptedException {
		MapWaitUntil.getInstance().waitUntilContainsKey(this, false, key);
	}
	
	/**
	 * Wait until {@link Map#containsKey(Object)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Map#containsKey(Object)} is false, pass through immediately.<br />
	 * </p>
	 * 
	 * @param key
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		MapWaitUntil.getInstance().waitUntilContainsKey(this, false, key, timeout, unit);
	}
	
	/**
	 * Wait until {@link Map#containsKey(Object)} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already {@link Map#containsKey(Object)} is false, pass through immediately.<br />
	 * </p>
	 * 
	 * @param key
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		MapWaitUntil.getInstance().waitUntilContainsKey(this, false, key, p);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilEmpty() throws InterruptedException {
		MapWaitUntil.getInstance().waitUntilIsEmpty(this, true);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		MapWaitUntil.getInstance().waitUntilIsEmpty(this, true, timeout, unit);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		MapWaitUntil.getInstance().waitUntilIsEmpty(this, true, p);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already <b>NOT</b> empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEmpty() throws InterruptedException {
		MapWaitUntil.getInstance().waitUntilIsEmpty(this, false);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already <b>NOT</b> empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout
	 */
	default public void waitUntilNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		MapWaitUntil.getInstance().waitUntilIsEmpty(this, false, timeout, unit);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already <b>NOT</b> empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		MapWaitUntil.getInstance().waitUntilIsEmpty(this, false, p);
	}
	
}
