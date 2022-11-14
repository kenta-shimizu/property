package com.shimizukenta.property;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractListProperty<E> extends AbstractCollectionProperty<E, List<E>> implements ListProperty<E> {
	
	private static final long serialVersionUID = -1599017743017445594L;
	
	protected AbstractListProperty(List<E> initial) {
		super(initial);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		synchronized ( this._sync ) {
			boolean f = this._get().addAll(index, c);
			if ( f ) {
				this._notifyChagned();
			}
			return f;
		}
	}

	@Override
	public E get(int index) {
		return this._get().get(index);
	}

	@Override
	public E set(int index, E element) {
		synchronized ( this._sync ) {
			E v = this._get().set(index, element);
			this._notifyChagned();
			return v;
		}
	}

	@Override
	public void add(int index, E element) {
		synchronized ( this._sync ) {
			this._get().add(index, element);
			this._notifyChagned();
		}
	}

	@Override
	public E remove(int index) {
		synchronized ( this._sync ) {
			E v = this._get().remove(index);
			this._notifyChagned();
			return v;
		}
	}

	@Override
	public int indexOf(Object o) {
		return this._get().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return this._get().lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return this._get().listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return this._get().listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return this._get().subList(fromIndex, toIndex);
	}

}
