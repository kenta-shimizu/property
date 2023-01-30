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
	public static ComparativeCompution isEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.isEqualTo(left, right);
	}
	
	/**
	 * Returns (left != right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left != right) ComparativeCompution instance.
	 */
	public static ComparativeCompution isNotEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.isNotEqualTo(left, right);
	}
	
	/**
	 * Returns (left < right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left < right) ComparativeCompution instance.
	 */
	public static ComparativeCompution isLessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.isLessThan(left, right);
	}
	
	/**
	 * Returns (left <= right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left <= right) ComparativeCompution instance.
	 */
	public static ComparativeCompution isLessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.isLessThanOrEqualTo(left, right);
	}
	
	/**
	 * Returns (left > right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left > right) ComparativeCompution instance.
	 */
	public static ComparativeCompution isGreaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.isGreaterThan(left, right);
	}
	
	/**
	 * Returns (left >= right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left >= right) ComparativeCompution instance.
	 */
	public static ComparativeCompution isGreaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return NumberUtils.isGreaterThanOrEqualTo(left, right);
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
	public static <T, U> ComparativeCompution isEqualTo(ObjectObservable<T> a, ObjectObservable<U> b) {
		return ObjectUtils.computeIsEqualTo(a, b);
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
	public static <T, U> ComparativeCompution isNotEqualTo(ObjectObservable<T> a, ObjectObservable<U> b) {
		return ObjectUtils.computeIsNotEqualTo(a, b);
	}
	
}
