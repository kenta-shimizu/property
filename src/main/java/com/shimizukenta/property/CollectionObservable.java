package com.shimizukenta.property;

import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E>
 * @param <T>
 */
public interface CollectionObservable<E, T extends Collection<E>> {
	
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
	 * @param observable
	 * @return true if bind success.
	 */
	public boolean bind(CollectionObservable<E, T> observable);
	
	/**
	 * Unbind property.
	 * 
	 * @param observable
	 * @return true if unbind success.
	 */
	public boolean unbind(CollectionObservable<E, T> observable);
	
	public void set(T c);
	
}
