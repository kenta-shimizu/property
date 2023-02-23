package com.shimizukenta.property;

/**
 * Integer value Setter.
 * 
 * @author kenta-shimizu
 * @see Integer
 * @see NumberSettable
 *
 */
public interface IntegerSettable extends NumberSettable<Integer> {
	
	/**
	 * Value setter.
	 * 
	 * @param value is int
	 */
	public void set(int value);
	
}
