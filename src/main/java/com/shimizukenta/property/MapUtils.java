package com.shimizukenta.property;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public final class MapUtils {

	private MapUtils() {
		/* Nothing */
	}
	
	private static class InnerMap<K, V> extends AbstractPredicateCompution<Map<K, V>> {
		
		private static final long serialVersionUID = 8252544696751954294L;
		
		public InnerMap(
				Predicate<? super Map<K, V>> compute) {

			super(compute, new HashMap<K, V>());
		}
		
		public V waitUntilContainsKeyAndGet(Object key) throws InterruptedException {
			synchronized ( this._sync ) {
				return this.waitUntilTrueAndGet().get(key);
			}
		}
		
		public V waitUntilContainsKeyAndGet(
				Object key,
				long timeout,
				TimeUnit unit) throws InterruptedException, TimeoutException {
			
			synchronized ( this._sync ) {
				return this.waitUntilTrueAndGet(timeout, unit).get(key);
			}
		}
		
		public V waitUntilContainsKeyAndGet(
				Object key,
				TimeGettable p) throws InterruptedException, TimeoutException {
			
			synchronized ( this._sync ) {
				return this.waitUntilTrueAndGet(p).get(key);
			}
		}
	}
	
	private static <K, V> InnerMap<K, V> buildInnerMap(
			Observable<Map<K, V>> observer,
			Predicate<? super Map<K, V>> compute) {
		
		final InnerMap<K, V> i = new InnerMap<>(compute);
		
		i.bind(observer);
		
		return i;
	}
	
	private static <K, V> InnerMap<K, V> buildIsContainsKey(
			Observable<Map<K, V>> observer,
			Object key) {
		
		return buildInnerMap(observer, m -> m.containsKey(key));
	}
	
	public static <K, V> AbstractPredicateCompution<Map<K, V>> isContainsKey(
			Observable<Map<K, V>> observer,
			Object key) {
		
		return buildIsContainsKey(observer, key);
	}
	
	public static <K, V> AbstractPredicateCompution<Map<K, V>> isNotContainsKey(
			Observable<Map<K, V>> observer,
			Object key) {
		
		return buildInnerMap(observer, m -> ! m.containsKey(key));
	}
	
	public static <K, V> AbstractPredicateCompution<Map<K, V>> isEmpty(
			Observable<Map<K, V>> observer) {
		
		return buildInnerMap(observer, Map::isEmpty);
	}
	
	public static <K, V> AbstractPredicateCompution<Map<K, V>> isNotEmpty(
			Observable<Map<K, V>> observer) {
		
		return buildInnerMap(observer, m -> ! m.isEmpty());
	}
	
	private static <K, V> Map<K, V> waitUntilPredicate(
			AbstractPredicateCompution<Map<K, V>> i,
			Observable<Map<K, V>> observer) throws InterruptedException {
		
		try {
			return i.waitUntilTrueAndGet();
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static <K, V> Map<K, V> waitUntilPredicate(
			AbstractPredicateCompution<Map<K, V>> i,
			Observable<Map<K, V>> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			return i.waitUntilTrueAndGet(timeout, unit);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static <K, V> Map<K, V> waitUntilPredicate(
			AbstractPredicateCompution<Map<K, V>> i,
			Observable<Map<K, V>> observer,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		try {
			return i.waitUntilTrueAndGet(p);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <K, V> V waitUntilContainsKey(
			Observable<Map<K, V>> observer,
			Object key) throws InterruptedException {
		
		final InnerMap<K, V> i = buildIsContainsKey(observer, key);
		try {
			return i.waitUntilContainsKeyAndGet(key);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <K, V> V waitUntilContainsKey(
			Observable<Map<K, V>> observer,
			Object key,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		final InnerMap<K, V> i = buildIsContainsKey(observer, key);
		try {
			return i.waitUntilContainsKeyAndGet(key, timeout, unit);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <K, V> V waitUntilContainsKey(
			Observable<Map<K, V>> observer,
			Object key,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		final InnerMap<K, V> i = buildIsContainsKey(observer, key);
		try {
			return i.waitUntilContainsKeyAndGet(key, p);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <K, V> void waitUntilNotContainsKey(
			Observable<Map<K, V>> observer,
			Object key) throws InterruptedException {
		
		waitUntilPredicate(isNotContainsKey(observer, key), observer);
	}
	
	public static <K, V> void waitUntilNotContainsKey(
			Observable<Map<K, V>> observer,
			Object key,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(isNotContainsKey(observer, key), observer, timeout, unit);
	}
	
	public static <K, V> void waitUntilNotContainsKey(
			Observable<Map<K, V>> observer,
			Object key,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(isNotContainsKey(observer, key), observer, p);
	}
	
	public static <K, V> void waitUntilIsEmpty(
			Observable<Map<K, V>> observer) throws InterruptedException {
		
		waitUntilPredicate(isEmpty(observer), observer);
	}
	
	public static <K, V> void waitUntilIsEmpty(
			Observable<Map<K, V>> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(isEmpty(observer), observer, timeout, unit);
	}
	
	public static <K, V> void waitUntilIsEmpty(
			Observable<Map<K, V>> observer,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(isEmpty(observer), observer, p);
	}
	
	public static <K, V> void waitUntilIsNotEmpty(
			Observable<Map<K, V>> observer) throws InterruptedException {
		
		waitUntilPredicate(isNotEmpty(observer), observer);
	}
	
	public static <K, V> void waitUntilIsNotEmpty(
			Observable<Map<K, V>> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(isNotEmpty(observer), observer, timeout, unit);
	}
	
	public static <K, V> void waitUntilIsNotEmpty(
			Observable<Map<K, V>> observer,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(isNotEmpty(observer), observer, p);
	}
	
}
