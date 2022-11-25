package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractUnmodifiableIntegerProperty extends AbstractIntegerProperty {
	
	private static final long serialVersionUID = -5048333628118693243L;
	
	public AbstractUnmodifiableIntegerProperty(int initial) {
		super(initial);
	}
	
	@Override
	public void set(int value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Integer> l) {
		l.changed(this._simpleGet());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Integer> l) {
		return true;
	}
	
}
