package com.shimizukenta.property;

/**
 * Double value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(double)}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 * @see NumberProperty
 * @see DoubleSettable
 * @see Double
 *
 */
public interface DoubleProperty extends NumberProperty<Double>, DoubleSettable {
	
	/**
	 * DoubleProperty builder.
	 * 
	 * @param initial
	 * @return new-instance
	 */
	public static DoubleProperty newInstance(double initial) {
		
		return new AbstractDoubleProperty(initial) {

			private static final long serialVersionUID = 4382190762511155799L;
		};
	}
	
}
