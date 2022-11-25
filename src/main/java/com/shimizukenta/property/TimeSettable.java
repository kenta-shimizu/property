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
	 * @param value
	 */
	public void set(TimeoutAndUnit value);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	public void set(int seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	public void set(long seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	public void set(float seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param seconds
	 */
	public void set(double seconds);
	
	/**
	 * Value setter.
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void set(long timeout, TimeUnit unit);
	
}
