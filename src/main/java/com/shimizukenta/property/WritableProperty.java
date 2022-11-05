package com.shimizukenta.property;

public interface WritableProperty<T> {
	
	/**
	 * Value setter.
	 * 
	 * @param value
	 */
	public void set(T value);
}
