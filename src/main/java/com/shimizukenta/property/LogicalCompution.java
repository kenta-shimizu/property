package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * Logical Boolean compution, includes Getter, Observer.
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
	 * @param observables
	 * @return AND(&&) Logical Compution instance.
	 */
	public static LogicalCompution and(BooleanObservable... observers) {
		return and(Arrays.asList(observers));
	}
	
	/**
	 * Returns AND(&&) Logical Compution instance.
	 * 
	 * @param observers
	 * @return AND(&&) Logical Compution instance.
	 */
	public static LogicalCompution and(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.and(observers);
	}
	
	/**
	 * Returns OR(||) Logical Compution instance.
	 * 
	 * @param observers
	 * @return OR(||) Logical Compution instance.
	 */
	public static LogicalCompution or(BooleanObservable... observers) {
		return or(Arrays.asList(observers));
	}
	
	/**
	 * Returns OR(||) Logical Compution instance.
	 * 
	 * @param observers
	 * @return OR(||) Logical Compution instance.
	 */
	public static LogicalCompution or(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.or(observers);
	}
	
	/**
	 * Returns NOT(!) Logical Compution instance.
	 * 
	 * @param observer
	 * @return NOT(!) Logical Compution instance.
	 */
	public static LogicalCompution not(BooleanObservable observer) {
		return BooleanUtils.not(observer);
	}
	
	/**
	 * Returns XOR(^) Logical Compution instance.
	 * 
	 * @param a
	 * @param b
	 * @return XOR(^) Logical Compution instance.
	 */
	public static LogicalCompution xor(BooleanObservable a, BooleanObservable b) {
		return BooleanUtils.xor(a, b);
	}
	
	/**
	 * Returns NAND Logical Compution instance.
	 * 
	 * <p>Returns NOT(AND) compution.</p>
	 * 
	 * @param observers
	 * @return NAND Logical Compution instance.
	 */
	public static LogicalCompution nand(BooleanObservable... observers) {
		return nand(Arrays.asList(observers));
	}
	
	/**
	 * Returns NAND Logical Compution instance.
	 * 
	 * <p>Returns NOT(AND) compution.</p>
	 * 
	 * @param observers
	 * @return NAND Logical Compution instance.
	 */
	public static LogicalCompution nand(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.nand(observers);
	}
	
	/**
	 * Returns NOR Logical Compution instance.
	 * 
	 * <p>Returns NOT(OR) compution.</p>
	 * 
	 * @param observers
	 * @return NOR Logical Compution instance.
	 */
	public static LogicalCompution nor(BooleanObservable... observers) {
		return nor(Arrays.asList(observers));
	}
	
	/**
	 * Returns NOR Logical Compution instance.
	 * 
	 * <p>Returns NOT(OR) compution.</p>
	 * 
	 * @param observers
	 * @return NOR Logical Compution instance.
	 */
	public static LogicalCompution nor(Collection<? extends BooleanObservable> observers) {
		return BooleanUtils.nor(observers);
	}
	
}
