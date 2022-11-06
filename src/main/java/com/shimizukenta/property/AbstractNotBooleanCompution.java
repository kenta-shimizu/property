package com.shimizukenta.property;

/**
 * @author kenta- shimizu
 *
 */
public abstract class AbstractNotBooleanCompution extends AbstractBooleanCompution {

	private static final long serialVersionUID = -5855010039601079402L;
	
	protected AbstractNotBooleanCompution(BooleanObservable observer) {
		super(Boolean.FALSE);
		
		observer.addChangeListener(this::compute);
	}
	
	private void compute(Boolean f) {
		this._set(Boolean.valueOf(! f.booleanValue()));
	}
	
}
