package com.shimizukenta.property;

import java.util.List;

/**
 * List value Compution, includes List-methods, Observer.
 * 
 * <p>
 * Unsupport List-methods to change value.<br />
 * </p>
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @see List
 * @see CollectionCompution
 * @see ListObservable
 */
public interface ListCompution<E> extends List<E>, CollectionCompution<E, List<E>>, ListObservable<E> {

}
