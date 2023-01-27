package com.shimizukenta.property;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Build instance via {@link #newInstance()}.
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 */
public interface SetProperty<E> extends Set<E>, CollectionProperty<E, Set<E>>, SetObservable<E>, SetSettable<E> {
	
	/**
	 * Instance buidler.
	 * 
	 * @param <E> Element
	 * @return new-instance.
	 */
	public static <E> SetProperty<E> newInstance() {
		return newInstance(Collections.emptySet());
	}
	
	/**
	 * Instance buider.
	 * 
	 * @param <E> Element
	 * @param initial
	 * @return new-instance.
	 */
	public static <E> SetProperty<E> newInstance(Collection<? extends E> initial) {
		return new AbstractSetProperty<E>(new HashSet<>(initial)) {
			
			private static final long serialVersionUID = 1830279783393865791L;
		};
	}
}
