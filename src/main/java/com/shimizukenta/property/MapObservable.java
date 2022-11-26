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
	public V waitUntilContainsKey(Object key) throws InterruptedException;
	
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
	public V waitUntilContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
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
	public V waitUntilContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException;
	
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
	public void waitUntilNotContainsKey(Object key) throws InterruptedException;
	
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
	public void waitUntilNotContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
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
	public void waitUntilNotContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException;
	
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
	public void waitUntilEmpty() throws InterruptedException;
	
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
	public void waitUntilEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
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
	public void waitUntilEmpty(TimeGettable p) throws InterruptedException, TimeoutException;
	
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
	public void waitUntilNotEmpty() throws InterruptedException;
	
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
	public void waitUntilNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
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
	public void waitUntilNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException;
	
}
