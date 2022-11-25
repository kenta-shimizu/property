package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface ObjectProperty<T> extends Property<T>, ObjectGettable<T>, ObjectSettable<T>, ObjectObservable<T> {
	
	/**
	 * Instance builder.
	 * 
	 * @param <T> Type
	 * @param initial
	 * @return new-instance.
	 */
	public static <T> ObjectProperty<T> newInstance(T initial) {
		return new AbstractObjectProperty<T>(initial) {
			
			private static final long serialVersionUID = 5265321993153340447L;
		};
	}
}
