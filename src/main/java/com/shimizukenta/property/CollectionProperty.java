package com.shimizukenta.property;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @param <T> Type
 */
public interface CollectionProperty<E, T extends Collection<E>> extends Collection<E>, CollectionObservable<E, T>, Serializable {

}
