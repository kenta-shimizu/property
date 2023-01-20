package com.shimizukenta.property;

import java.util.function.BiPredicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractObjectComparativeCompution<T, U> extends AbstractBooleanCompution implements ComparativeCompution {
	
	private static final long serialVersionUID = 3899597384448057067L;
	
	private T aa;
	private U bb;
	
	public AbstractObjectComparativeCompution(
			ObjectObservable<T> a,
			ObjectObservable<U> b,
			BiPredicate<Object, Object> compute) {
		
		super(Boolean.FALSE);
		
		this.aa = null;
		this.bb = null;
		
		a.addChangeListener(o -> {
			synchronized ( this._sync ) {
				this.aa = o;
				super._syncSetAndNotifyChanged(compute.test(this.aa, this.bb));
			}
		});
		
		b.addChangeListener(o -> {
			synchronized ( this._sync ) {
				this.bb = o;
				super._syncSetAndNotifyChanged(compute.test(this.aa, this.bb));
			}
		});
		
	}
	
}
