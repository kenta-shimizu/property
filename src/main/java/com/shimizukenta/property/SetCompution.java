package com.shimizukenta.property;

import java.util.Set;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 */
public interface SetCompution<E> extends Set<E>, CollectionProperty<E, Set<E>>, SetObservable<E> {
	
}
