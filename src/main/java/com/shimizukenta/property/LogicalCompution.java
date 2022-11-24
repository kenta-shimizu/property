package com.shimizukenta.property;

import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface LogicalCompution extends BooleanCompution {
	
	/**
	 * Returns AND(&&) Logical Compution instance.
	 * 
	 * @param observables
	 * @return AND(&&) Logical Compution instance.
	 */
	public static LogicalCompution and(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().and(observables);
	}
	
	/**
	 * Returns AND(&&) Logical Compution instance.
	 * 
	 * @param observables
	 * @return AND(&&) Logical Compution instance.
	 */
	public static LogicalCompution and(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().and(observables);
	}
	
	/**
	 * Returns OR(||) Logical Compution instance.
	 * 
	 * @param observables
	 * @return OR(||) Logical Compution instance.
	 */
	public static LogicalCompution or(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().or(observables);
	}
	
	/**
	 * Returns OR(||) Logical Compution instance.
	 * 
	 * @param observables
	 * @return OR(||) Logical Compution instance.
	 */
	public static LogicalCompution or(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().or(observables);
	}
	
	/**
	 * Returns NOT(!) Logical Compution instance.
	 * 
	 * @param observable
	 * @return NOT(!) Logical Compution instance.
	 */
	public static LogicalCompution not(BooleanObservable observable) {
		return LogicalComputionBuilder.getInstance().not(observable);
	}
	
	/**
	 * Returns XOR(^) Logical Compution instance.
	 * 
	 * @param a
	 * @param b
	 * @return XOR(^) Logical Compution instance.
	 */
	public static LogicalCompution xor(BooleanObservable a, BooleanObservable b) {
		return LogicalComputionBuilder.getInstance().xor(a, b);
	}
	
	/**
	 * Returns NAND Logical Compution instance.
	 * 
	 * <p>Returns NOT(AND) compution.</p>
	 * 
	 * @param observables
	 * @return NAND Logical Compution instance.
	 */
	public static LogicalCompution nand(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().nand(observables);
	}
	
	/**
	 * Returns NAND Logical Compution instance.
	 * 
	 * <p>Returns NOT(AND) compution.</p>
	 * 
	 * @param observables
	 * @return NAND Logical Compution instance.
	 */
	public static LogicalCompution nand(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().nand(observables);
	}
	
	/**
	 * Returns NOR Logical Compution instance.
	 * 
	 * <p>Returns NOT(OR) compution.</p>
	 * 
	 * @param observables
	 * @return NOR Logical Compution instance.
	 */
	public static LogicalCompution nor(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().nor(observables);
	}
	
	/**
	 * Returns NOR Logical Compution instance.
	 * 
	 * <p>Returns NOT(OR) compution.</p>
	 * 
	 * @param observables
	 * @return NOR Logical Compution instance.
	 */
	public static LogicalCompution nor(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().nor(observables);
	}
	
}
