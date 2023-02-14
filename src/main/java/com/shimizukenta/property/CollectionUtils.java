package com.shimizukenta.property;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class CollectionUtils {

	private CollectionUtils() {
		/* Nothing */
	}
	
	private static class InnerCollection<E, T extends Collection<E>> extends AbstractPredicateCompution<T> {
		
		private static final long serialVersionUID = 111127328521430450L;
		
		public InnerCollection(Predicate<? super T> compute) {
			super(compute);
		}
		
		@Override
		protected void changedValue(T c) {
			synchronized ( this._sync ) {
				this._syncSetAndNotifyChanged(Boolean.valueOf(this._compute.test(c)));
			}
		}
	}
	
	private static <E, T extends Collection<E>> InnerCollection<E, T> buildInnerCollection(
			Observable<T> observer,
			Predicate<? super T> compute) {
		
		final InnerCollection<E, T> i = new InnerCollection<>(compute);
		i.bind(observer);
		return i;
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeContains(
			Observable<T> observer,
			Object o) {
		
		return buildInnerCollection(
				observer,
				x -> (x == null ? false : x.contains(o)));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeNotContains(
			Observable<T> observer,
			Object o) {
		
		return buildInnerCollection(
				observer,
				x -> (x == null ? false : (! x.contains(o))));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeContainsAll(
			Observable<T> observer,
			Collection<?> c) {
		
		return buildInnerCollection(
				observer,
				x -> (x == null ? false : x.containsAll(c)));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeNotContainsAll(
			Observable<T> observer,
			Collection<?> c) {
		
		return buildInnerCollection(
				observer,
				x -> (x == null ? false : (! x.containsAll(c))));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeIsEmpty(
			Observable<T> observer) {
		
		return buildInnerCollection(
				observer,
				x -> (x == null ? false : x.isEmpty()));
	}
	
	public static <E, T extends Collection<E>> AbstractPredicateCompution<T> computeIsNotEmpty(
			Observable<T> observer) {
		
		return buildInnerCollection(
				observer,
				x -> (x == null ? false : (! x.isEmpty())));
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
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static class InnerSize<E, T extends Collection<E>> extends AbstractIntegerCompution {
		
		private static final long serialVersionUID = 6647649394326147795L;
		
		public InnerSize() {
			super();
		}
		
		private void changedCollection(T c) {
			synchronized ( this._sync ) {
				this._syncSetAndNotifyChanged(Integer.valueOf(c.size()));
			}
		}
		
		private final ChangeListener<T> bindLstnr = this::changedCollection;
		
		public boolean bindCollection(CollectionObservable<E, T> observer) {
			return observer.addChangeListener(this.bindLstnr);
		}
	}
	
	public static <E, T extends Collection<E>> AbstractIntegerCompution computeSize(CollectionObservable<E, T> observer) {
		final InnerSize<E, T> i = new InnerSize<>();
		i.bindCollection(observer);
		return i;
	}
	
}
