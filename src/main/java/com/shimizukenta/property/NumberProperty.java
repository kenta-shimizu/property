package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberProperty<T extends Number> extends Property<T, NumberSettable<T>>, NumberGettable<T>, NumberSettable<T>, NumberObservable<T> {
	
}
