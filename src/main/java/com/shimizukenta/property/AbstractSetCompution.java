package com.shimizukenta.property;

import java.util.Collections;
import java.util.Set;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 */
public abstract class AbstractSetCompution<E> extends AbstractCollectionCompution<E, Set<E>> implements SetCompution<E> {
	
	private static final long serialVersionUID = -1315255332960926810L;
	
	public AbstractSetCompution(Set<E> initial) {
		super(initial);
	}
	
	@Override
	protected Set<E> _unmodifiableCollection(Set<E> c) {
		return Collections.unmodifiableSet(c);
	}
	
}
