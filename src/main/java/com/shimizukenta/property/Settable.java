package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T>
 */
public interface Settable<T> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(T value);
	
}
