package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T>
 */
public interface ObjectGettable<T> extends Gettable<T> {
	
	/**
	 * Returns true if value is null, otherwise false.
	 * 
	 * @return true if value is null, otherwise false.
	 */
	default boolean isNull() {
		return this.get() == null;
	}
}
