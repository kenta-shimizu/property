package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public abstract class AbstractObjectProperty<T> extends AbstractProperty<T> implements ObjectProperty<T> {
	
	private static final long serialVersionUID = -8210275327751090005L;
	
	protected AbstractObjectProperty(T initial) {
		super(initial);
	}
	
	@Override
	public void set(T value) {
		this._syncSetAndNotifyChanged(value);
	}
	
	@Override
	public T get() {
		return this._simpleGet();
	}
	
}
