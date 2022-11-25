package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author kenta-shimizu
 *
 */
//public abstract class AbstractTimeProperty extends AbstractProperty<TimeoutAndUnit, TimeSettable> implements TimeProperty {
public abstract class AbstractTimeProperty extends AbstractProperty<TimeoutAndUnit> implements TimeProperty {
	
	private static final long serialVersionUID = -8510457745679120175L;
	
	protected AbstractTimeProperty(TimeoutAndUnit initial) {
		super(initial);
	}
	
	@Override
	public void set(TimeoutAndUnit value) {
		this._syncSetAndNotifyChanged(Objects.requireNonNull(value));
	}
	
	public void set(int seconds) {
		this._syncSetAndNotifyChanged(TimeoutAndUnit.of(seconds));
	}
	
	public void set(long seconds) {
		this._syncSetAndNotifyChanged(TimeoutAndUnit.of(seconds));
	}
	
	public void set(float seconds) {
		this._syncSetAndNotifyChanged(TimeoutAndUnit.of(seconds));
	}
	
	public void set(double seconds) {
		this._syncSetAndNotifyChanged(TimeoutAndUnit.of(seconds));
	}
	
	public void set(long timeout, TimeUnit unit) {
		this._syncSetAndNotifyChanged(TimeoutAndUnit.of(timeout, unit));
	}

	
	@Override
	public TimeoutAndUnit get() {
		return this._simpleGet();
	}
	
}
