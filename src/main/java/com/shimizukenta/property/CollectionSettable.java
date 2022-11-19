package com.shimizukenta.property;

import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @param <T> Type
 */
public interface CollectionSettable<E, T extends Collection<E>> {
	
	/**
	 * Bind to observer.
	 * 
	 * @param observable
	 * @return true if bind success.
	 */
	public boolean bind(CollectionObservable<E, T> observer);
	
	/**
	 * Unbind to observer.
	 * 
	 * @param observer
	 * @return true if unbind success.
	 */
	public boolean unbind(CollectionObservable<E, T> observer);
	
}
