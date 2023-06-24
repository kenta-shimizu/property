package com.shimizukenta.property.impl;

import com.shimizukenta.property.ObjectCompution;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public abstract class AbstractObjectCompution<T> extends AbstractCompution<T> implements ObjectCompution<T> {
	
	private static final long serialVersionUID = -6430868710751824657L;
	
	/**
	 * Constructor.
	 * 
	 * @param initial is extends Object
	 */
	public AbstractObjectCompution(T initial) {
		super(initial);
	}
	
	@Override
	public T get() {
		return this._simpleGet();
	}
	
}
