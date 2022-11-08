package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractMaxDoubleCompution extends AbstractDoubleCompution {
	
	private static final long serialVersionUID = -3880816206941512450L;
	
	private final Collection<Inner> inners = new ArrayList<>();
	
	public AbstractMaxDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		super(MIN);
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}

	@Override
	protected void compute() {
		double v = Double.NEGATIVE_INFINITY;
		for ( Inner i : this.inners ) {
			double x = i.doubleValue();
			if ( x > v ) {
				v = x;
			}
		}
		this._set(v);
	}

}
