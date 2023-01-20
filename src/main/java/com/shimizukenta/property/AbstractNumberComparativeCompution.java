package com.shimizukenta.property;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractNumberComparativeCompution extends AbstractBooleanCompution implements ComparativeCompution {
	
	private static final long serialVersionUID = 1718185692682962826L;
	
	private static final Integer ZERO = Integer.valueOf(0);
	
	private Number left;
	private Number right;
	
	public AbstractNumberComparativeCompution(
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
					this._syncSetAndNotifyChanged(compute.test(this.left, this.right));
				}
			}
		});
		
		right.addChangeListener(n -> {
			synchronized ( this._sync ) {
				if ( ! Objects.equals(this.right, n) ) {
					this.right = n;
					this._syncSetAndNotifyChanged(compute.test(this.left, this.right));
				}
			}
		});
	}
	
}
