package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key
 * @param <V> Value
 */
public interface MapSettable<K, V> {
	
	/**
	 * Bind to observer.
	 * 
	 * @param observer
	 * @return true if bind success.
	 */
	public boolean bind(MapObservable<K, V> observer);
	
	/**
	 * Unbind to observer.
	 * 
	 * @param observer
	 * @return true if unbind success.
	 */
	public boolean unbind(MapObservable<K, V> observer);
	
}
