package com.shimizukenta.property;

import java.util.Set;

/**
 * Set value Compution, includes Set-methods, Observer.
 * 
 * <p>
 * Unsupport Set-methods to change value.<br />
 * </p>

 * @author kenta-shimizu
 *
 * @param <E> Element
 * @see Set
 * @see CollectionCompution
 * @see SetObservable
 */
public interface SetCompution<E> extends Set<E>, CollectionCompution<E, Set<E>>, SetObservable<E> {
	
}
