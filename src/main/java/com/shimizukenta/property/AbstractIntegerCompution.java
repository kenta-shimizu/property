package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractIntegerCompution extends AbstractNumberCompution implements IntegerCompution {
	
	private static final long serialVersionUID = 8925963972017058242L;
	
	protected static final Integer ZERO = Integer.valueOf(0);
	protected static final Integer MAX = Integer.valueOf(Integer.MAX_VALUE);
	protected static final Integer MIN = Integer.valueOf(Integer.MIN_VALUE);
	
	public AbstractIntegerCompution(Integer initial) {
		super(initial);
	}
	
	protected void _set(int value) {
		this._set(Integer.valueOf(value));
	}
	
	abstract protected void compute();
	
	protected class Inner {
		
		private int last;
		
		protected Inner() {
			this.last = 0;
		}
		
		protected boolean addChangeListener(NumberObservable<? extends Number> o) {
			return o.addChangeListener(n -> {
				synchronized ( AbstractIntegerCompution.this._sync ) {
					this.last = n.intValue();
					AbstractIntegerCompution.this.compute();
				}
			});
		}
		
		protected int intValue() {
			return this.last;
		}
	}
	
}
