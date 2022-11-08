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
	default public void set(double value) {
		this.set(Double.valueOf(value));
	}
	
}
