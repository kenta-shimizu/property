package com.shimizukenta.property;

/**
 * Boolean value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(boolean)}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 * @see Boolean
 * @see BooleanGettable
 * @see BooleanSettable
 * @see BooleanObservable
 * @see Property
 *
 */
public interface BooleanProperty extends Property<Boolean>, BooleanGettable, BooleanSettable, BooleanObservable {
	
	/**
	 * BooleanProperty builder.
	 * 
	 * @param initial is boolean
	 * @return new-instance.
	 */
	public static BooleanProperty newInstance(boolean initial) {
		
		return new AbstractBooleanProperty(initial) {
			
			private static final long serialVersionUID = 6612758414318404939L;
		};
	}
}
