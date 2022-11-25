package com.shimizukenta.property;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTimeoutAndUnit implements TimeoutAndUnit, Serializable {
	
	private static final long serialVersionUID = -8263697919297198015L;
	
	private final long timeout;
	private final TimeUnit unit;
	
	protected AbstractTimeoutAndUnit(long timeout, TimeUnit unit) {
		if ( timeout < 0L ) {
			throw new IllegalArgumentException("timeout must >=0L");
		}
		this.timeout = timeout;
		this.unit = Objects.requireNonNull(unit);
	}
	
	@Override
	public long timeout() {
		return this.timeout;
	}
	
	@Override
	public TimeUnit unit() {
		return this.unit;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other != null && (other instanceof AbstractTimeoutAndUnit)) {
			AbstractTimeoutAndUnit o = (AbstractTimeoutAndUnit)other;
			return o.timeout == this.timeout && o.unit == this.unit;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.timeout, this.unit);
	}
	
	@Override
	public String toString() {
		return "{\"timeout\": " + this.timeout + ", \"unit\": " + this.unit.toString() + "}";
	}
	
}
