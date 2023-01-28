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
public abstract class AbstractIntegerCompution extends AbstractNumberCompution implements IntegerCompution {
	
	private static final long serialVersionUID = 8925963972017058242L;
	
	@Override
	public boolean isInteger() {
		return true;
	}
	
	protected static final Integer ZERO = Integer.valueOf(0);
	
	private final List<Inner> inners = new ArrayList<>();
	private final Function<? super List<? extends Number>, ? extends Number> compute;
	
	public AbstractIntegerCompution(
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
				.map(Inner::intValue)
				.collect(Collectors.toList())));
	}
	
	protected class Inner implements ChangeListener<Number> {
		
		private int last;
		
		protected Inner() {
			this.last = 0;
		}
		
		@Override
		public void changed(Number v) {
			synchronized ( AbstractIntegerCompution.this._sync ) {
				this.last = v.intValue();
				AbstractIntegerCompution.this.compute();
			}
		}
		
		protected int intValue() {
			return this.last;
		}
	}
	
}
