package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractMultiplyDoubleCompution extends AbstractDoubleCompution {
	
	private static final long serialVersionUID = 2087866763289246729L;
	
	private final Collection<Inner> inners = new ArrayList<>();
	
	public AbstractMultiplyDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		super(ZERO);
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	@Override
	protected void compute() {
		double v = 1.0D;
		for ( Inner i : this.inners ) {
			v *= i.doubleValue();
		}
		super._set(v);
	}
	
}
