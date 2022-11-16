package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface TimeoutAndUnit {

	public long timeout();

	public TimeUnit unit();
	
	default public long getMilliSeconds() {
		return this.unit().toMillis(this.timeout());
	}
	
	public static TimeoutAndUnit of(long timeout, TimeUnit unit) {
		return new AbstractTimeoutAndUnit(timeout, unit) {

			private static final long serialVersionUID = -1751240708640861755L;
		};
	}

	public static TimeoutAndUnit of(int seconds) {
		return of((long)seconds, TimeUnit.SECONDS);
	}
	
	public static TimeoutAndUnit of(long seconds) {
		return of(seconds, TimeUnit.SECONDS);
	}
	
	public static TimeoutAndUnit of(float seconds) {
		return of((long)(seconds * 1000.0F), TimeUnit.MILLISECONDS);
	}
	
	public static TimeoutAndUnit of(double seconds) {
		return of((long)(seconds * 1000000.0D), TimeUnit.MICROSECONDS);
	}
	
}
