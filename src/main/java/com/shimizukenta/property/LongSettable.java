package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface LongSettable extends NumberSettable<Long> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(long value);
	
}
