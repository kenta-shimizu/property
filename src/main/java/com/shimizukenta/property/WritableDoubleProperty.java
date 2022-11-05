package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface WritableDoubleProperty extends WritableNumberProperty<Double> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(double value);
}
