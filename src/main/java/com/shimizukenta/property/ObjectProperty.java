package com.shimizukenta.property;

/**
 * Object value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(Object)}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 * @see ObjectGettable
 * @see ObjectSettable
 * @see ObjectObservable
 * @see Property
 * 
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
