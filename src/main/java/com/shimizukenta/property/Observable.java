package com.shimizukenta.property;

public interface Observable<T, U extends Settable<T>> {
	
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
	
	/**
	 * Bind Property.
	 * 
	 * @param p
	 * @return true if bind success.
	 */
	public boolean bind(U property);
	
	/**
	 * Unbind property.
	 * 
	 * @param p
	 * @return true if unbind success.
	 */
	public boolean unbind(U property);
	
}
