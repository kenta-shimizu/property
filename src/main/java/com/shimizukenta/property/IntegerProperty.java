package com.shimizukenta.property;

/**
 * Integer value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(int)}.<br />
 * </p>
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
