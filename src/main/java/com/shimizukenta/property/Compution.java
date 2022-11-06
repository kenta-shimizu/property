package com.shimizukenta.property;

import java.io.Serializable;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T>
 * @param <U>
 */
public interface Compution<T, U extends Settable<T>> extends Gettable<T>, Observable<T, U>, Serializable {

}
