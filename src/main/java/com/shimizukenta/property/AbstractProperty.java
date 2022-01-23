package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractProperty<T> implements Property<T> {
	
	public AbstractProperty() {
		/* Nothing */
	}
	
	private final Object sync = new Object();
	
	private final Collection<ChangeListener<T>> changeLstnrs = new ArrayList<>();
	
	@Override
	public boolean addChangeListener(ChangeListener<T> l) {
		synchronized ( this.sync ) {
			return this.changeLstnrs.add(l);
		}
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<T> l) {
		synchronized ( this.sync ) {
			return this.changeLstnrs.remove(l);
		}
	}
	
	protected void notifyChanged(T v) {
		synchronized ( this.sync ) {
			for ( ChangeListener<T> l : this.changeLstnrs ) {
				l.changed(v);
			}
		}
	}
	
}
