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
		this.set((long)seconds, TimeUnit.SECONDS);
	}
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(long seconds) {
		this.set(seconds, TimeUnit.SECONDS);
	}
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(float seconds) {
		long ms = (long)(seconds * 1000.0F);
		this.set(ms, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	default public void set(double seconds) {
		long ms = (long)(seconds * 1000.0D);
		this.set(ms, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Value setter.
	 * 
	 * @param timeout
	 * @param unit
	 */
	default public void set(long timeout, TimeUnit unit) {
		this.set(new TimeoutAndUnit(timeout, unit));
	}
	
}
