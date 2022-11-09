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
public abstract class AbstractLongProperty extends AbstractNumberProperty<Long> implements LongProperty {
	
	private static final long serialVersionUID = 9186020409952044558L;

	protected AbstractLongProperty(long initial) {
		super(Long.valueOf(initial));
	}
	
	@Override
	public void set(Long value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(long value) {
		super.set(Long.valueOf(value));
	}
	
}
