package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T>
 */
public interface Gettable<T> {
	
	/** 
	 * Value getter.
	 * 
	 * @return value.
	 */
	public T get();
	
}
