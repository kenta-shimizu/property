package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface BooleanProperty extends Property<Boolean, BooleanSettable>, BooleanGettable, BooleanSettable, BooleanObservable {
	
	/**
	 * BooleanProperty builder.
	 * 
	 * @param initial
	 * @return new-instance.
	 */
	public static BooleanProperty newInstance(boolean initial) {
		
		return new AbstractBooleanProperty(initial) {
			
			private static final long serialVersionUID = 6612758414318404939L;
		};
	}
}
