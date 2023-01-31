/**
 * 
 */
package com.shimizukenta.property;

/**
 * Float value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(float)}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 * @see NumberProperty
 * @see FloatSettable
 * @see Float
 *
 */
public interface FloatProperty extends NumberProperty<Float>, FloatSettable {
	
	/**
	 * FloatProperty builder.
	 * 
	 * @param initial
	 * @return new-instance
	 */
	public static FloatProperty newInstance(float initial) {
		return new AbstractFloatProperty(initial) {

			private static final long serialVersionUID = 8573727566044779674L;
		};
	}
	
}
