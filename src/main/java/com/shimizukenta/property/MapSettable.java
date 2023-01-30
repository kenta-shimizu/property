package com.shimizukenta.property;

import java.util.Map;

/**
 * Map value Setter.
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key Type
 * @param <V> Value Type
 * @see Map
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
