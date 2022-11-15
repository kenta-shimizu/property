package com.shimizukenta.property;

public abstract class AbstractUnmodifiableLongProperty extends AbstractLongProperty {
	
	private static final long serialVersionUID = -683392877916524097L;
	
	public AbstractUnmodifiableLongProperty(long initial) {
		super(initial);
	}
	
	@Override
	public void set(Long value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void set(long value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Long> l) {
		l.changed(this._get());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Long> l) {
		return true;
	}
}
