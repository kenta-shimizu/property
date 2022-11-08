package com.shimizukenta.property;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractNumberCompution extends AbstractCompution<Number, NumberSettable<Number>> implements NumberCompution {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433088920743345120L;

	public AbstractNumberCompution(Number initial) {
		super(initial);
	}
	
	@Override
	protected void _set(Number value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(this._get(), value) ) {
				super._set(value);
				this._notifyChanged(value);
				this._sync.notifyAll();
			}
		}
	}
	
	@Override
	public void waitUntilEqualTo(int value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(long value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(float value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(double value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(long value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(float value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualTo(double value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(int value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(long value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(float value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(double value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(int value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(long value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(float value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(double value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(int value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(long value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(float value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThan(double value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(int value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(long value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(float value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(double value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualToZero() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualToZero() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanZero() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanZero() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit)
			throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return this.get().toString();
	}

}
