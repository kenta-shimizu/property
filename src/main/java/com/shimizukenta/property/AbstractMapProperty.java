package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <K> Key
 * @param <V> Value
 */
public class AbstractMapProperty<K, V> implements MapProperty<K, V> {
	
	private static final long serialVersionUID = -5051422061789589475L;
	
	private final Object _sync = new Object();
	
	private final Map<K, V> map;
	
	protected AbstractMapProperty(Map<K, V> initial) {
		this.map = initial;
	}
	
	protected Map<K, V> _get() {
		return this.map;
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
	public boolean containsKey(Object key) {
		synchronized ( this._sync ) {
			return this._get().containsKey(key);
		}
	}

	@Override
	public boolean containsValue(Object value) {
		synchronized ( this._sync ) {
			return this._get().containsValue(value);
		}
	}

	@Override
	public V get(Object key) {
		synchronized ( this._sync ) {
			return this._get().get(key);
		}
	}
	
	@Override
	public V put(K key, V value) {
		synchronized ( this._sync ) {
			V v = this._get().put(key, value);
			this._notifyChanged();
			return v;
		}
	}
	
	@Override
	public V remove(Object key) {
		synchronized ( this._sync ) {
			V v = this._get().remove(key);
			if ( v != null ) {
				this._notifyChanged();
			}
			return v;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		synchronized ( this._sync ) {
			this._get().putAll(m);
			this._notifyChanged();
		}
	}

	@Override
	public void clear() {
		synchronized ( this._sync ) {
			if ( ! this._get().isEmpty() ) {
				this._get().clear();
				this._notifyChanged();
			}
		}
	}

	@Override
	public Set<K> keySet() {
		synchronized ( this._sync ) {
			return this._get().keySet();
		}
	}

	@Override
	public Collection<V> values() {
		synchronized ( this._sync ) {
			return this._get().values();
		}
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		synchronized ( this._sync ) {
			return this._get().entrySet();
		}
	}

	private final Collection<ChangeListener<? super Map<K, V>>> changeLstnrs = new ArrayList<>();
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Map<K, V>> l) {
		synchronized ( this._sync ) {
			boolean f = this.changeLstnrs.add(l);
			if ( f ) {
				l.changed(this._get());
			}
			return f;
		}
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super Map<K, V>> l) {
		synchronized ( this._sync ) {
			return this.changeLstnrs.remove(l);
		}
	}
	
	private final Collection<MapObservable<K, V>> bindObs = new ArrayList<>();
	
	@Override
	public boolean bind(MapObservable<K, V> observable) {
		synchronized ( this._sync ) {
			boolean f = this.bindObs.add(observable);
			if ( f ) {
				observable.set(this._get());
			}
			return f;
		}
	}
	
	@Override
	public boolean unbind(MapObservable<K, V> observable) {
		synchronized ( this._sync ) {
			return this.bindObs.remove(observable);
		}
	}
	
	@Override
	public void set(Map<K, V> newMap) {
		synchronized ( this._sync ) {
			this._get().clear();
			this._get().putAll(newMap);
			this._notifyChanged();
		}
	}
	
	protected void _notifyChangedToListnersAndBinds() {
		final Map<K, V> m = this._get();
		
		for (ChangeListener<? super Map<K, V>> l : this.changeLstnrs ) {
			l.changed(m);
		}
		
		for (MapObservable<K, V> o : this.bindObs) {
			o.set(m);
		}
	}
	
	protected void _notifyChanged() {
		synchronized ( this._sync ) {
			this._notifyChangedToListnersAndBinds();
			this._sync.notifyAll();
		}
	}
	
	protected class Inner implements ChangeListener<Map<K, V>> {
		
		protected final Object _sync = new Object();
		
		private final Object key;
		private final boolean containsKey;
		private boolean f;
		private V v;
		
		protected Inner(Object key, boolean containsKey) {
			
			this.key = key;
			this.containsKey = containsKey;
			this.f = false;
			this.v = null;
		}
		
		@Override
		public void changed(Map<K, V> map) {
			synchronized ( this._sync ) {
				this.v = map.get(key);
				boolean f = v != null;
				if ( f != this.f ) {
					this.f = f;
					this._sync.notifyAll();
				}
			}
		}
		
		protected V waitUntil() throws InterruptedException {
			synchronized ( this._sync ) {
				if ( this.f != this.containsKey ) {
					this._sync.wait();
				}
				return this.v;
			}
		}
		
		protected V waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this._sync ) {
				if ( this.f != this.containsKey ) {
					unit.timedWait(this._sync, timeout);
					if ( this.f != this.containsKey ) {
						throw new TimeoutException();
					}
				}
				return this.v;
			}
		}
	}
	
	@Override
	public V waitUntilContainsKey(Object key) throws InterruptedException {
		final Inner i = new Inner(key, true);
		try {
			this.addChangeListener(i);
			return i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public V waitUntilContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = new Inner(key, true);
		try {
			this.addChangeListener(i);
			return i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilNotContainsKey(Object key) throws InterruptedException {
		final Inner i = new Inner(key, false);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	@Override
	public void waitUntilNotContainsKey(Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = new Inner(key, false);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}

}
