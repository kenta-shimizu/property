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
	public void set(boolean value);
	
}
