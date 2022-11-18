/**
 * 
 */
package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface DoubleProperty extends NumberProperty<Double>, DoubleGettable, DoubleSettable, DoubleObservable {
	
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
