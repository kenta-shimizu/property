package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Build instance via {@link #newInstance(long, TimeUnit)}.
 * 
 * @author kenta-shimizu
 *
 */
public interface TimeProperty extends Property<TimeoutAndUnit>, TimeGettable, TimeSettable, TimeObservable {
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(int seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(long seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(float seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param seconds
	 * @return new-instance
	 */
	public static TimeProperty newInstance(double seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param timeout
	 * @param unit
	 * @return new-instance
	 */
	public static TimeProperty newInstance(long timeout, TimeUnit unit) {
		return newInstance(TimeoutAndUnit.of(timeout, unit));
	}
	
	/**
	 * TimeProperty builder.
	 * 
	 * @param value
	 * @return new-instance
	 */
	public static TimeProperty newInstance(TimeoutAndUnit value) {
		
		return new AbstractTimeProperty(Objects.requireNonNull(value)) {
			
			private static final long serialVersionUID = 905918685867216201L;
		};
	}
	
}
