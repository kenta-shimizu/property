package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractMinDoubleCompution extends AbstractDoubleCompution {
	
	private static final long serialVersionUID = 9157262576036369567L;
	
	private final Collection<Inner> inners = new ArrayList<>();
	
	public AbstractMinDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		super(MAX);
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	@Override
	protected void compute() {
		double v = Double.POSITIVE_INFINITY;
		for ( Inner i : this.inners ) {
			double x = i.doubleValue();
			if ( x < v ) {
				v = x;
			}
		}
		this._set(v);
	}

}
