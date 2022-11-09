package com.shimizukenta.property;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractComparativeCompution extends AbstractBooleanCompution implements ComparativeCompution {
	
	private static final long serialVersionUID = -816757692555711048L;
	
	private static final Integer ZERO = Integer.valueOf(0);
	
	private Number left;
	private Number right;
	
	public AbstractComparativeCompution(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			BiPredicate<? super Number, ? super Number> compute) {
		
		super(Boolean.FALSE);
		
		this.left = ZERO;
		this.right = ZERO;
		
		left.addChangeListener(n -> {
			synchronized ( this._sync ) {
				if ( ! Objects.equals(this.left, n) ) {
					this.left = n;
					this._set(compute.test(n, this.right));
				}
			}
		});
		
		right.addChangeListener(n -> {
			synchronized ( this._sync ) {
				if ( ! Objects.equals(this.right, n) ) {
					this.right = n;
					this._set(compute.test(this.left, n));
				}
			}
		});
	}
	
}
