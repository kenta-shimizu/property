package com.shimizukenta.property;

/**
 * Boolean value compution, includes Getter and Observer.
 * 
 * <p>
 * <strong>NOT</strong> includes Setter.<br />
 * </p>
 * 
 * @author kenta-shimizu
 * @see Boolean
 * @see BooleanGettable
 * @see BooleanObservable
 * @see Compution
 *
 */
public interface BooleanCompution extends Compution<Boolean>, BooleanGettable, BooleanObservable {
	
}
