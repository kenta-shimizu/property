package com.shimizukenta.property;

import java.io.Serializable;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface Compution<T> extends Gettable<T>, Observable<T>, Serializable {

}
