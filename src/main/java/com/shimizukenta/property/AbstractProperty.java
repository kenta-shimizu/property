package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public abstract class AbstractProperty<T> implements Property<T> {
	
	private static final long serialVersionUID = 673883739488369977L;
	
	private T v;
	
	protected AbstractProperty(T initial) {
		this.v = initial;
	}
	
	protected final Object _sync = new Object();
	
	protected void _syncSetAndNotifyChanged(T value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(value, this._simpleGet()) ) {
				this._simpleSet(value);
				this._notifyChanged(this.v);
			}
		}
	}
	
	protected final void _simpleSet(T value) {
		this.v = value;
	}
	
	protected final T _simpleGet() {
		return v;
	}
	
	private final Collection<ChangeListener<? super T>> changeLstnrs = new HashSet<>();
	
	@Override
	public boolean addChangeListener(ChangeListener<? super T> l) {
		synchronized ( this._sync ) {
			boolean f = this.changeLstnrs.add(l);
			if ( f ) {
				l.changed(this._simpleGet());
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
	
	private final ChangeListener<T> bindLstnr = this::_syncSetAndNotifyChanged;
	
	@Override
	public boolean bind(Observable<T> observer) {
		return observer.addChangeListener(bindLstnr);
	}
	
	@Override
	public boolean unbind(Observable<T> observer) {
		return observer.removeChangeListener(bindLstnr);
	}
	
	protected void _notifyChanged(T v) {
		for ( ChangeListener<? super T> l : this.changeLstnrs ) {
			l.changed(v);
		}
	}
	
	@Override
	public String toString() {
		return Objects.toString(this._simpleGet());
	}
	
}
