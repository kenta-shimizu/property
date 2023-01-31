package com.shimizukenta.property;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
	
	public AbstractMapProperty(Map<K, V> initial) {
		this.map = initial;
	}
	
	protected Map<K, V> _simpleGet() {
		synchronized ( this._sync ) {
			return this.map;
		}
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
	public boolean containsKey(Object key) {
		synchronized ( this._sync ) {
			return this._simpleGet().containsKey(key);
		}
	}

	@Override
	public boolean containsValue(Object value) {
		synchronized ( this._sync ) {
			return this._simpleGet().containsValue(value);
		}
	}

	@Override
	public V get(Object key) {
		synchronized ( this._sync ) {
			return this._simpleGet().get(key);
		}
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
		synchronized ( this._sync ) {
			return this._simpleGet().keySet();
		}
	}

	@Override
	public Collection<V> values() {
		synchronized ( this._sync ) {
			return this._simpleGet().values();
		}
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		synchronized ( this._sync ) {
			return this._simpleGet().entrySet();
		}
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
	
	protected void _syncSetAndNotifyChanged(Map<? extends K, ? extends V> newMap) {
		synchronized ( this._sync ) {
			final Map<K, V> x = this._simpleGet();
			if ( ! Objects.equals(newMap, x) ) {
				x.clear();
				x.putAll(newMap);
				this._notifyChanged();
			}
		}
	}
	
	private final ChangeListener<Map<? extends K, ? extends V>> changeLstnr = this::_syncSetAndNotifyChanged;
	
	@Override
	public boolean bind(Observable<? extends Map<K, V>> observer) {
		return observer.addChangeListener(this.changeLstnr);
	}
	
	@Override
	public boolean unbind(Observable<? extends Map<K, V>> observer) {
		return observer.removeChangeListener(this.changeLstnr);
	}
	
	protected void _notifyChanged() {
		synchronized ( this._sync ) {
			final Map<K, V> m = Collections.unmodifiableMap(this._simpleGet());
			for (ChangeListener<? super Map<K, V>> l : this.changeLstnrs ) {
				l.changed(m);
			}
		}
	}
	
	@Override
	public String toString() {
		synchronized ( this._sync ) {
			return Objects.toString(this._simpleGet());
		}
	}
	
}
