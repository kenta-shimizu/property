package com.shimizukenta.property;

/**
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
	 */
	public boolean addChangeListener(ChangeListener<? super T> l);
	
	/**
	 * Remove change-listener.
	 * 
	 * @param l
	 * @return true if remove success.
	 */
	public boolean removeChangeListener(ChangeListener<? super T> l);
	
}
