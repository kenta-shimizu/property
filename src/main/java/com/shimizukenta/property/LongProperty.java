/**
 * 
 */
package com.shimizukenta.property;

/**
 * @author kenta-shimizu
 *
 */
public interface LongProperty extends NumberProperty<Long>, LongGettable, LongSettable, LongObservable {
	
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
