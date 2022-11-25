package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
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
