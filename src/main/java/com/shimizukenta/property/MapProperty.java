package com.shimizukenta.property;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Build instance via {@link #newInstance()}.
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key Type
 * @param <V> Value Type
 */
public interface MapProperty<K, V> extends Map<K, V>, MapSettable<K, V>, MapObservable<K, V>, Serializable {
	
	/**
	 * Instance builder.
	 * 
	 * @param <K> Key Type
	 * @param <V> Value Type
	 * @return new-instance.
	 */
	public static <K, V> MapProperty<K, V> newInstance() {
		return newInstance(Collections.emptyMap());
	}
	
	/**
	 * Instance builder.
	 * 
	 * @param <K> Key Type
	 * @param <V> Value Type
	 * @param map
	 * @return new-instance.
	 */
	public static <K, V> MapProperty<K, V> newInstance(Map<? extends K, ? extends V> initial) {
		return new AbstractMapProperty<K, V>(new HashMap<>(initial)){

			private static final long serialVersionUID = -1165018901559222491L;
		};
	}
	
}
