package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractUnmodifiableFloatProperty extends AbstractFloatProperty {
	
	private static final long serialVersionUID = -3898415749998088493L;
	
	public AbstractUnmodifiableFloatProperty(float initial) {
		super(initial);
	}
	
	@Override
	public void set(Float value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void set(float value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Float> l) {
		l.changed(this._get());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Float> l) {
		return true;
	}
	
}
