package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T>
 */
public interface NullableProperty<T> extends Property<T, Settable<T>>, NullableObservable<T> {
	
	public static <T> NullableProperty<T> newInstance(T initial) {
		
		//TODO
		return null;
	}
}
