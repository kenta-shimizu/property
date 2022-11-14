package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public abstract class AbstractProperty<T, U extends Settable<T>> implements Property<T, U> {
	
	private static final long serialVersionUID = 673883739488369977L;
	
	private T v;
	
	protected AbstractProperty(T initial) {
		this.v = initial;
	}
	
	protected final Object _sync = new Object();
	
	@Override
	public void set(T value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(this.v, value) ) {
				this._set(value);
				this._notifyChanged(this.v);
			}
		}
	}
	
	protected final void _set(T value) {
		this.v = value;
	}
	
	@Override
	public T get() {
		return this._get();
	}
	
	protected final T _get() {
		return v;
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
	
	protected final void _notifyChanged(T v) {
		for ( ChangeListener<? super T> l : this.changeLstnrs ) {
			l.changed(v);
		}
		for ( U p : this.binds ) {
			p.set(v);
		}
	}
	
}
