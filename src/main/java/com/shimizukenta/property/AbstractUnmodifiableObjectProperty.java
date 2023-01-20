package com.shimizukenta.property;

public abstract class AbstractUnmodifiableObjectProperty<T> extends AbstractObjectProperty<T> {
	
	private static final long serialVersionUID = 1122655569059560817L;
	
	protected AbstractUnmodifiableObjectProperty(T initial) {
		super(initial);
	}
	
	@Override
	public void set(T v) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super T> l) {
		l.changed(this._simpleGet());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super T> l) {
		return true;
	}
	
}
