package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractUnmodifiableLongProperty extends AbstractLongProperty {
	
	private static final long serialVersionUID = -683392877916524097L;
	
	public AbstractUnmodifiableLongProperty(long initial) {
		super(initial);
	}
	
	@Override
	public void set(long value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Long> l) {
		l.changed(this._simpleGet());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Long> l) {
		return true;
	}
}
