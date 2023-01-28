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
public abstract class AbstractDoubleCompution extends AbstractNumberCompution implements DoubleCompution {
	
	private static final long serialVersionUID = 7765635626320082694L;
	
	@Override
	public boolean isDouble() {
		return true;
	}

	protected static final Double ZERO = Double.valueOf(0.0D);
	
	private final List<Inner> inners = new ArrayList<>();
	private final Function<? super List<? extends Number>, ? extends Number> compute;

	public AbstractDoubleCompution (
			Collection<? extends NumberObservable<? extends Number>> observables,
			Function<? super List<? extends Number>, ? extends Number> compute) {
		
		super(ZERO);
		
		this.compute = compute;
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			o.addChangeListener(i);
		});
	}
	
	protected void compute() {
		this._syncSetAndNotifyChanged(this.compute.apply(
				this.inners.stream()
				.map(Inner::doubleValue)
				.collect(Collectors.toList())));
	}
	
	protected class Inner implements ChangeListener<Number> {
		
		private double last;
		
		protected Inner() {
			this.last = 0.0D;
		}
		
		@Override
		public void changed(Number v) {
			synchronized ( AbstractDoubleCompution.this._sync ) {
				this.last = v.doubleValue();
				AbstractDoubleCompution.this.compute();
			}
		}
		
		protected double doubleValue() {
			return this.last;
		}

	}
	
}
