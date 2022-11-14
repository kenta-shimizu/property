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
	
	/**
	 * Bind Property.
	 * 
	 * @param observable
	 * @return true if bind success.
	 */
	public boolean bind(MapObservable<K, V> observable);
	
	/**
	 * Unbind property.
	 * 
	 * @param observable
	 * @return true if unbind success.
	 */
	public boolean unbind(MapObservable<K, V> observable);
	
	/**
	 * Mew-map Setter.
	 * 
	 * @param newMap
	 */
	public void set(Map<? extends K, ? extends V> newMap);
	
	public V waitUntilContainsKey(Object key) throws InterruptedException;
	
	public V waitUntilContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public V waitUntilContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		return this.waitUntilContainsKey(key, a.timeout(), a.unit());
	}
	
	public void waitUntilNotContainsKey(Object key) throws InterruptedException;
	
	public void waitUntilNotContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilNotContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotContainsKey(key, a.timeout(), a.unit());
	}
	
}
