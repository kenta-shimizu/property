package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberProperty<T extends Number> extends Property<T, WritableNumberProperty<T>>, ReadOnlyNumberProperty<T>, WritableNumberProperty<T>, ObservableNumberProperty<T> {
	
}
