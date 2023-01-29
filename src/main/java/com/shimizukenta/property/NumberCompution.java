package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberCompution extends Compution<Number>, NumberGettable<Number>, NumberObservable<Number> {
	
//	public static NumberCompution add(
//			NumberObservable<? extends Number> a,
//			NumberObservable<? extends Number> b) {
//		
//		return sum(Arrays.asList(a, b));
//	}
	
	public static NumberCompution sum(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return sum(a, b);
	}
	
	public static NumberCompution sum(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c) {
		
		return sum(a, b, c);
	}
	
	public static NumberCompution sum(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c,
			NumberObservable<? extends Number> d) {
		
		return sum(a, b, c, d);
	}
	
	public static NumberCompution sum(Collection<? extends NumberObservable<? extends Number>> observers) {
		
		return NumberUtils.sum(observers);
	}
	
	public static NumberCompution multiply(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return multiply(Arrays.asList(a, b));
	}
	
	public static NumberCompution multiply(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c) {
		
		return multiply(Arrays.asList(a, b, c));
	}
	
	public static NumberCompution multiply(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c,
			NumberObservable<? extends Number> d) {
		
		return multiply(Arrays.asList(a, b, c, d));
	}
	
	public static NumberCompution multiply(Collection<? extends NumberObservable<? extends Number>> observers) {
		return NumberUtils.multiply(observers);
	}
	
	public static NumberCompution negate(NumberObservable<? extends Number> observer) {
		return NumberUtils.negate(observer);
	}
	
	public static NumberCompution subtract(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.subtrate(left, right);
	}
	
	public static NumberCompution max(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return max(Arrays.asList(a, b));
	}
	
	public static NumberCompution max(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c) {
		
		return max(Arrays.asList(a, b, c));
	}
	
	public static NumberCompution max(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c,
			NumberObservable<? extends Number> d) {
		
		return max(Arrays.asList(a, b, c, d));
	}
	
	public static NumberCompution max(Collection<? extends NumberObservable<? extends Number>> observers) {
		return NumberUtils.max(observers);
	}
	
	public static NumberCompution min(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return min(Arrays.asList(a, b));
	}
	
	public static NumberCompution min(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c) {
		
		return min(Arrays.asList(a, b, c));
	}
	
	public static NumberCompution min(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c,
			NumberObservable<? extends Number> d) {
		
		return min(Arrays.asList(a, b, c, d));
	}
	
	public static NumberCompution min(Collection<? extends NumberObservable<? extends Number>> observers) {
		return NumberUtils.min(observers);
	}
	
}
