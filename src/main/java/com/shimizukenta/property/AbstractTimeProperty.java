package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractTimeProperty extends AbstractProperty<TimeoutAndUnit, TimeSettable> implements TimeProperty {
	
	private static final long serialVersionUID = -8510457745679120175L;
	
	protected AbstractTimeProperty(TimeoutAndUnit initial) {
		super(initial);
	}
	
	@Override
	public void set(TimeoutAndUnit value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(long timeout, TimeUnit unit) {
		TimeoutAndUnit v = TimeoutAndUnit.of(timeout, unit);
		super.set(v);
	}
	
	@Override
	public String toString() {
		TimeoutAndUnit a = this.get();
		return "{\"timeout\": " + a.timeout() + ", \"unit\": " + a.unit() + "}";
	}
}
