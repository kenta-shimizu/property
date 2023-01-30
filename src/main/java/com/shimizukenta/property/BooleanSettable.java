package com.shimizukenta.property;

/**
 * Boolean value Setter.
 * 
 * @author kenta-shimizu
 * @see Boolean
 * @see Settable
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
