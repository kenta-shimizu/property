package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface TimeProperty extends Property<TimeoutAndUnit, WritableTimeProperty>, ReadOnlyTimeProperty, WritableTimeProperty {
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(int seconds) {
		return newInstance(
				(long)seconds,
				TimeUnit.SECONDS);
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(long seconds) {
		return newInstance(seconds, TimeUnit.SECONDS);
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(float seconds) {
		return newInstance(
				(long)(seconds * 1000.0F),
				TimeUnit.MILLISECONDS);
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(double seconds) {
		return newInstance(
				(long)(seconds * 1000.0D),
				TimeUnit.MILLISECONDS);
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param timeout
	 * @param unit
	 * @return new-instance
	 */
	public static TimeProperty newInstance(long timeout, TimeUnit unit) {
		return newInstance(new TimeoutAndUnit(timeout, unit));
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param value
	 * @return new-instance
	 */
	public static TimeProperty newInstance(TimeoutAndUnit value) {
		
		return new AbstractTimeProperty(value) {
			private static final long serialVersionUID = 905918685867216201L;
		};
	}
	
}
