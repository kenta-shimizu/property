/**
 * 
 */
package com.shimizukenta.property;

/**
 * @author kenta-shimizu
 *
 */
public interface WritableIntegerProperty extends WritableNumberProperty<Integer> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(int value);
	
}
