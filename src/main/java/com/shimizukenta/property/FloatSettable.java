/**
 * 
 */
package com.shimizukenta.property;

/**
 * Float value Setter.
 * 
 * @author kenta-shimizu
 * @see NumberSettable
 * @see Float
 *
 */
public interface FloatSettable extends NumberSettable<Float> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(float value);
	
}
