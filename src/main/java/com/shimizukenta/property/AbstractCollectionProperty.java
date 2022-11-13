package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
		synchronized ( this._sync ) {
			return this._get().size();
		}
	}

	@Override
	public boolean isEmpty() {
		synchronized ( this._sync ) {
			return this._get().isEmpty();
		}
	}

	@Override
	public boolean contains(Object o) {
		synchronized ( this._sync ) {
			return this._get().contains(o);
		}
	}

	@Override
	public Iterator<E> iterator() {
		synchronized ( this._sync ) {
			return this._get().iterator();
		}
	}
	
	@Override
	public Object[] toArray() {
		synchronized ( this._sync ) {
			return this._get().toArray();
		}
	}

	@Override
	public <U> U[] toArray(U[] a) {
		synchronized ( this._sync ) {
			return this._get().toArray(a);
		}
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
		synchronized ( this._sync ) {
			return this._get().containsAll(c);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		synchronized ( this ) {
			boolean f = this._get().addAll(c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		synchronized ( this ) {
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
		synchronized ( this ) {
			if ( ! this._get().isEmpty() ) {
				this._get().clear();
				this._notifyChagned();
			}
		}
	}
	
	private final Collection<ChangeListener<? super T>> changeLstnrs = new ArrayList<>();
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
	
	private final Collection<CollectionObservable<E, T>> bindObs = new ArrayList<>();
	
	@Override
	public boolean bind(CollectionObservable<E, T> observable) {
		synchronized ( this._sync ) {
			boolean f = this.bindObs.add(observable);
			if ( f ) {
				observable.set(this._get());
			}
			return f;
		}
	}

	@Override
	public boolean unbind(CollectionObservable<E, T> observable) {
		synchronized ( this._sync ) {
			return this.bindObs.remove(observable);
		}
	}
	
	@Override
	public void set(T c) {
		synchronized ( this._sync ) {
			this._get().clear();
			this._get().addAll(c);
			this._notifyChagned();
		}
	}
	
	protected void _notifyChangedToListnersAndBinds() {
		
		final T v = this._get();
		
		for ( ChangeListener<? super T> l : this.changeLstnrs ) {
			l.changed(v);
		}
		
		for ( CollectionObservable<E, T> o : this.bindObs ) {
			o.set(v);
		}
	}
	
	protected void _notifyChagned() {
		synchronized ( this._sync ) {
			this._notifyChangedToListnersAndBinds();
			this._sync.notifyAll();
		}
	}
	

}
