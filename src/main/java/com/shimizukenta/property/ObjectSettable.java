package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface ObjectSettable<T> extends Settable<T> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(T value);
	
}
