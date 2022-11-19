package com.shimizukenta.property;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key
 * @param <V> Value
 */
public interface MapObservable<K, V> {
	
	/**
	 * Add change-listener.
	 * 
	 * @param l
	 * @return true if add success.
	 */
	public boolean addChangeListener(ChangeListener<? super Map<K, V>> l);
	
	/**
	 * Remove change-listener.
	 * 
	 * @param l
	 * @return true if remove success.
	 */
	public boolean removeChangeListener(ChangeListener<? super Map<K, V>> l);
	
	
	public V waitUntilContainsKey(Object key) throws InterruptedException;
	
	public V waitUntilContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public V waitUntilContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException;
	
	public void waitUntilNotContainsKey(Object key) throws InterruptedException;
	
	public void waitUntilNotContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public void waitUntilNotContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException;
	
}
