package com.shimizukenta.property;

/**
 * Object value Getter.
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 * @see Gettable
 * 
 */
public interface ObjectGettable<T> extends Gettable<T> {
	
	/**
	 * Value getter.
	 * 
	 * @return value.
	 */
	public T get();
	
	/**
	 * Returns {@code true} if value is {@code null}, otherwise {@code false}.
	 * 
	 * @return {@code true} if value is {@code null}, otherwise {@code false}.
	 */
	default boolean isNull() {
		return this.get() == null;
	}
}
