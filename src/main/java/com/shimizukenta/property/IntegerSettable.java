package com.shimizukenta.property;

/**
 * @author kenta-shimizu
 *
 */
public interface IntegerSettable extends NumberSettable<Integer> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(int value);
	
}
