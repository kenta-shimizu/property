package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * TimeoutAndUnit value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * Build instance via {@link #newInstance(long, TimeUnit)}.<br />
 * </p>
 * 
 * @author kenta-shimizu
 * @see TimeUnit
 * @see TimeoutAndUnit
 * @see TimeoutGettable
 * @see TimeoutSettable
 * @see TimeoutObservable
 * @see Property
 *
 */
public interface TimeoutProperty extends Property<TimeoutAndUnit>, TimeoutGettable, TimeoutSettable, TimeoutObservable {
	
	/**
	 * TimeouyProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(int seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(long seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(float seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(double seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param timeout
	 * @param unit
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(long timeout, TimeUnit unit) {
		return newInstance(TimeoutAndUnit.of(timeout, unit));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param value
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(TimeoutAndUnit value) {
		
		return new AbstractTimeoutProperty(Objects.requireNonNull(value)) {
			
			private static final long serialVersionUID = 905918685867216201L;
		};
	}
	
}
