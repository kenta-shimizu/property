package com.shimizukenta.property;

/**
 * Long value Setter.
 * 
 * @author kenta-shimizu
 * @see Long
 * @see NumberSettable
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
