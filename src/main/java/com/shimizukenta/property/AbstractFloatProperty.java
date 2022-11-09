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
public abstract class AbstractFloatProperty extends AbstractNumberProperty<Float> implements FloatProperty {

	private static final long serialVersionUID = 7439939403442859342L;

	protected AbstractFloatProperty(float initial) {
		super(Float.valueOf(initial));
	}
	
	@Override
	public void set(Float value) {
		super.set(Objects.requireNonNull(value));
	}

	@Override
	public void set(float value) {
		super.set(Float.valueOf(value));
	}
	
}
