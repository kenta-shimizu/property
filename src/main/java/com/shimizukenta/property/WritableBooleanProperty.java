package com.shimizukenta.property;

public interface WritableBooleanProperty extends WritableProperty<Boolean> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(boolean value);
}
