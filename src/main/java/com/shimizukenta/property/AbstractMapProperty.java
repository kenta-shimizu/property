package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
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
public abstract class AbstractMapProperty<K, V> implements MapProperty<K, V> {
	
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
		return this._get().size();
	}

	@Override
	public boolean isEmpty() {
		return this._get().isEmpty();
	}
	
	@Override
	public boolean containsKey(Object key) {
		return this._get().containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this._get().containsValue(value);
	}

	@Override
	public V get(Object key) {
		return this._get().get(key);
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
		return this._get().keySet();
	}

	@Override
	public Collection<V> values() {
		return this._get().values();
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		return this._get().entrySet();
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
	
	private final ChangeListener<Map<K, V>> changeLstnr = this::_set;
	
	protected void _set(Map<? extends K, ? extends V> newMap) {
		synchronized ( this._sync ) {
			if (! Objects.equals(newMap, this._get())) {
				this._get().clear();
				this._get().putAll(newMap);
				this._notifyChanged();
			}
		}
	}
	
	@Override
	public boolean bind(MapObservable<K, V> observer) {
		return observer.addChangeListener(this.changeLstnr);
	}
	
	@Override
	public boolean unbind(MapObservable<K, V> observer) {
		return observer.removeChangeListener(this.changeLstnr);
	}
	
	protected void _notifyChanged() {
		synchronized ( this._sync ) {
			final Map<K, V> m = this._get();
			for (ChangeListener<? super Map<K, V>> l : this.changeLstnrs ) {
				l.changed(m);
			}
		}
	}
	
	protected class Inner implements ChangeListener<Map<K, V>> {
		
		protected final Object sync = new Object();
		
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
			synchronized ( this.sync ) {
				this.v = map.get(key);
				boolean f = v != null;
				if ( f != this.f ) {
					this.f = f;
					this.sync.notifyAll();
				}
			}
		}
		
		protected V waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.f != this.containsKey ) {
					this.sync.wait();
				}
				return this.v;
			}
		}
		
		protected V waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				if ( this.f != this.containsKey ) {
					unit.timedWait(this.sync, timeout);
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
	public V waitUntilContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		return this.waitUntilContainsKey(key, a.timeout(), a.unit());
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
	
	@Override
	public void waitUntilNotContainsKey(Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotContainsKey(key, a.timeout(), a.unit());
	}
	
	@Override
	public String toString() {
		synchronized ( this._sync ) {
			return this._get().toString();
		}
	}
	
}
