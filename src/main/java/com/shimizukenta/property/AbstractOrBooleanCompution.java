package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractOrBooleanCompution extends AbstractBooleanCompution {

	private static final long serialVersionUID = 6618799540846521836L;
	
	private final Collection<Inner> inners = new ArrayList<>();
	
	protected AbstractOrBooleanCompution(Collection<? extends BooleanObservable> observables) {
		super(Boolean.FALSE);
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	private void compute() {
		this._set(this.inners.stream().anyMatch(Inner::booleanValue));
	}
	
	private class Inner {
		
		private boolean last;
		
		private Inner() {
			this.last = false;
		}
		
		private boolean addChangeListener(BooleanObservable o) {
			return o.addChangeListener(f -> {
				synchronized ( AbstractOrBooleanCompution.this._sync ) {
					this.last = f.booleanValue();
					AbstractOrBooleanCompution.this.compute();
				}
			});
		}
		
		private boolean booleanValue() {
			return this.last;
		}
	}


}
