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
	 * @return {@code true} if bind success, otherwise {@code false}.
	 */
	public boolean bind(CollectionObservable<E, T> observer);
	
	/**
	 * Unbind to observer.
	 * 
	 * @param observer
	 * @return {@code true} if unbind success, otherwise {@code false}.
	 */
	public boolean unbind(CollectionObservable<E, T> observer);
	
}
