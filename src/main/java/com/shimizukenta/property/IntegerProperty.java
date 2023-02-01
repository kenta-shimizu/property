package com.shimizukenta.property;

/**
 * Integer value Property, includes Getter, Setter, Observer.
 * 
 * <ul>
 * <li>To build instance, {@link #newInstance(int)}.</li>
 * <li>To get value, {@link #byteValue()}, {@link #shortValue()}, {@link #intValue()}, {@link #longValue()}, {@link #floatValue()}, {@link #doubleValue()}.</li>
 * <li>To set value, {@link #set(int)}.</li>
 * <li>To detect value changed, {@link #addChangeListener(ChangeListener)}.</li>
 * </ul>
 * 
 * @author kenta-shimizu
 * @see NumberProperty
 * @see IntegerSettable
 * @see Integer
 *
 */
public interface IntegerProperty extends NumberProperty<Integer>, IntegerSettable {
	
	/**
	 * IntegerProperty builder.
	 * 
	 * @param initial
	 * @return new-instance
	 */
	public static IntegerProperty newInstance(int initial) {
		return new AbstractIntegerProperty(initial) {
			
			private static final long serialVersionUID = 3586226547691845115L;
		};
	}
	
}
