package com.shimizukenta.property;

import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface LogicalCompution extends BooleanCompution {
	
	public static BooleanCompution and(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().and(observables);
	}
	
	public static LogicalCompution and(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().and(observables);
	}
	
	public static LogicalCompution or(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().or(observables);
	}
	
	public static LogicalCompution or(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().or(observables);
	}
	
	public static LogicalCompution not(BooleanObservable observable) {
		return LogicalComputionBuilder.getInstance().not(observable);
	}
	
	public static LogicalCompution xor(BooleanObservable a, BooleanObservable b) {
		return LogicalComputionBuilder.getInstance().xor(a, b);
	}
	
	public static LogicalCompution nand(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().nand(observables);
	}
	
	public static LogicalCompution nand(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().nand(observables);
	}
	
	public static LogicalCompution nor(BooleanObservable... observables) {
		return LogicalComputionBuilder.getInstance().nor(observables);
	}
	
	public static LogicalCompution nor(Collection<? extends BooleanObservable> observables) {
		return LogicalComputionBuilder.getInstance().nor(observables);
	}
	
}
