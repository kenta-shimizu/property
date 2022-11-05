/**
 * 
 */
package com.shimizukenta.property;

/**
 * @author kenta-shimizu
 *
 */
public interface WritableFloatProperty extends WritableNumberProperty<Float> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(float value);
	
}
