package com.shimizukenta.property;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key
 * @param <V> Value
 */
public interface MapProperty<K, V> extends Map<K, V>, MapSettable<K, V>, MapObservable<K, V>, Serializable {
	
	/**
	 * Instance builder.
	 * 
	 * @param <K> Key
	 * @param <V> Value
	 * @return new-instance.
	 */
	public static <K, V> MapProperty<K, V> newInstance() {
		return newInstance(Collections.emptyMap());
	}
	
	/**
	 * Instance builder.
	 * 
	 * @param <K> Key
	 * @param <V> Value
	 * @param map
	 * @return new-instance.
	 */
	public static <K, V> MapProperty<K, V> newInstance(Map<? extends K, ? extends V> initial) {
		return new AbstractMapProperty<K, V>(new HashMap<>(initial)){

			private static final long serialVersionUID = -1165018901559222491L;
		};
	}
	
}
