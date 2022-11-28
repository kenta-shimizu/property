package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
	
	protected T _simpleGet() {
		return this.v;
	}
	
	@Override
	public int size() {
		return this._simpleGet().size();
	}

	@Override
	public boolean isEmpty() {
		return this._simpleGet().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this._simpleGet().contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return this._simpleGet().iterator();
	}
	
	@Override
	public Object[] toArray() {
		return this._simpleGet().toArray();
	}

	@Override
	public <U> U[] toArray(U[] a) {
		return this._simpleGet().toArray(a);
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
		return this._simpleGet().containsAll(c);
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
			if (! Objects.equals(c, this._simpleGet())) {
				this._simpleGet().clear();
				this._simpleGet().addAll(c);
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
	
	private class InnerContains implements ChangeListener<T> {
		
		private final Object sync = new Object();
		private final Object refObj;
		private final boolean contains;
		private boolean last;
		
		private InnerContains(Object o, boolean contains) {
			this.refObj = Objects.requireNonNull(o);
			this.contains = contains;
			this.last = false;
		}
		
		@Override
		public void changed(T value) {
			synchronized ( this.sync ) {
				boolean f = value.contains(this.refObj);
				if ( f != this.last ) {
					this.last = f;
					this.sync.notifyAll();
				}
			}
		}
		
		private void waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.last != this.contains ) {
					this.sync.wait();
				}
			}
		}
		
		private void waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				if ( this.last != this.contains ) {
					unit.timedWait(this.sync, timeout);
					if ( this.last != this.contains ) {
						throw new TimeoutException();
					}
				}
			}
		}
	}
	
	@Override
	public void waitUntilContains(Object o) throws InterruptedException {
		final InnerContains i = new InnerContains(o, true);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContains i = new InnerContains(o, true);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilNotContains(Object o) throws InterruptedException {
		final InnerContains i = new InnerContains(o, false);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilNotContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContains i = new InnerContains(o, false);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	private class InnerContainsAll implements ChangeListener<T> {
		
		private final Object sync = new Object();
		private final boolean containsAll;
		private final Collection<?> refCollection;
		private boolean last;
		
		private InnerContainsAll(Collection<?> c, boolean containsAll) {
			this.refCollection = c;
			this.containsAll = containsAll;
			this.last = false;
		}
		
		@Override
		public void changed(T value) {
			synchronized ( this.sync ) {
				boolean f = value.containsAll(this.refCollection);
				if ( f != this.last ) {
					this.last = f;
					this.sync.notifyAll();
				}
			}
		}
		
		private void waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.last != this.containsAll ) {
					this.sync.wait();
				}
			}
		}
		
		private void waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				if ( this.last != this.containsAll ) {
					unit.timedWait(this.sync, timeout);
					if ( this.last != this.containsAll ) {
						throw new TimeoutException();
					}
				}
			}
		}
	}
	
	@Override
	public void waitUntilContainsAll(Collection<?> c) throws InterruptedException {
		final InnerContainsAll i = new InnerContainsAll(c, true);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContainsAll i = new InnerContainsAll(c, true);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilNotContainsAll(Collection<?> c) throws InterruptedException {
		final InnerContainsAll i = new InnerContainsAll(c, false);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilNotContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContainsAll i = new InnerContainsAll(c, false);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	private class InnerIsEmpty implements ChangeListener<T> {
		
		private final Object sync = new Object();
		private final boolean isEmpty;
		private boolean last;
		
		private InnerIsEmpty(boolean isEmpty) {
			this.isEmpty = isEmpty;
			this.last = false;
		}
		
		@Override
		public void changed(T value) {
			synchronized ( this.sync ) {
				boolean f = value.isEmpty();
				if ( f != this.last ) {
					this.last = f;
					this.sync.notifyAll();
				}
			}
		}
		
		private void waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.last != this.isEmpty ) {
					this.sync.wait();
				}
			}
		}
		
		private void waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				if ( this.last != this.isEmpty ) {
					unit.timedWait(this.sync, timeout);
					if ( this.last != this.isEmpty ) {
						throw new TimeoutException();
					}
				}
			}
		}
		
	}
	
	@Override
	public void waitUntilIsEmpty() throws InterruptedException {
		final InnerIsEmpty i = new InnerIsEmpty(true);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilIsEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerIsEmpty i = new InnerIsEmpty(true);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilIsNotEmpty() throws InterruptedException {
		final InnerIsEmpty i = new InnerIsEmpty(false);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilIsNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerIsEmpty i = new InnerIsEmpty(false);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public String toString() {
		return this._simpleGet().toString();
	}

}
