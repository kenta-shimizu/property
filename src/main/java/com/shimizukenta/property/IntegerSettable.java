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
	default public void set(int value) {
		this.set(Integer.valueOf(value));
	}
	
}
