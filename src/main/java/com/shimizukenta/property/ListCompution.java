package com.shimizukenta.property;

import java.util.List;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 */
public interface ListCompution<E> extends List<E>, CollectionProperty<E, List<E>>, ListObservable<E> {

}
