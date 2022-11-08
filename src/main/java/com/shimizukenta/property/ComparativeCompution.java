package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface ComparativeCompution extends BooleanCompution {
	
	public static ComparativeCompution equalTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().equalTo(left, right);
	}
	
	public static ComparativeCompution notEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().notEqualTo(left, right);
	}
	
	public static ComparativeCompution lessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().lessThan(left, right);
	}
	
	public static ComparativeCompution lessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().lessThanOrEqualTo(left, right);
	}
	
	public static ComparativeCompution greaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().greaterThan(left, right);
	}
	
	public static ComparativeCompution greaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().greaterThanOrEqualTo(left, right);
	}
	
}
