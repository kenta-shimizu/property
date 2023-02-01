package com.shimizukenta.property;

/**
 * Super Observer interface.
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface Observable<T> {
	
	/**
	 * Add change-listener.
	 * 
	 * @param l
	 * @return true if add success.
	 * @see #removeChangeListener(ChangeListener)
	 */
	public boolean addChangeListener(ChangeListener<? super T> l);
	
	/**
	 * Remove change-listener.
	 * 
	 * @param l
	 * @return true if remove success.
	 * @see #addChangeListener(ChangeListener)
	 */
	public boolean removeChangeListener(ChangeListener<? super T> l);
	
}
