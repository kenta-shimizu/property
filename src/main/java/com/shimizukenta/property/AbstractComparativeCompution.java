package com.shimizukenta.property;

import java.util.Objects;
import java.util.function.BiPredicate;

public abstract class AbstractComparativeCompution<T, U> extends AbstractBooleanCompution implements ComparativeCompution {
	
	private static final long serialVersionUID = -8029429736383936055L;
	
	private final BiPredicate<? super T, ? super U> compute;
	
	private T left;
	private U right;
	
	public AbstractComparativeCompution(
			BiPredicate<? super T, ? super U> compute,
			T leftInitial,
			U rightInitial) {
		
		super(Boolean.valueOf(compute.test(leftInitial, rightInitial)));
		
		this.compute = compute;
		this.left = leftInitial;
		this.right = rightInitial;
	}
	
	public AbstractComparativeCompution(
			BiPredicate<? super T, ? super U> compute) {
		this(compute, null, null);
	}
	
	protected void leftChanged(T v) {
		synchronized ( this._sync ) {
			if (! Objects.equals(v, this.left)) {
				this.left = v;
				this._syncSetAndNotifyChanged(Boolean.valueOf(this.compute.test(this.left, this.right)));
			}
		}
	}
	
	protected void rightChanged(U v) {
		synchronized ( this._sync ) {
			if (! Objects.equals(v, this.right)) {
				this.right = v;
				this._syncSetAndNotifyChanged(Boolean.valueOf(this.compute.test(this.left, this.right)));
			}
		}
	}
	
	private final ChangeListener<T> leftLstnr = this::leftChanged;
	private final ChangeListener<U> rightLstnr = this::rightChanged;
	
	public boolean bindLeft(Observable<? extends T> observer) {
		return observer.addChangeListener(this.leftLstnr);
	}
	
	public boolean unbindLeft(Observable<? extends T> observer) {
		return observer.removeChangeListener(this.leftLstnr);
	}
	
	public boolean bindRight(Observable<? extends U> observer) {
		return observer.addChangeListener(this.rightLstnr);
	}
	
	public boolean unbindRight(Observable<? extends U> observer) {
		return observer.removeChangeListener(this.rightLstnr);
	}
	
}
