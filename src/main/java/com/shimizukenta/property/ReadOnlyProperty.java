package com.shimizukenta.property;

public interface ReadOnlyProperty<T> {
	
	/** 
	 * Value getter.
	 * 
	 * @return value
	 */
	public T get();
	
}
