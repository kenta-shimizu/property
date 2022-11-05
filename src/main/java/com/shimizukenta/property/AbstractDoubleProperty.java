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
public abstract class AbstractDoubleProperty extends AbstractNumberProperty<Double> implements DoubleProperty {
	
	private static final long serialVersionUID = 887820836308020057L;
	
	protected AbstractDoubleProperty(double initial) {
		super(Double.valueOf(initial));
	}
	
	@Override
	public void set(Double value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(double value) {
		super.set(Double.valueOf(value));
	}
	
	@Override
	protected boolean _isEqualTo(int value) {
		return this.doubleValue() == (double)value;
	}

	@Override
	protected boolean _isEqualTo(long value) {
		return this.doubleValue() == (double)value;
	}

	@Override
	protected boolean _isEqualTo(float value) {
		return this.doubleValue() == (double)value;
	}

	@Override
	protected boolean _isEqualTo(double value) {
		return this.doubleValue() == value;
	}

	@Override
	protected boolean _isLessThan(int value) {
		return this.doubleValue() < (double)value;
	}

	@Override
	protected boolean _isLessThan(long value) {
		return this.doubleValue() < (double)value;
	}

	@Override
	protected boolean _isLessThan(float value) {
		return this.doubleValue() < (double)value;
	}

	@Override
	protected boolean _isLessThan(double value) {
		return this.doubleValue() < value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(int value) {
		return this.doubleValue() <= (double)value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(long value) {
		return this.doubleValue() <= (double)value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(float value) {
		return this.doubleValue() <= (double)value;
	}

	@Override
	protected boolean _isLessThanOrEqualTo(double value) {
		return this.doubleValue() <= value;
	}

	@Override
	protected boolean _isGreaterThan(int value) {
		return this.doubleValue() > (double)value;
	}

	@Override
	protected boolean _isGreaterThan(long value) {
		return this.doubleValue() > (double)value;
	}

	@Override
	protected boolean _isGreaterThan(float value) {
		return this.doubleValue() > (double)value;
	}

	@Override
	protected boolean _isGreaterThan(double value) {
		return this.doubleValue() > value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(int value) {
		return this.doubleValue() >= (double)value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(long value) {
		return this.doubleValue() >= (double)value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(float value) {
		return this.doubleValue() >= (double)value;
	}

	@Override
	protected boolean _isGreaterThanOrEqualTo(double value) {
		return this.doubleValue() >= value;
	}
	
	@Override
	public void waitUntilEqualToZero() throws InterruptedException {
		this.waitUntilEqualTo(0.0D);
	}

	@Override
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(0.0D, timeout, unit);
	}

	@Override
	public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(0.0D);
	}

	@Override
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(0.0D, timeout, unit);
	}

	@Override
	public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(0.0D);
	}

	@Override
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(0.0D, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(0.0D);
	}

	@Override
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(0.0D, timeout, unit);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		waitUntilLessThanOrEqualTo(0.0D);
	}

	@Override
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		waitUntilLessThanOrEqualTo(0.0D, timeout, unit);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		waitUntilGreaterThanOrEqualTo(0.0D);
	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		waitUntilGreaterThanOrEqualTo(0.0D, timeout, unit);
	}

}
