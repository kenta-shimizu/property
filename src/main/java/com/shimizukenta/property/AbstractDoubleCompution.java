package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractDoubleCompution extends AbstractNumberCompution implements DoubleCompution {

	private static final long serialVersionUID = 913309491368083166L;
	
	protected static final Double ZERO = Double.valueOf(0.0D);
	protected static final Double MAX = Double.valueOf(Double.POSITIVE_INFINITY);
	protected static final Double MIN = Double.valueOf(Double.NEGATIVE_INFINITY);
	
	public AbstractDoubleCompution(Double initial) {
		super(initial);
	}
	
	protected void _set(double value) {
		super._set(Double.valueOf(value));
	}
	
	abstract protected void compute();
	
	protected class Inner {
		
		private double last;
		
		protected Inner() {
			this.last = 0.0D;
		}
		
		protected boolean addChangeListener(NumberObservable<? extends Number> o) {
			return o.addChangeListener(n -> {
				synchronized ( AbstractDoubleCompution.this._sync ) {
					this.last = n.doubleValue();
					AbstractDoubleCompution.this.compute();
				}
			});
		}
		
		protected double doubleValue() {
			return this.last;
		}
	}

}
