package com.shimizukenta.property;

/**
 * @author kenta-shimizu
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
