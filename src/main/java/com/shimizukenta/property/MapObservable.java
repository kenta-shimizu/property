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
public interface MapObservable<K, V> extends Observable<Map<K, V>> {
	
	/**
	/**
	 * Returns {@link BooleanCompution} of {@link Map#containsKey(Object)} == {@code true}.
	 * 
	 * @param key
	 * @return {@link BooleanCompution} of {@link Map#containsKey(Object)} == {@code true}
	 */
	default public BooleanCompution computeContainsKey(Object key) {
		return MapUtils.computeContainsKey(this, key);
	}
	
	/**
	 * Returns {@link BooleanCompution} of {@link Map#containsKey(Object)} == {@code false}.
	 * 
	 * @param key
	 * @return {@link BooleanCompution} of {@link Map#containsKey(Object)} == {@code false}
	 */
	default public BooleanCompution computeNotContainsKey(Object key) {
		return MapUtils.computeNotContainsKey(this, key);
	}
	
	/**
	 * Returns {@link BooleanCompution} of {@link Map#isEmpty()} == {@code true}.
	 * 
	 * @return {@link BooleanCompution} of {@link Map#isEmpty()} == {@code true}
	 */
	default public BooleanCompution computeIsEmpty() {
		return MapUtils.computeIsEmpty(this);
	}
	
	/**
	 * Returns {@link BooleanCompution} of {@link Map#isEmpty()} == {@code false}.
	 * 
	 * @return {@link BooleanCompution} of {@link Map#isEmpty()} == {@code false}
	 */
	default public BooleanCompution computeIsNotEmpty() {
		return MapUtils.computeIsNotEmpty(this);
	}
	
	/**
	 * Returns {@link SetCompution} of {@link Map#keySet()}.
	 * 
	 * @return {@link SetCompution} of {@link Map#keySet()}
	 */
	default public SetCompution<K> computeKeySet() {
		return MapUtils.computeKeySet(this);
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
	 * @return {@link Map#get(Object)}
	 * @throws InterruptedException
	 */
	default public V waitUntilContainsKeyAndGet(Object key) throws InterruptedException {
		return MapUtils.waitUntilContainsKey(this, key);
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
	default public V waitUntilContainsKeyAndGet(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		return MapUtils.waitUntilContainsKey(this, key, timeout, unit);
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
	 * @param p is TimeProperty
	 * @return {@link Map#get(Object)}
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public V waitUntilContainsKeyAndGet(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		return MapUtils.waitUntilContainsKey(this, key, p);
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
		MapUtils.waitUntilNotContainsKey(this, key);
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
		MapUtils.waitUntilNotContainsKey(this, key, timeout, unit);
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
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		MapUtils.waitUntilNotContainsKey(this, key, p);
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
	default public void waitUntilIsEmpty() throws InterruptedException {
		MapUtils.waitUntilIsEmpty(this);
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
	default public void waitUntilIsEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		MapUtils.waitUntilIsEmpty(this, timeout, unit);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code true}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilIsEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		MapUtils.waitUntilIsEmpty(this, p);
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
	default public void waitUntilIsNotEmpty() throws InterruptedException {
		MapUtils.waitUntilIsNotEmpty(this);
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
	default public void waitUntilIsNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		MapUtils.waitUntilIsNotEmpty(this, timeout, unit);
	}
	
	/**
	 * Wait until {@link Map#isEmpty()} is {@code false}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already <b>NOT</b> empty, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilIsNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		MapUtils.waitUntilIsNotEmpty(this, p);
	}
	
}
