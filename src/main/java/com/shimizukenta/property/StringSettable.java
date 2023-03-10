package com.shimizukenta.property;

/**
 * String value setter.
 * 
 * @author kenta-shimizu
 * @see Settable
 *
 */
public interface StringSettable extends Settable<String> {
	
	/**
	 * String value setter.
	 * 
	 * <p>
	 * if set value is null, set empty string("").<br />
	 * </p>
	 * 
	 * @param value CharSequence
	 */
	public void set(CharSequence value);
}