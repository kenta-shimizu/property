package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public final class ObjectUtils {
	
	private ObjectUtils() {
		/* Nothing */
	}
	
	public static <T> ObjectProperty<T> newUnmodifiable(T v) {
		return new AbstractUnmodifiableObjectProperty<T>(v) {
			
			private static final long serialVersionUID = -3491034584153413061L;
		};
	}
	
	private static final ObjectProperty<Object> singleNullObj = newUnmodifiable(null);
	
	private static <T> AbstractPredicateCompution<T> buildPredicateCompution(
			Observable<T> observer,
			Predicate<? super T> compute) {
		
		final AbstractPredicateCompution<T> i = new AbstractPredicateCompution<T>(compute) {
			
			private static final long serialVersionUID = 5868891255220930302L;
		};
		
		i.bind(observer);
		
		return i;
	}
	
	public static ObjectProperty<Object> getUnmodifiableNull() {
		return singleNullObj;
	}
	
	public static <T> AbstractPredicateCompution<T> computeIsNull(
			Observable<T> observer) {
		
		return buildPredicateCompution(observer, v -> v == null);
	}
	
	public static <T> AbstractPredicateCompution<T> computeIsNotNull(
			Observable<T> observer) {
		
		return buildPredicateCompution(observer, v -> v != null);
	}
	
	private static <T> T waitUntilPredicate(
			AbstractPredicateCompution<T> i,
			Observable<T> observer) throws InterruptedException {
		
		try {
			return i.waitUntilTrueAndGet();
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static <T> T waitUntilPredicate(
			AbstractPredicateCompution<T> i,
			Observable<T> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			return i.waitUntilTrueAndGet(timeout, unit);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static <T> T waitUntilPredicate(
			AbstractPredicateCompution<T> i,
			Observable<T> observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		try {
			return i.waitUntilTrueAndGet(p);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	public static <T> T waitUntilNotNull(
			Observable<T> observer) throws InterruptedException {
		
		return waitUntilPredicate(computeIsNotNull(observer), observer);
	}
	
	public static <T> T waitUntilNotNull(
			Observable<T> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntilPredicate(computeIsNotNull(observer), observer, timeout, unit);
	}
	
	public static <T> T waitUntilNotNull(
			Observable<T> observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntilPredicate(computeIsNotNull(observer), observer, p);
	}
	
	public static <T> void waitUntilNull(
			Observable<T> observer) throws InterruptedException {
		
		waitUntilPredicate(computeIsNull(observer), observer);
	}
	
	public static <T> void waitUntilNull(
			Observable<T> observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(computeIsNull(observer), observer, timeout, unit);
	}

	public static <T> void waitUntilNull(
			Observable<T> observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntilPredicate(computeIsNull(observer), observer, p);
	}
	
	private static <T, U> AbstractBiPredicateCompution<T, U> buildBiPredicateCompution(
			Observable<T> left,
			Observable<U> right,
			BiPredicate<? super T, ? super U> compute) {
		
		final AbstractBiPredicateCompution<T, U> i = new AbstractBiPredicateCompution<T, U>(compute) {
			
			private static final long serialVersionUID = 1L;
		};
		
		if ( left != null ) {
			i.bindLeft(left);
		}
		
		if ( right != null ) {
			i.bindRight(right);
		}
		
		return i;
	}
	
	public static <T, U> AbstractBiPredicateCompution<T, U> computeIsEqualTo(
			Observable<T> left,
			Observable<U> right) {
		
		return buildBiPredicateCompution(left, right, (Object a, Object b) -> Objects.equals(a, b));
	}
	
	public static <T, U> AbstractBiPredicateCompution<T, U> computeIsNotEqualTo(
			Observable<T> left,
			Observable<U> right) {
		
		return buildBiPredicateCompution(left, right, (Object a, Object b) -> ! Objects.equals(a, b));
	}
	
	private static <T, U> void waitUntilBiPredicate(
			AbstractBiPredicateCompution<T, U> i,
			Observable<T> left,
			Observable<U> right) throws InterruptedException {
		
		try {
			i.waitUntilTrue();
		}
		finally {
			if ( left != null ) {
				i.unbindLeft(left);
			}
			if ( right != null ) {
				i.unbindRight(right);
			}
		}
	}
	
	private static <T, U> void waitUntilBiPredicate(
			AbstractBiPredicateCompution<T, U> i,
			Observable<T> left,
			Observable<U> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(timeout, unit);
		}
		finally {
			if ( left != null ) {
				i.unbindLeft(left);
			}
			if ( right != null ) {
				i.unbindRight(right);
			}
		}
	}

	private static <T, U> void waitUntilBiPredicate(
			AbstractBiPredicateCompution<T, U> i,
			Observable<T> left,
			Observable<U> right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
		}
		finally {
			if ( left != null ) {
				i.unbindLeft(left);
			}
			if ( right != null ) {
				i.unbindRight(right);
			}
		}
	}
	
	public static <T, U> void waitUntilEqualTo(
			Observable<T> a,
			Observable<U> b) throws InterruptedException {
		
		waitUntilBiPredicate(computeIsEqualTo(a, b), a, b);
	}
	
	public static <T, U> void waitUntilEqualTo(
			Observable<T> a,
			Observable<U> b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntilBiPredicate(computeIsEqualTo(a, b), a, b, timeout, unit);
	}
	
	public static <T, U> void waitUntilEqualTo(
			Observable<T> a,
			Observable<U> b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntilBiPredicate(computeIsEqualTo(a, b), a, b, p);
	}
	
	public static <T, U> void waitUntilNotEqualTo(
			Observable<T> a,
			Observable<U> b) throws InterruptedException {
		
		waitUntilBiPredicate(computeIsNotEqualTo(a, b), a, b);
	}
	
	public static <T, U> void waitUntilNotEqualTo(
			Observable<T> a,
			Observable<U> b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntilBiPredicate(computeIsNotEqualTo(a, b), a, b, timeout, unit);
	}
	
	public static <T, U> void waitUntilNotEqualTo(
			Observable<T> a,
			Observable<U> b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntilBiPredicate(computeIsNotEqualTo(a, b), a, b, p);
	}

}
