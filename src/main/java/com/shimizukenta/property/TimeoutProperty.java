package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * TimeoutAndUnit value Property, includes Getter, Setter, Observer.
 * 
 * <p>
 * This instance can be used as waitUntil-method's timeout parameter.<br />
 * </p>
 * <ul>
 * <li>To build instance,
 * <ul>
 * <li>{@link #newInstance(long, TimeUnit)}.</li>
 * <li>{@link #newInstance(float)}.</li>
 * </ul>
 * </li>
 * <li>To set value,
 * <ul>
 * <li>{@link #set(long, TimeUnit)}.</li>
 * <li>{@link #set(float)}.</li>
 * </ul>
 * </li>
 * <li>To detect value changed, {@link #addChangeListener(ChangeListener)}.</li>
 * <li>Utility methods,
 * <ul>
 * <li>{@link #sleep()}.</li>
 * <li>{@link #wait(Object)}.</li>
 * <li>{@link #blockingQueuePoll(java.util.concurrent.BlockingQueue)}.</li>
 * <li>{@link #futureGet(java.util.concurrent.Future)}.</li>
 * <li>{@link #invokeAll(java.util.concurrent.ExecutorService, java.util.Collection)}.</li>
 * <li>{@link #invokeAny(java.util.concurrent.ExecutorService, java.util.Collection)}.</li>
 * </ul>
 * </li>
 * </ul>
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
	 * @param seconds is int
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(int seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param seconds is long
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(long seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param seconds is float
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(float seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param seconds is double
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(double seconds) {
		return newInstance(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param timeout is long
	 * @param unit is TimeUnit
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(long timeout, TimeUnit unit) {
		return newInstance(TimeoutAndUnit.of(timeout, unit));
	}
	
	/**
	 * TimeoutProperty builder.
	 * 
	 * @param value is TimeoutAndUnit
	 * @return new-instance
	 */
	public static TimeoutProperty newInstance(TimeoutAndUnit value) {
		
		return new AbstractTimeoutProperty(Objects.requireNonNull(value)) {
			
			private static final long serialVersionUID = 905918685867216201L;
		};
	}
	
}
