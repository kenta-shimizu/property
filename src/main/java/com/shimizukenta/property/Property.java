package com.shimizukenta.property;

import java.io.Serializable;

//public interface Property<T, U extends Settable<T>> extends Gettable<T>, Settable<T>, Observable<T, U>, Serializable {
public interface Property<T> extends Gettable<T>, Settable<T>, Observable<T>, Serializable {
	
}
