package com.shimizukenta.property;

/**
 * Super Setter interface.
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface Settable<T> {
	
	/**
	 * Bind to observer.
	 * 
	 * @param observer
	 * @return {@code true} if bind success, otherwise {@code false}.
	 * @see #unbind(Observable)
	 */
	public boolean bind(Observable<? extends T> observer);
	
	/**
	 * Unbind to observer.
	 * 
	 * @param observer
	 * @return {@code true} if unbind success, otherwise {@code false}.
	 * @see #bind(Observable)
	 */
	public boolean unbind(Observable<? extends T> observer);
	
}
