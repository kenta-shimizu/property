package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public abstract class AbstractObjectCompution<T> extends AbstractCompution<T> implements ObjectCompution<T> {
	
	private static final long serialVersionUID = -6430868710751824657L;
	
	public AbstractObjectCompution(T initial) {
		super(initial);
	}
	
	@Override
	public T get() {
		return this._simpleGet();
	}
	
}
