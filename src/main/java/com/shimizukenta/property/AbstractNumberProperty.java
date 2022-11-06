/**
 * 
 */
package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

/**
 * @author kenta-shimizu
 *
 */
public abstract class AbstractNumberProperty<T extends Number> extends AbstractProperty<T, NumberSettable<T>> implements NumberProperty<T> {
	
	private static final long serialVersionUID = -5768297706611678591L;
	
	protected AbstractNumberProperty(T initial) {
		super(initial);
	}
	
	@Override
	public void set(T value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(this._get(), value) ) {
				this._set(value);
				this._notifyChanged(value);
				this._sync.notifyAll();
			}
		}
	}
	
	
	abstract protected boolean _isEqualTo(int value);
	abstract protected boolean _isEqualTo(long value);
	abstract protected boolean _isEqualTo(float value);
	abstract protected boolean _isEqualTo(double value);
	
	protected boolean _isNotEqualTo(int value) {
		return ! this._isEqualTo(value);
	}
	
	protected boolean _isNotEqualTo(long value) {
		return ! this._isEqualTo(value);
	}
	
	protected boolean _isNotEqualTo(float value) {
		return ! this._isEqualTo(value);
	}
	
	protected boolean _isNotEqualTo(double value) {
		return ! this._isEqualTo(value);
	}
	
	abstract protected boolean _isLessThan(int value);
	abstract protected boolean _isLessThan(long value);
	abstract protected boolean _isLessThan(float value);
	abstract protected boolean _isLessThan(double value);
	abstract protected boolean _isLessThanOrEqualTo(int value);
	abstract protected boolean _isLessThanOrEqualTo(long value);
	abstract protected boolean _isLessThanOrEqualTo(float value);
	abstract protected boolean _isLessThanOrEqualTo(double value);
	abstract protected boolean _isGreaterThan(int value);
	abstract protected boolean _isGreaterThan(long value);
	abstract protected boolean _isGreaterThan(float value);
	abstract protected boolean _isGreaterThan(double value);
	abstract protected boolean _isGreaterThanOrEqualTo(int value);
	abstract protected boolean _isGreaterThanOrEqualTo(long value);
	abstract protected boolean _isGreaterThanOrEqualTo(float value);
	abstract protected boolean _isGreaterThanOrEqualTo(double value);
	
	private void __waitUntilInteger(Predicate<Integer> f, int value) throws InterruptedException {
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				this._sync.wait();
			}
		}
	}
	
	private void __waitUntilLong(Predicate<Long> f, long value) throws InterruptedException {
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				this._sync.wait();
			}
		}
	}
	
	private void __waitUntilFloat(Predicate<Float> f, float value) throws InterruptedException {
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				this._sync.wait();
			}
		}
	}
	
	private void __waitUntilDouble(Predicate<Double> f, double value) throws InterruptedException {
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				this._sync.wait();
			}
		}
	}
	
	private void __waitUntilInteger(Predicate<Integer> f, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				long rem = end - System.currentTimeMillis();
				if ( rem <= 0L ) {
					throw new TimeoutException();
				}
				this._sync.wait(rem);
			}
		}
	}
	
	private void __waitUntilLong(Predicate<Long> f, long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				long rem = end - System.currentTimeMillis();
				if ( rem <= 0L ) {
					throw new TimeoutException();
				}
				this._sync.wait(rem);
			}
		}
	}
	
	private void __waitUntilFloat(Predicate<Float> f, float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				long rem = end - System.currentTimeMillis();
				if ( rem <= 0L ) {
					throw new TimeoutException();
				}
				this._sync.wait(rem);
			}
		}
	}
	
	private void __waitUntilDouble(Predicate<Double> f, double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		synchronized ( this._sync ) {
			for ( ;; ) {
				if ( f.test(value) ) {
					return;
				}
				long rem = end - System.currentTimeMillis();
				if ( rem <= 0L ) {
					throw new TimeoutException();
				}
				this._sync.wait(rem);
			}
		}
	}


	
	@Override
	public void waitUntilEqualTo(int value) throws InterruptedException {
		this.__waitUntilInteger(this::_isEqualTo, value);
	}
	
	@Override
	public void waitUntilEqualTo(long value) throws InterruptedException {
		this.__waitUntilLong(this::_isEqualTo, value);
	}
	
	@Override
	public void waitUntilEqualTo(float value) throws InterruptedException {
		this.__waitUntilFloat(this::_isEqualTo, value);
	}
	
	@Override
	public void waitUntilEqualTo(double value) throws InterruptedException {
		this.__waitUntilDouble(this::_isEqualTo, value);
	}
	
	@Override
	public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilInteger(this::_isEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilLong(this::_isEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilFloat(this::_isEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilDouble(this::_isEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilNotEqualTo(int value) throws InterruptedException {
		this.__waitUntilInteger(this::_isNotEqualTo, value);
	}
	
	@Override
	public void waitUntilNotEqualTo(long value) throws InterruptedException {
		this.__waitUntilLong(this::_isNotEqualTo, value);
	}
	
	@Override
	public void waitUntilNotEqualTo(float value) throws InterruptedException {
		this.__waitUntilFloat(this::_isNotEqualTo, value);
	}
	
	@Override
	public void waitUntilNotEqualTo(double value) throws InterruptedException {
		this.__waitUntilDouble(this::_isNotEqualTo, value);
	}
	
	@Override
	public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilInteger(this::_isNotEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilLong(this::_isNotEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilFloat(this::_isNotEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilDouble(this::_isNotEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThan(int value) throws InterruptedException {
		this.__waitUntilInteger(this::_isLessThan, value);
	}
	
	@Override
	public void waitUntilLessThan(long value) throws InterruptedException {
		this.__waitUntilLong(this::_isLessThan, value);
	}
	
	@Override
	public void waitUntilLessThan(float value) throws InterruptedException {
		this.__waitUntilFloat(this::_isLessThan, value);
	}
	
	@Override
	public void waitUntilLessThan(double value) throws InterruptedException {
		this.__waitUntilDouble(this::_isLessThan, value);
	}
	
	@Override
	public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilInteger(this::_isLessThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilLong(this::_isLessThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilFloat(this::_isLessThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilDouble(this::_isLessThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException {
		this.__waitUntilInteger(this::_isLessThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException {
		this.__waitUntilLong(this::_isLessThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException {
		this.__waitUntilFloat(this::_isLessThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException {
		this.__waitUntilDouble(this::_isLessThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilInteger(this::_isLessThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilLong(this::_isLessThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilFloat(this::_isLessThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilDouble(this::_isLessThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThan(int value) throws InterruptedException {
		this.__waitUntilInteger(this::_isGreaterThan, value);
	}
	
	@Override
	public void waitUntilGreaterThan(long value) throws InterruptedException {
		this.__waitUntilLong(this::_isGreaterThan, value);
	}
	
	@Override
	public void waitUntilGreaterThan(float value) throws InterruptedException {
		this.__waitUntilFloat(this::_isGreaterThan, value);
	}
	
	@Override
	public void waitUntilGreaterThan(double value) throws InterruptedException {
		this.__waitUntilDouble(this::_isGreaterThan, value);
	}
	
	@Override
	public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilInteger(this::_isGreaterThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilLong(this::_isGreaterThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilFloat(this::_isGreaterThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilDouble(this::_isGreaterThan, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException {
		this.__waitUntilInteger(this::_isGreaterThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException {
		this.__waitUntilLong(this::_isGreaterThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException {
		this.__waitUntilFloat(this::_isGreaterThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException {
		this.__waitUntilDouble(this::_isGreaterThanOrEqualTo, value);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilInteger(this::_isGreaterThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilLong(this::_isGreaterThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilFloat(this::_isGreaterThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.__waitUntilDouble(this::_isGreaterThanOrEqualTo, value, timeout, unit);
	}
	
	@Override
	public String toString() {
		return get().toString();
	}
	
}
