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
	
	/**
	 * true setter.
	 */
	default void setTrue() {
		this.set(true);
	}
	
	/**
	 * false setter.
	 */
	default void setFalse() {
		this.set(false);
	}
	
}
