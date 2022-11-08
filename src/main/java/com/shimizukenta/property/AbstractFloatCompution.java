package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractFloatCompution extends AbstractNumberCompution implements FloatCompution {
	
	private static final long serialVersionUID = 8670099100553903571L;
	
	protected static final Float ZERO = Float.valueOf(0.0F);
	protected static final Float MAX = Float.valueOf(Float.POSITIVE_INFINITY);
	protected static final Float MIN = Float.valueOf(Float.NEGATIVE_INFINITY);
	
	public AbstractFloatCompution(Float initial) {
		super(initial);
	}
	
	protected void _set(float value) {
		this._set(Float.valueOf(value));
	}
	
	abstract protected void compute();
	
	protected class Inner {
		
		private float last;
		
		protected Inner() {
			this.last = 0.0F;
		}
		
		protected boolean addChangeListener(NumberObservable<? extends Number> o) {
			return o.addChangeListener(n -> {
				synchronized ( AbstractFloatCompution.this._sync ) {
					this.last = n.floatValue();
					AbstractFloatCompution.this.compute();
				}
			});
		}
		
		protected float floatValue() {
			return this.last;
		}
	}
	
}
