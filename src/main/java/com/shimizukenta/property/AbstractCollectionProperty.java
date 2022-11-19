package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 * @param <T> Elements
 */
public abstract class AbstractCollectionProperty<E, T extends Collection<E>> implements CollectionProperty<E, T> {
	
	private static final long serialVersionUID = 3399378304619203215L;
	
	protected final Object _sync = new Object();
	
	private T v;
	
	protected AbstractCollectionProperty(T initial) {
		this.v = initial;
	}
	
	protected T _get() {
		return this.v;
	}
	
	@Override
	public int size() {
		return this._get().size();
	}

	@Override
	public boolean isEmpty() {
		return this._get().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this._get().contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return this._get().iterator();
	}
	
	@Override
	public Object[] toArray() {
		return this._get().toArray();
	}

	@Override
	public <U> U[] toArray(U[] a) {
		return this._get().toArray(a);
	}
	
	@Override
	public boolean add(E e) {
		synchronized ( this._sync ) {
			boolean f = this._get().add(e);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean remove(Object o) {
		synchronized ( this._sync ) {
			boolean f = this._get().remove(o);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this._get().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		synchronized ( this._sync ) {
			boolean f = this._get().addAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		synchronized ( this._sync ) {
			boolean f = this._get().removeAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		synchronized ( this._sync ) {
			boolean f = this._get().retainAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public void clear() {
		synchronized ( this._sync ) {
			if ( ! this._get().isEmpty() ) {
				this._get().clear();
				this._notifyChagned();
			}
		}
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
	
	private final ChangeListener<T> bindLstnr = this::_set;
	
	@Override
	public boolean bind(CollectionObservable<E, T> observer) {
		return observer.addChangeListener(this.bindLstnr);
	}
	
	@Override
	public boolean unbind(CollectionObservable<E, T> observer) {
		return observer.removeChangeListener(this.bindLstnr);
	}
	
	protected void _set(T c) {
		synchronized ( this._sync ) {
			if (! Objects.equals(c, this._get())) {
				this._get().clear();
				this._get().addAll(c);
				this._notifyChagned();
			}
		}
	}
	
	protected void _notifyChagned() {
		final T v = this._get();
		for ( ChangeListener<? super T> l : this.changeLstnrs ) {
			l.changed(v);
		}
	}
	
	@Override
	public String toString() {
		synchronized ( this._sync ) {
			return this._get().toString();
		}
	}

}
