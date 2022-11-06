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
	default public void set(long value) {
		this.set(Long.valueOf(value));
	}
	
}
