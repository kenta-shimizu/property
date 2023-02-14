package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public abstract class AbstractPredicateCompution<T> extends AbstractBooleanCompution {
	
	private static final long serialVersionUID = -9033466111311749543L;
	
	protected final Predicate<? super T> _compute;
	private T last;
	
	public AbstractPredicateCompution(
			Predicate<? super T> compute,
			T initial) {
		
		super(Boolean.valueOf(compute.test(initial)));
		
		this._compute = compute;
		this.last = initial;
	}
	
	public AbstractPredicateCompution(Predicate<? super T> compute) {
		this(compute, null);
	}
	
	public T getLastValue() {
		synchronized ( this._sync ) {
			return this.last;
		}
	}
	
	protected void changedValue(T v) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(v, this.last) ) {
				this.last = v;
				this._syncSetAndNotifyChanged(Boolean.valueOf(this._compute.test(v)));
			}
		}
	}
	
	private final ChangeListener<T> bindLstnr = this::changedValue;
	
	public boolean bind(Observable<? extends T> observer) {
		return observer.addChangeListener(this.bindLstnr);
	}
	
	public boolean unbind(Observable<? extends T> observer) {
		return observer.removeChangeListener(this.bindLstnr);
	}
	
	public T waitUntilAndGet(boolean condition) throws InterruptedException {
		synchronized ( this._sync ) {
			this.waitUntil(condition);
			return this.getLastValue();
		}
	}
	
	public T waitUntilAndGet(boolean condition, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		synchronized ( this._sync ) {
			this.waitUntil(condition, timeout, unit);
			return this.getLastValue();
		}
	}
	
	public T waitUntilAndGet(boolean condition, TimeoutGettable p) throws InterruptedException, TimeoutException {
		synchronized ( this._sync ) {
			this.waitUntil(condition, p);
			return this.getLastValue();
		}
	}
	
	public T waitUntilTrueAndGet() throws InterruptedException {
		return this.waitUntilAndGet(true);
	}
	
	public T waitUntilTrueAndGet(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		return this.waitUntilAndGet(true, timeout, unit);
	}
	
	public T waitUntilTrueAndGet(TimeoutGettable p) throws InterruptedException, TimeoutException {
		return this.waitUntilAndGet(true, p);
	}
	
	public T waitUntilFalseAndGet() throws InterruptedException {
		return this.waitUntilAndGet(false);
	}
	
	public T waitUntilFalseAndGet(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		return this.waitUntilAndGet(false, timeout, unit);
	}
	
	public T waitUntilFalseAndGet(TimeoutGettable p) throws InterruptedException, TimeoutException {
		return this.waitUntilAndGet(false, p);
	}

}
