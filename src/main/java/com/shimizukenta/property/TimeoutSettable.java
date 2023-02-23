package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;

/**
 * TimeoutAndUnit value Setter.
 * 
 * @author kenta-shimizu
 * @see TimeUnit
 * @see TimeoutAndUnit
 * @see Settable
 *
 */
public interface TimeoutSettable extends Settable<TimeoutAndUnit> {
	
	/**
	 * Value setter.
	 * 
	 * @param value is TimeoutAndUnit
	 */
	public void set(TimeoutAndUnit value);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds is int
	 */
	public void set(int seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds is long
	 */
	public void set(long seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds is float
	 */
	public void set(float seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds is double
	 */
	public void set(double seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param timeout is long
	 * @param unit is TimeUnit
	 */
	public void set(long timeout, TimeUnit unit);
	
}
