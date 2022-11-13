package com.shimizukenta.property;

import java.util.Set;

public abstract class AbstractSetProperty<E> extends AbstractCollectionProperty<E, Set<E>> implements SetProperty<E> {
	
	private static final long serialVersionUID = -8048912193160707625L;
	
	protected AbstractSetProperty(Set<E> initial) {
		super(initial);
	}
	
}
