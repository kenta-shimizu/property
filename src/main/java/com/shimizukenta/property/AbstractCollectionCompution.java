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
 * @param <T> Type
 */
public abstract class AbstractCollectionCompution<E, T extends Collection<E>> implements CollectionCompution<E, T> {
	
	private static final long serialVersionUID = -6611104182991862616L;

	protected final Object _sync = new Object();
	
	private T v;
	
	public AbstractCollectionCompution(T initial) {
		this.v = initial;
	}
	
	protected T _simpleGet() {
		return this.v;
	}
	
	@Override
	public int size() {
		synchronized ( this._sync ) {
			return this._simpleGet().size();
		}
	}

	@Override
	public boolean isEmpty() {
		synchronized ( this._sync ) {
			return this._simpleGet().isEmpty();
		}
	}

	@Override
	public boolean contains(Object o) {
		synchronized ( this._sync ) {
			return this._simpleGet().contains(o);
		}
	}

	@Override
	public Iterator<E> iterator() {
		synchronized ( this._sync ) {
			return this._simpleGet().iterator();
		}
	}
	
	@Override
	public Object[] toArray() {
		synchronized ( this._sync ) {
			return this._simpleGet().toArray();
		}
	}

	@Override
	public <U> U[] toArray(U[] a) {
		synchronized ( this._sync ) {
			return this._simpleGet().toArray(a);
		}
	}
	
	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		synchronized ( this._sync ) {
			return this._simpleGet().containsAll(c);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		synchronized ( this._sync ) {
			throw new UnsupportedOperationException();
		}
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
	
	protected void _syncSetAndNotifyChanged(T c) {
		synchronized ( this._sync ) {
			final T x = this._simpleGet();
			if ( ! Objects.equals(x, c) ) {
				x.clear();
				x.addAll(c);
				this._notifyChagned();
			}
		}
	}
	
	private final ChangeListener<T> bindLstnr = this::_syncSetAndNotifyChanged;
	
	public boolean bind(CollectionObservable<E, T> observer) {
		return observer.addChangeListener(this.bindLstnr);
	}
	
	public boolean unbind(CollectionObservable<E, T> observer) {
		return observer.removeChangeListener(this.bindLstnr);
	}
	
	protected void _notifyChagned() {
		final T v = this._simpleGet();
		for ( ChangeListener<? super T> l : this.changeLstnrs ) {
			l.changed(v);
		}
	}
	
	@Override
	public String toString() {
		synchronized ( this._sync ) {
			return Objects.toString(this._simpleGet());
		}
	}
	
}
