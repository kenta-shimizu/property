package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TimeoutAndUnit {
	
	private final long timeout;
	private final TimeUnit unit;
	
	public TimeoutAndUnit(long timeout, TimeUnit unit) {
		if ( timeout < 0L ) {
			throw new IllegalArgumentException("timeout must >=0L");
		}
		this.timeout = timeout;
		this.unit = Objects.requireNonNull(unit);
	}
	
	public long timeout() {
		return this.timeout;
	}
	
	public TimeUnit unit() {
		return this.unit;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other != null && (other instanceof TimeoutAndUnit)) {
			TimeoutAndUnit o = (TimeoutAndUnit)other;
			return o.timeout == this.timeout && o.unit == this.unit;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.timeout, this.unit);
	}
	
}
