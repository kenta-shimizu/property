package com.shimizukenta.property;

public abstract class AbstractXorBooleanCompution extends AbstractBooleanCompution {
	
	private static final long serialVersionUID = -2626276268841691934L;
	
	private boolean x;
	private boolean y;
	
	protected AbstractXorBooleanCompution(BooleanObservable a, BooleanObservable b) {
		super(Boolean.FALSE);
		
		a.addChangeListener(f -> {
			synchronized ( this._sync ) {
				this.x = f.booleanValue();
				compute();
			}
		});
		
		b.addChangeListener(f -> {
			synchronized ( this._sync ) {
				this.y = f.booleanValue();
				compute();
			}
		});
	}
	
	private void compute() {
		this._set(Boolean.valueOf(this.x ^ this.y));
	}

}
