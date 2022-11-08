package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractLongCompution extends AbstractNumberCompution implements LongCompution {
	
	private static final long serialVersionUID = -3048597701111574361L;
	
	protected static final Long ZERO = Long.valueOf(0L);
	protected static final Long MAX = Long.valueOf(Long.MAX_VALUE);
	protected static final Long MIN = Long.valueOf(Long.MIN_VALUE);
	
	public AbstractLongCompution(Long initial) {
		super(initial);
	}
	
	protected void _set(long value) {
		this._set(Long.valueOf(value));
	}
	
	abstract protected void compute();
	
	protected class Inner {
		
		private long last;
		
		protected Inner() {
			this.last = 0L;
		}
		
		protected boolean addChangeListener(NumberObservable<? extends Number> o) {
			return o.addChangeListener(n -> {
				synchronized ( AbstractLongCompution.this._sync ) {
					this.last = n.longValue();
					AbstractLongCompution.this.compute();
				}
			});
		}
		
		protected long longValue() {
			return this.last;
		}
	}

}
