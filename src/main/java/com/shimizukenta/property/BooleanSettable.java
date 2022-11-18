package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface BooleanSettable extends Settable<Boolean> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	default public void set(boolean value) {
		this.set(Boolean.valueOf(value));
	}
	
}
