package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractNegateDoubleCompution extends AbstractDoubleCompution {
	
	private static final long serialVersionUID = -16585151344138719L;
	
	public AbstractNegateDoubleCompution(NumberObservable<? extends Number> observable) {
		super(ZERO);
		
		observable.addChangeListener(n -> {
			this._set(- n.doubleValue());
		});
	}
	
	@Override
	protected void compute() {
		/* Nothing */
	}
	
}
