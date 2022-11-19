package com.shimizukenta.property;

import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @param <T> Type
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
	
}
