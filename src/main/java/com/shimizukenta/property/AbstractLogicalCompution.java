package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractLogicalCompution extends AbstractBooleanCompution implements LogicalCompution {
	
	private static final long serialVersionUID = -2112273633179075099L;
	
	private final List<Inner> inners = new ArrayList<>();
	private final Predicate<? super List<? extends Boolean>> compute;
	
	public AbstractLogicalCompution(
			Collection<? extends BooleanObservable> observables,
			Predicate<? super List<? extends Boolean>> compute) {
		
		super(Boolean.FALSE);
		
		this.compute = compute;
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	protected void compute() {
		this._set(this.compute.test(
				this.inners.stream()
				.map(Inner::booleanValue)
				.collect(Collectors.toList())));
	}
	
	protected class Inner {
		
		private boolean last;
		
		protected Inner() {
			this.last = false;
		}
		
		protected boolean addChangeListener(BooleanObservable observable) {
			return observable.addChangeListener(f -> {
				synchronized ( AbstractLogicalCompution.this._sync ) {
					this.last = f.booleanValue();
					AbstractLogicalCompution.this.compute();
				}
			});
		}
		
		protected boolean booleanValue() {
			return this.last;
		}
	}
	
}
