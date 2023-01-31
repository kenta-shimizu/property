package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * List value Property, include List-methods, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance()}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @see List
 * @see CollectionProperty
 * @see ListObservable
 * @see ListSettable
 */
public interface ListProperty<E> extends List<E>, CollectionProperty<E, List<E>>, ListObservable<E>, ListSettable<E> {
	
	/**
	 * Instance builder.
	 * 
	 * @param <E> Element
	 * @return new-instance.
	 */
	public static <E> ListProperty<E> newInstance() {
		return newInstance(Collections.emptyList());
	}
	
	/**
	 * Instance builder.
	 * 
	 * @param <E> Element
	 * @param initial-List.
	 * @return new-instance.
	 */
	public static <E> ListProperty<E> newInstance(Collection<? extends E> initial) {
		return new AbstractListProperty<E>(new ArrayList<>(initial)) {
			
			private static final long serialVersionUID = -6240774667722761630L;
		};
	}

}
