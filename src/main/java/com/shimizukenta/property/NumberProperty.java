package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberProperty<T extends Number> extends Property<T>, NumberGettable<T>, NumberSettable<T>, NumberObservable<T> {
	
}
