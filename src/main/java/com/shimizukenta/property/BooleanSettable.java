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
	 * @param value is boolean
	 * 
	 * @see #setTrue()
	 * @see #setFalse()
	 */
	public void set(boolean value);
	
	/**
	 * true setter.
	 * 
	 * @see #setFalse()
	 * @see #set(boolean)
	 */
	default void setTrue() {
		this.set(true);
	}
	
	/**
	 * false setter.
	 * 
	 * @see #setTrue()
	 * @see #set(boolean)
	 */
	default void setFalse() {
		this.set(false);
	}
	
}
