/**
 * 
 */
package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface FloatProperty extends NumberProperty<Float>, FloatGettable, FloatSettable, FloatObservable {
	
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
