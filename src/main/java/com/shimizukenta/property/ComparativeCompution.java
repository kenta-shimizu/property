package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface ComparativeCompution extends BooleanCompution {
	
	/**
	 * Returns (left == right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left == right) ComparativeCompution instance.
	 */
	public static ComparativeCompution equalTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberComparativeComputionBuilder.getInstance().equalTo(left, right);
	}
	
	/**
	 * Returns (left != right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left != right) ComparativeCompution instance.
	 */
	public static ComparativeCompution notEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberComparativeComputionBuilder.getInstance().notEqualTo(left, right);
	}
	
	/**
	 * Returns (left < right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left < right) ComparativeCompution instance.
	 */
	public static ComparativeCompution lessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberComparativeComputionBuilder.getInstance().lessThan(left, right);
	}
	
	/**
	 * Returns (left <= right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left <= right) ComparativeCompution instance.
	 */
	public static ComparativeCompution lessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberComparativeComputionBuilder.getInstance().lessThanOrEqualTo(left, right);
	}
	
	/**
	 * Returns (left > right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left > right) ComparativeCompution instance.
	 */
	public static ComparativeCompution greaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberComparativeComputionBuilder.getInstance().greaterThan(left, right);
	}
	
	/**
	 * Returns (left >= right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left >= right) ComparativeCompution instance.
	 */
	public static ComparativeCompution greaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberComparativeComputionBuilder.getInstance().greaterThanOrEqualTo(left, right);
	}
	
	/**
	 * Returns equal object ComparativeCompution instance.
	 * 
	 * @param <T> type
	 * @param <U> type
	 * @param a
	 * @param b
	 * @return Object EqualTo ComparativeCompution
	 */
	public static <T, U> ComparativeCompution equalTo(ObjectObservable<T> a, ObjectObservable<U> b) {
		return ObjectComparativeComputionBuilder.getInstance().equalTo(a, b);
	}
	
	/**
	 * Returns NOT equal object ComparativeCompution instance.
	 * 
	 * @param <T> type
	 * @param <U> type
	 * @param a
	 * @param b
	 * @return Object NotEqualTo ComparativeCompution
	 */
	public static <T, U> ComparativeCompution notEqualTo(ObjectObservable<T> a, ObjectObservable<U> b) {
		return ObjectComparativeComputionBuilder.getInstance().notEqualTo(a, b);
	}
	
}
