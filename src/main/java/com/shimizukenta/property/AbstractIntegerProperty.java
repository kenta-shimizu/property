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
public abstract class AbstractIntegerProperty extends AbstractNumberProperty<Integer> implements IntegerProperty {
	
	private static final long serialVersionUID = -305818540574009744L;
	
	protected AbstractIntegerProperty(int initial) {
		super(Integer.valueOf(initial));
	}
	
	@Override
	public void set(Integer value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(int value) {
		super.set(Integer.valueOf(value));
	}
	
	@Override
	public boolean isInteger() {
		return true;
	}
	
}
