package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface Settable<T> {
	
//	/**
//	 * Value setter.
//	 * 
//	 * @param value
//	 */
//	public void set(T value);
	
	/**
	 * Bind to observer.
	 * 
	 * @param observer
	 * @return {@code true} if bind success, otherwise {@code false}.
	 */
	public boolean bind(Observable<T> observer);
	
	/**
	 * Unbind to observer.
	 * 
	 * @param observer
	 * @return {@code true} if unbind success, otherwise {@code false}.
	 */
	public boolean unbind(Observable<T> observer);
	
}
