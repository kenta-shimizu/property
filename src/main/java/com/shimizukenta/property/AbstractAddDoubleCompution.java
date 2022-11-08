package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractAddDoubleCompution extends AbstractDoubleCompution {
	
	private static final long serialVersionUID = -1087071334093548290L;
	
	private final Collection<Inner> inners = new ArrayList<>();
	
	public AbstractAddDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		super(ZERO);
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	@Override
	protected void compute() {
		double v = 0.0D;
		for ( Inner i : this.inners ) {
			v += i.doubleValue();
		}
		this._set(v);
	}
	
}
