package com.shimizukenta.property;

/**
 * Long value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(long)}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 * @see NumberProperty
 * @see LongSettable
 * @see Long
 *
 */
public interface LongProperty extends NumberProperty<Long>, LongSettable {
	
	/**
	 * LongProperty builder.
	 * 
	 * @param initial
	 * @return new-instance
	 */
	public static LongProperty newInstance(long initial) {
		return new AbstractLongProperty(initial) {

			private static final long serialVersionUID = 7554055723290491976L;
		};
	}
	
}
