package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * Logical Boolean compution, includes Getter, Observer.
 * 
 * <ul>
 * <li>To get AND(&&) Compution, {@link #and(BooleanObservable...)}.</li>
 * <li>To get OR(||) Compution, {@link #or(BooleanObservable...)}.</li>
 * <li>To get NOT(!) Compution, {@link #not()}.</li>
 * <li>To get XOR(^) Compution, {@link #xor(BooleanObservable, BooleanObservable)}.</li>
 * <li>To get NAND Compution, {@link #nand(BooleanObservable...)}.</li>
 * <li>To get NOR Compution, {@link #nor(BooleanObservable...)}.</li>
 * </ul>
 * 
 * 
 * @author kenta-shimizu
 * @see BooleanCompution
 * @see Boolean
 *
 */
public interface LogicalCompution extends BooleanCompution {
	
	/**
	 * Returns AND(&&) Logical Compution instance.
	 * 
	 * @param observers
	 * @return AND(&&) Logical Compution instance
	 * @see #and(Collection)
	 */
	public static LogicalCompution and(BooleanObservable... observers) {
		return and(Arrays.asList(observers));
	}
	
	/**
	 * Returns AND(&&) Logical Compution instance.
	 * 
	 * @param observers
	 * @return AND(&&) Logical Compution instance
	 * @see #and(BooleanObservable...)
	 */
	public static LogicalCompution and(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.and(observers);
	}
	
	/**
	 * Returns OR(||) Logical Compution instance.
	 * 
	 * @param observers
	 * @return OR(||) Logical Compution instance
	 * @see #or(Collection)
	 */
	public static LogicalCompution or(BooleanObservable... observers) {
		return or(Arrays.asList(observers));
	}
	
	/**
	 * Returns OR(||) Logical Compution instance.
	 * 
	 * @param observers
	 * @return OR(||) Logical Compution instance
	 * @see #or(BooleanObservable...)
	 */
	public static LogicalCompution or(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.or(observers);
	}
	
	/**
	 * Returns NOT(!) Logical Compution instance.
	 * 
	 * @param observer
	 * @return NOT(!) Logical Compution instance
	 */
	public static LogicalCompution not(BooleanObservable observer) {
		return BooleanUtils.not(observer);
	}
	
	/**
	 * Returns XOR(^) Logical Compution instance.
	 * 
	 * @param a
	 * @param b
	 * @return XOR(^) Logical Compution instance
	 */
	public static LogicalCompution xor(BooleanObservable a, BooleanObservable b) {
		return BooleanUtils.xor(a, b);
	}
	
	/**
	 * Returns NAND Logical Compution instance.
	 * 
	 * <p>
	 * Returns NOT(AND) compution.<br />
	 * </p>
	 * 
	 * @param observers
	 * @return NAND Logical Compution instance
	 * @see #nand(Collection)
	 */
	public static LogicalCompution nand(BooleanObservable... observers) {
		return nand(Arrays.asList(observers));
	}
	
	/**
	 * Returns NAND Logical Compution instance.
	 * 
	 * <p>
	 * Returns NOT(AND) compution.<br />
	 * </p>
	 * 
	 * @param observers
	 * @return NAND Logical Compution instance
	 * @see #nand(BooleanObservable...)
	 */
	public static LogicalCompution nand(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.nand(observers);
	}
	
	/**
	 * Returns NOR Logical Compution instance.
	 * 
	 * <p>
	 * Returns NOT(OR) compution.<br />
	 * </p>
	 * 
	 * @param observers
	 * @return NOR Logical Compution instance
	 * @see #nor(Collection)
	 */
	public static LogicalCompution nor(BooleanObservable... observers) {
		return nor(Arrays.asList(observers));
	}
	
	/**
	 * Returns NOR Logical Compution instance
	 * 
	 * <p>
	 * Returns NOT(OR) compution.<br />
	 * </p>
	 * 
	 * @param observers
	 * @return NOR Logical Compution instance.
	 * @see #nor(BooleanObservable...)
	 */
	public static LogicalCompution nor(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.nor(observers);
	}
	
}
