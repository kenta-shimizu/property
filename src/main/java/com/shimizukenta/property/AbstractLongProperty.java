/**
 * 
 */
package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author kenta-shimizu
 *
 */
public abstract class AbstractLongProperty extends AbstractNumberProperty<Long> implements LongProperty {
	
	private static final long serialVersionUID = 9186020409952044558L;

	protected AbstractLongProperty(long initial) {
		super(Long.valueOf(initial));
	}
	
	@Override
	public void set(Long value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(long value) {
		super.set(Long.valueOf(value));
	}

	@Override
	protected boolean _isEqualTo(int value) {
		return this.longValue() == (long)value;
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
		return this.longValue() < (long)value;
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
		return this.longValue() <= (long)value;
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
		return this.longValue() > (long)value;
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
		return this.longValue() >= (long)value;
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
		this.waitUntilEqualTo(0L);
	}

	@Override
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(0L, timeout, unit);
	}

	@Override
	public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(0L);
	}

	@Override
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(0L, timeout, unit);
	}

	@Override
	public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(0L);
	}

	@Override
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(0L, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(0L);
	}

	@Override
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(0L, timeout, unit);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(0L);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(0L, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(0L);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(0L, timeout, unit);
	}
	
}
