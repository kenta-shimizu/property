package com.shimizukenta.property;

/**
 * Double value Setter.
 * 
 * @author kenta-shimizu
 * @see NumberSettable
 * @see Double
 *
 */
public interface DoubleSettable extends NumberSettable<Double> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(double value);
	
}
