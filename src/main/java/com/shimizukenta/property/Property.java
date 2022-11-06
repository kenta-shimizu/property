package com.shimizukenta.property;

import java.io.Serializable;

public interface Property<T, U extends Settable<T>> extends Gettable<T>, Settable<T>, Observable<T, U>, Serializable {
	
	/**
	 * Create new instance.
	 * 
	 * @param value
	 * @return new-instance
	 */
	public static <T, U extends Settable<T>> Property<T, U> newInstance(T value) {
		return new AbstractProperty<T, U>(value) {
			
			private static final long serialVersionUID = -6407521187509143877L;
		};
	}
}
