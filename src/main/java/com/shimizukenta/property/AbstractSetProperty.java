package com.shimizukenta.property;

import java.util.Set;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 */
public abstract class AbstractSetProperty<E> extends AbstractCollectionProperty<E, Set<E>> implements SetProperty<E> {
	
	private static final long serialVersionUID = -8048912193160707625L;
	
	public AbstractSetProperty(Set<E> initial) {
		super(initial);
	}
	
}
