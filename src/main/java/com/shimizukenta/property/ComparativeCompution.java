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
		return ComparativeComputionBuilder.getInstance().equalTo(left, right);
	}
	
	/**
	 * Returns (left != right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left != right) ComparativeCompution instance.
	 */
	public static ComparativeCompution notEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().notEqualTo(left, right);
	}
	
	/**
	 * Returns (left < right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left < right) ComparativeCompution instance.
	 */
	public static ComparativeCompution lessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().lessThan(left, right);
	}
	
	/**
	 * Returns (left <= right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left <= right) ComparativeCompution instance.
	 */
	public static ComparativeCompution lessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().lessThanOrEqualTo(left, right);
	}
	
	/**
	 * Returns (left > right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left > right) ComparativeCompution instance.
	 */
	public static ComparativeCompution greaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().greaterThan(left, right);
	}
	
	/**
	 * Returns (left >= right) ComparativeCompution instance.
	 * 
	 * @param left
	 * @param right
	 * @return (left >= right) ComparativeCompution instance.
	 */
	public static ComparativeCompution greaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return ComparativeComputionBuilder.getInstance().greaterThanOrEqualTo(left, right);
	}
	
}
