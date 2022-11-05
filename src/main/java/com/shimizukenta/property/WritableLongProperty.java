package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface WritableLongProperty extends WritableNumberProperty<Long> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(long value);
	
}
