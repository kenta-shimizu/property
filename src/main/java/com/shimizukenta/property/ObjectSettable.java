package com.shimizukenta.property;

/**
 * Object value Setter.
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 * @see Settable
 * 
 */
public interface ObjectSettable<T> extends Settable<T> {
	
	/**
	 * Value setter.
	 * 
	 * @param value is {@code <T>}
	 */
	public void set(T value);
	
}
