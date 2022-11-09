package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractFloatCompution extends AbstractNumberCompution implements FloatCompution {
	
	private static final long serialVersionUID = 8670099100553903571L;
	
	protected static final Float ZERO = Float.valueOf(0.0F);
	
	private final List<Inner> inners = new ArrayList<>();
	private final Function<? super List<? extends Number>, ? extends Number> compute;
	
	public AbstractFloatCompution(
			Collection<? extends NumberObservable<? extends Number>> observables,
			Function<? super List<? extends Number>, ? extends Number> compute) {
		
		super(ZERO);
		
		this.compute = compute;
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	protected void compute() {
		this._set(this.compute.apply(
				this.inners.stream()
				.map(Inner::floatValue)
				.collect(Collectors.toList())));
	}
	
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
