package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractUnmodifiableDoubleProperty extends AbstractDoubleProperty {
	
	private static final long serialVersionUID = -5135301534592947617L;
	
	/**
	 * Constructor.
	 * 
	 * @param initial is double
	 */
	public AbstractUnmodifiableDoubleProperty(double initial) {
		super(initial);
	}
	
	@Override
	public void set(double value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Double> l) {
		l.changed(this._simpleGet());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Double> l) {
		return true;
	}
	
	@Override
	public boolean bind(Observable<? extends Double> observer) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean unbind(Observable<? extends Double> observer) {
		throw new UnsupportedOperationException();
	}
}
