package com.shimizukenta.property;

/**
 * Object value Compution, includes Getter, Observer.
 * 
 * <p>
 * <strong>NOT</strong> includes Setter.<br />
 * </p>
 * 
 * @author kentashimizu
 *
 * @param <T> Type
 * @see ObjectGettable
 * @see ObjectObservable
 * @see Compution
 * 
 */
public interface ObjectCompution<T> extends Compution<T>, ObjectGettable<T>, ObjectObservable<T> {
	
}
