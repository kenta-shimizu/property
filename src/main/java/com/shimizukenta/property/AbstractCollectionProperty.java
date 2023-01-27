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
	
	public AbstractCollectionProperty(T initial) {
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
		synchronized ( this._sync ) {
			boolean f = this._simpleGet().add(e);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean remove(Object o) {
		synchronized ( this._sync ) {
			boolean f = this._simpleGet().remove(o);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		synchronized ( this._sync ) {
			return this._simpleGet().containsAll(c);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		synchronized ( this._sync ) {
			boolean f = this._simpleGet().addAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		synchronized ( this._sync ) {
			boolean f = this._simpleGet().removeAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		synchronized ( this._sync ) {
			boolean f = this._simpleGet().retainAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public void clear() {
		synchronized ( this._sync ) {
			if ( ! this._simpleGet().isEmpty() ) {
				this._simpleGet().clear();
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
			if (! Objects.equals(c, x)) {
				x.clear();
				x.addAll(c);
				this._notifyChagned();
			}
		}
	}
	
	private final ChangeListener<T> bindLstnr = this::_syncSetAndNotifyChanged;
	
	@Override
	public boolean bind(CollectionObservable<E, T> observer) {
		return observer.addChangeListener(this.bindLstnr);
	}
	
	@Override
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
