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
public abstract class AbstractLongCompution extends AbstractNumberCompution implements LongCompution {
	
	private static final long serialVersionUID = -3048597701111574361L;
	
	protected static final Long ZERO = Long.valueOf(0L);
	
	private final List<Inner> inners = new ArrayList<>();
	private final Function<? super List<? extends Number>, ? extends Number> compute;
	
	public AbstractLongCompution(
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
				.map(Inner::longValue)
				.collect(Collectors.toList())));
	}
	
	protected class Inner implements ChangeListener<Number> {
		
		private long last;
		
		protected Inner() {
			this.last = 0L;
		}
		
		@Override
		public void changed(Number v) {
			synchronized ( AbstractLongCompution.this._sync ) {
				this.last = v.longValue();
				AbstractLongCompution.this.compute();
			}
		}
		
		protected long longValue() {
			return this.last;
		}
	}
	
	@Override
	public boolean isLong() {
		return true;
	}
	
}
