package com.shimizukenta.property;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class MapWaitUntil extends AbstractWaitUntil {

	protected MapWaitUntil() {
		super();
	}
	
	private static final class SingletonHolder {
		private static final MapWaitUntil inst = new MapWaitUntil();
	}
	
	public static MapWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	private class InnerContainsKey<K, V> extends AbstractInner implements ChangeListener<Map<K, V>> {
		
		private final Object key;
		private V lastValue;
		
		private InnerContainsKey(boolean containsKey, Object key) {
			super(containsKey);
			this.key = key;
			this.lastValue = null;
		}
		
		@Override
		public void changed(Map<K, V> value) {
			synchronized ( this.sync ) {
				this.lastValue = value.get(this.key);
				this.set(this.lastValue != null);
			}
		}
		
		public V waitUntilAndGet() throws InterruptedException {
			synchronized ( this.sync ) {
				this.waitUntil();
				return this.lastValue;
			}
		}
		
		public V waitUntilAndGet(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				this.waitUntil(timeout, unit);
				return this.lastValue;
			}
		}
		
		public V waitUntilAndGet(TimeGettable p) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				this.waitUntil(p);
				return this.lastValue;
			}
		}
	}
	
	public <K, V> V containsKey(MapObservable<K, V> observable, boolean containsKey, Object key) throws InterruptedException {
		final InnerContainsKey<K, V> i = new InnerContainsKey<>(containsKey, key);
		try {
			observable.addChangeListener(i);
			return i.waitUntilAndGet();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <K, V> V containsKey(MapObservable<K, V> observable, boolean containsKey, Object key, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContainsKey<K, V> i = new InnerContainsKey<>(containsKey, key);
		try {
			observable.addChangeListener(i);
			return i.waitUntilAndGet(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <K, V> V containsKey(MapObservable<K, V> observable, boolean containsKey, Object key, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerContainsKey<K, V> i = new InnerContainsKey<>(containsKey, key);
		try {
			observable.addChangeListener(i);
			return i.waitUntilAndGet(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	private class InnerIsEmpty<K, V> extends AbstractInner implements ChangeListener<Map<K, V>> {
		
		private InnerIsEmpty(boolean isEmpty) {
			super(isEmpty);
		}
		
		@Override
		public void changed(Map<K, V> map) {
			this.set(map.isEmpty());
		}
	}
	
	public <K, V> void isEmpty(MapObservable<K, V> observable, boolean isEmpty) throws InterruptedException {
		final InnerIsEmpty<K, V> i = new InnerIsEmpty<>(isEmpty);
		try {
			observable.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <K, V> void isEmpty(MapObservable<K, V> observable, boolean isEmpty, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerIsEmpty<K, V> i = new InnerIsEmpty<>(isEmpty);
		try {
			observable.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <K, V> void isEmpty(MapObservable<K, V> observable, boolean isEmpty, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerIsEmpty<K, V> i = new InnerIsEmpty<>(isEmpty);
		try {
			observable.addChangeListener(i);
			i.waitUntil(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
}
