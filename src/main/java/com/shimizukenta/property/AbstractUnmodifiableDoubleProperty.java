package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractUnmodifiableDoubleProperty extends AbstractDoubleProperty {
	
	private static final long serialVersionUID = -5135301534592947617L;
	
	public AbstractUnmodifiableDoubleProperty(double initial) {
		super(initial);
	}
	
	@Override
	public void set(Double value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void set(double value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Double> l) {
		l.changed(this._get());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Double> l) {
		return true;
	}

}
