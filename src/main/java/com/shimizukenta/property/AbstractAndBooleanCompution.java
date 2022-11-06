package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractAndBooleanCompution extends AbstractBooleanCompution {
	
	private static final long serialVersionUID = 6568753237852273736L;
	
	private final Collection<Inner> inners = new ArrayList<>();
	
	protected AbstractAndBooleanCompution(Collection<? extends BooleanObservable> observables) {
		super(Boolean.FALSE);
		
		observables.forEach(o -> {
			Inner i = new Inner();
			this.inners.add(i);
			i.addChangeListener(o);
		});
	}
	
	private void compute() {
		this._set(this.inners.stream().allMatch(Inner::booleanValue));
	}
	
	private class Inner {
		
		private boolean last;
		
		private Inner() {
			this.last = false;
		}
		
		private boolean addChangeListener(BooleanObservable o) {
			return o.addChangeListener(f -> {
				synchronized ( AbstractAndBooleanCompution.this._sync ) {
					this.last = f.booleanValue();
					AbstractAndBooleanCompution.this.compute();
				}
			});
		}
		
		private boolean booleanValue() {
			return this.last;
		}
	}
	
}
