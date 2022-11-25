package com.shimizukenta.property;

import java.io.Serializable;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface Property<T> extends Gettable<T>, Settable<T>, Observable<T>, Serializable {
	
}
