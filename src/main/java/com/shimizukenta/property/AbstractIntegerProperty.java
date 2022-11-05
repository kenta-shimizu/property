/**
 * 
 */
package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractIntegerProperty extends AbstractNumberProperty<Integer> implements IntegerProperty {
	
	private static final long serialVersionUID = -305818540574009744L;
	
	protected AbstractIntegerProperty(int initial) {
		super(Integer.valueOf(initial));
	}
	
	@Override
	public void set(Integer value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(int value) {
		super.set(Integer.valueOf(value));
	}
	
	@Override
	protected boolean _isEqualTo(int value) {
		return this.intValue() == value;
	}

	@Override
	protected boolean _isEqualTo(long value) {
		return this.longValue() == value;
	}

	@Override
	protected boolean _isEqualTo(float value) {
		return this.floatValue() == value;
	}

	@Override
	protected boolean _isEqualTo(double value) {
		return this.doubleValue() == value;
	}

	@Override
	protected boolean _isLessThan(int value) {
		return this.intValue() < value;
	}

	@Override
	protected boolean _isLessThan(long value) {
		return this.longValue() < value;
	}

	@Override
	protected boolean _isLessThan(float value) {
		return this.floatValue() < value;
	}

	@Override
	protected boolean _isLessThan(double value) {
		return this.doubleValue() < value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(int value) {
		return this.intValue() <= value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(long value) {
		return this.longValue() <= value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(float value) {
		return this.floatValue() <= value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(double value) {
		return this.doubleValue() <= value;
	}

	@Override
	protected boolean _isGreaterThan(int value) {
		return this.intValue() > value;
	}

	@Override
	protected boolean _isGreaterThan(long value) {
		return this.longValue() > value;
	}

	@Override
	protected boolean _isGreaterThan(float value) {
		return this.floatValue() > value;
	}

	@Override
	protected boolean _isGreaterThan(double value) {
		return this.doubleValue() > value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(int value) {
		return this.intValue() >= value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(long value) {
		return this.longValue() >= value; 
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(float value) {
		return this.floatValue() >= value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(double value) {
		return this.doubleValue() >= value;
	}
	
	@Override
	public void waitUntilEqualToZero() throws InterruptedException {
		this.waitUntilEqualTo(0);
	}
	
	@Override
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(0, timeout, unit);
	}

	@Override
	public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(0);
	}

	@Override
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(0, timeout, unit);
	}

	@Override
	public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(0);
	}

	@Override
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(0, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(0);
	}

	@Override
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(0, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(0);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(0, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(0);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(0, timeout, unit);
	}
	
}
