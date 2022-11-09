/**
 * 
 */
package com.shimizukenta.property;

import java.util.Objects;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractDoubleProperty extends AbstractNumberProperty<Double> implements DoubleProperty {
	
	private static final long serialVersionUID = 887820836308020057L;
	
	protected AbstractDoubleProperty(double initial) {
		super(Double.valueOf(initial));
	}
	
	@Override
	public void set(Double value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(double value) {
		super.set(Double.valueOf(value));
	}
	
}
