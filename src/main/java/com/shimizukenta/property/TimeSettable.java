package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface TimeSettable extends Settable<TimeoutAndUnit> {
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(int seconds) {
		this.set(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(long seconds) {
		this.set(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(float seconds) {
		this.set(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(double seconds) {
		this.set(TimeoutAndUnit.of(seconds));
	}
	
	/**
	 * Value setter.
	 * 
	 * @param timeout
	 * @param unit
	 */
	default public void set(long timeout, TimeUnit unit) {
		this.set(TimeoutAndUnit.of(timeout, unit));
	}
	
}
