package com.shimizukenta.property;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

public class CollectionUtils {

	private CollectionUtils() {
		/* Nothing */
	}
	
	private static class InnerCollection<E, T extends Collection<E>> extends AbstractPredicateCompution<T> {
		
		private static final long serialVersionUID = 111127328521430450L;
		
		public InnerCollection(Predicate<? super T> compute, T initial) {
			super(compute, initial);
		}
		
		@Override
		protected void changedValue(T c) {
			synchronized ( this._sync ) {
				final T x = this.getLastValue();
				x.clear();
				x.addAll(c);
				this._syncSetAndNotifyChanged(Boolean.valueOf(this._compute.test(x)));
			}
		}
	}
	
	private static <E, T extends Collection<E>> InnerCollection<E, T> buildInnerCollection(
			Observable<T> observer,
			T initial,
			Predicate<? super T> compute) {
		
		final InnerCollection<E, T> i = new InnerCollection<>(compute, initial);
		
		i.bind(observer);
		
		return i;
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeContains(
			Observable<T> observer,
			T initial,
			Object o) {
		
		return buildInnerCollection(
				observer,
				initial,
				c -> c.contains(o));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeNotContains(
			Observable<T> observer,
			T initial,
			Object o) {
		
		return buildInnerCollection(
				observer,
				initial,
				c -> ! c.contains(o));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeContainsAll(
			Observable<T> observer,
			T initial,
			Collection<?> c) {
		
		return buildInnerCollection(
				observer,
				initial,
				x -> x.containsAll(c));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeNotContainsAll(
			Observable<T> observer,
			T initial,
			Collection<?> c) {
		
		return buildInnerCollection(
				observer,
				initial,
				x -> ! x.containsAll(c));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeIsEmpty(
			Observable<T> observer,
			T initial) {
		
		return buildInnerCollection(
				observer,
				initial,
				c -> c.isEmpty());
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeIsNotEmpty(
			Observable<T> observer,
			T initial) {
		
		return buildInnerCollection(
				observer,
				initial,
				c -> ! c.isEmpty());
	}
	
	public static <E, T extends Collection<E>> void waitUntil(
			AbstractPredicateCompution<T> i,
			Observable<T> observer) throws InterruptedException {
		
		try {
			i.waitUntilTrue();
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <E, T extends Collection<E>> void waitUntil(
			AbstractPredicateCompution<T> i,
			Observable<T> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(timeout, unit);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <E, T extends Collection<E>> void waitUntil(
			AbstractPredicateCompution<T> i,
			Observable<T> observer,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
		}
		finally {
			i.unbind(observer);
		}
	}
	
}
