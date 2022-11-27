package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
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
	
	protected Map<K, V> _simpleGet() {
		return this.map;
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
	public boolean containsKey(Object key) {
		return this._simpleGet().containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this._simpleGet().containsValue(value);
	}

	@Override
	public V get(Object key) {
		return this._simpleGet().get(key);
	}
	
	@Override
	public V put(K key, V value) {
		synchronized ( this._sync ) {
			V v = this._simpleGet().put(key, value);
			this._notifyChanged();
			return v;
		}
	}
	
	@Override
	public V remove(Object key) {
		synchronized ( this._sync ) {
			V v = this._simpleGet().remove(key);
			if ( v != null ) {
				this._notifyChanged();
			}
			return v;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		synchronized ( this._sync ) {
			this._simpleGet().putAll(m);
			this._notifyChanged();
		}
	}

	@Override
	public void clear() {
		synchronized ( this._sync ) {
			if ( ! this._simpleGet().isEmpty() ) {
				this._simpleGet().clear();
				this._notifyChanged();
			}
		}
	}

	@Override
	public Set<K> keySet() {
		return this._simpleGet().keySet();
	}

	@Override
	public Collection<V> values() {
		return this._simpleGet().values();
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		return this._simpleGet().entrySet();
	}

	private final Collection<ChangeListener<? super Map<K, V>>> changeLstnrs = new HashSet<>();
	
	@Override
	public boolean addChangeListener(ChangeListener<? super Map<K, V>> l) {
		synchronized ( this._sync ) {
			boolean f = this.changeLstnrs.add(l);
			if ( f ) {
				l.changed(this._simpleGet());
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
	
	private final ChangeListener<Map<K, V>> changeLstnr = this::_syncSetAndNotifyChanged;
	
	protected void _syncSetAndNotifyChanged(Map<? extends K, ? extends V> newMap) {
		synchronized ( this._sync ) {
			if (! Objects.equals(newMap, this._simpleGet())) {
				this._simpleGet().clear();
				this._simpleGet().putAll(newMap);
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
			final Map<K, V> m = this._simpleGet();
			for (ChangeListener<? super Map<K, V>> l : this.changeLstnrs ) {
				l.changed(m);
			}
		}
	}
	
	private class InnerContainsKey implements ChangeListener<Map<K, V>> {
		
		protected final Object sync = new Object();
		
		private final Object key;
		private final boolean containsKey;
		private boolean f;
		private V v;
		
		private InnerContainsKey(Object key, boolean containsKey) {
			
			this.key = Objects.requireNonNull(key);
			this.containsKey = containsKey;
			this.f = false;
			this.v = null;
		}
		
		@Override
		public void changed(Map<K, V> map) {
			synchronized ( this.sync ) {
				this.v = map.get(key);
				boolean f = this.v != null;
				if ( f != this.f ) {
					this.f = f;
					this.sync.notifyAll();
				}
			}
		}
		
		private V waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.f != this.containsKey ) {
					this.sync.wait();
				}
				return this.v;
			}
		}
		
		private V waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
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
		final InnerContainsKey i = new InnerContainsKey(key, true);
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
		final InnerContainsKey i = new InnerContainsKey(key, true);
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
		final InnerContainsKey i = new InnerContainsKey(key, false);
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
		final InnerContainsKey i = new InnerContainsKey(key, false);
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
	
	private class InnerIsEmpty implements ChangeListener<Map<K, V>> {
		
		private final Object sync = new Object();
		private final boolean isEmpty;
		private boolean f;
		
		private InnerIsEmpty(boolean isEmpty) {
			this.isEmpty = isEmpty;
			this.f = false;
		}
		
		@Override
		public void changed(Map<K, V> map) {
			synchronized ( this.sync ) {
				boolean f = map.isEmpty();
				if ( f != this.f ) {
					this.f = f;
					this.sync.notifyAll();
				}
			}
		}
		
		private void waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.f != this.isEmpty ) {
					this.sync.wait();
				}
			}
		}
		
		private void waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				if ( this.f != this.isEmpty ) {
					unit.timedWait(this.sync, timeout);
					if ( this.f != this.isEmpty ) {
						throw new TimeoutException();
					}
				}
			}
		}
	}
	
	@Override
	public void waitUntilEmpty() throws InterruptedException {
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
	public void waitUntilEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
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
	public void waitUntilEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEmpty(a.timeout(), a.unit());
	}
	
	@Override
	public void waitUntilNotEmpty() throws InterruptedException {
		final InnerIsEmpty i = new InnerIsEmpty(false);
		try {
			this.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	public void waitUntilNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerIsEmpty i = new InnerIsEmpty(false);
		try {
			this.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeChangeListener(i);
		}
	}
	
	public void waitUntilNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEmpty(a.timeout(), a.unit());
	}
	
	@Override
	public String toString() {
		return this._simpleGet().toString();
	}
	
}
