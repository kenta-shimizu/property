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
public abstract class AbstractFloatProperty extends AbstractNumberProperty<Float> implements FloatProperty {

	private static final long serialVersionUID = 7439939403442859342L;

	protected AbstractFloatProperty(float initial) {
		super(Float.valueOf(initial));
	}
	
	@Override
	public void set(Float value) {
		super.set(Objects.requireNonNull(value));
	}

	@Override
	public void set(float value) {
		super.set(Float.valueOf(value));
	}

	@Override
	protected boolean _isEqualTo(int value) {
		return this.floatValue() == (float)value;
	}

	@Override
	protected boolean _isEqualTo(long value) {
		return this.floatValue() == (float)value;
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
		return this.floatValue() < (float)value;
	}

	@Override
	protected boolean _isLessThan(long value) {
		return this.floatValue() < (float)value;
	}

	@Override
	protected boolean _isLessThan(float value) {
		return this.floatValue() < value;
	}

	@Override
	protected boolean _isLessThan(double value) {
		return this.doubleValue() < (double)value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(int value) {
		return this.floatValue() <= (float)value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(long value) {
		return this.floatValue() <= (float)value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(float value) {
		return this.floatValue() <= value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(double value) {
		return this.doubleValue() <= (double)value;
	}

	@Override
	protected boolean _isGreaterThan(int value) {
		return this.floatValue() > (float)value;
	}

	@Override
	protected boolean _isGreaterThan(long value) {
		return this.floatValue() > (float)value;
	}

	@Override
	protected boolean _isGreaterThan(float value) {
		return this.floatValue() > value;
	}

	@Override
	protected boolean _isGreaterThan(double value) {
		return this.doubleValue() > (double)value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(int value) {
		return this.floatValue() >= (float)value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(long value) {
		return this.floatValue() >= (float)value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(float value) {
		return this.floatValue() >= value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(double value) {
		return this.doubleValue() >= (double)value;
	}
	
	@Override
	public void waitUntilEqualToZero() throws InterruptedException {
		this.waitUntilEqualTo(0.0F);
	}

	@Override
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(0.0F, timeout, unit);
	}

	@Override
	public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(0.0F);
	}

	@Override
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(0.0F, timeout, unit);
	}

	@Override
	public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(0.0F);
	}

	@Override
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(0.0F, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(0.0F);
	}

	@Override
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(0.0F, timeout, unit);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(0.0F);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(0.0F, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(0.0F);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(0.0F, timeout, unit);
	}
	
}
