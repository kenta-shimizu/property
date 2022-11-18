/**
 * 
 */
package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface FloatSettable extends NumberSettable<Float> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	default public void set(float value) {
		this.set(Float.valueOf(value));
	}
	
}
