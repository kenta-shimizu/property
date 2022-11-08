package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberCompution extends Compution<Number, NumberSettable<Number>>, NumberGettable<Number>, NumberObservable<Number> {
	
	public static NumberCompution add(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return add(Arrays.asList(a, b));
	}
	
	public static NumberCompution add(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c) {
		
		return add(Arrays.asList(a, b, c));
	}
	
	public static NumberCompution add(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b,
			NumberObservable<? extends Number> c,
			NumberObservable<? extends Number> d) {
		
		return add(Arrays.asList(a, b, c, d));
	}
	
	public static NumberCompution add(Collection<? extends NumberObservable<? extends Number>> observables) {
		return NumberComputionBuilder.getInstance().add(observables);
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
	
	public static NumberCompution multiply(Collection<? extends NumberObservable<? extends Number>> observables) {
		return NumberComputionBuilder.getInstance().multiply(observables);
	}
	
	public static NumberCompution negate(NumberObservable<? extends Number> observable) {
		return NumberComputionBuilder.getInstance().negate(observable);
	}
	
	public static NumberCompution subtract(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return NumberComputionBuilder.getInstance().substract(a, b);
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
	
	public static NumberCompution max(Collection<? extends NumberObservable<? extends Number>> observables) {
		return NumberComputionBuilder.getInstance().max(observables);
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
	
	public static NumberCompution min(Collection<? extends NumberObservable<? extends Number>> observables) {
		return NumberComputionBuilder.getInstance().min(observables);
	}
	
}
