package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractCompution<T, U extends Settable<T>> implements Compution<T, U> {
	
	private static final long serialVersionUID = -3295956325648873642L;
	
	private T v;
	
	protected final Object _sync = new Object();
	
	protected AbstractCompution(T initial) {
		this.v = initial;
	}
	
	protected void _set(T value) {
		this.v = value;
	}
	
	@Override
	public T get() {
		synchronized ( this._sync ) {
			return this._get();
		}
	}
	
	protected final T _get() {
		return this.v;
	}
	
	private final Collection<ChangeListener<? super T>> changeLstnrs = new HashSet<>();
	
	@Override
	public boolean addChangeListener(ChangeListener<? super T> l) {
		synchronized ( this._sync ) {
			boolean f = this.changeLstnrs.add(l);
			if ( f ) {
				l.changed(this._get());
			}
			return f;
		}
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super T> l) {
		synchronized ( this._sync ) {
			return this.changeLstnrs.remove(l);
		}
	}
	
	private final Collection<U> binds = new HashSet<>();
	
	@Override
	public boolean bind(U property) {
		synchronized ( this._sync ) {
			boolean f = this.binds.add(property);
			if ( f ) {
				property.set(this._get());
			}
			return f;
		}
	}

	@Override
	public boolean unbind(U property) {
		synchronized ( this._sync ) {
			return this.binds.remove(property);
		}
	}
	
	protected void _notifyChanged(T value) {
		for ( ChangeListener<? super T> l : this.changeLstnrs ) {
			l.changed(v);
		}
		for ( U p : this.binds ) {
			p.set(v);
		}
	}

}
