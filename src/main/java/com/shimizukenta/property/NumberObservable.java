/**
 * 
 */
package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author kenta-shimizu
 *
 */
public interface NumberObservable<T extends Number> extends Observable<T, NumberSettable<T>> {
	
	public void waitUntilEqualTo(int value) throws InterruptedException;
	public void waitUntilEqualTo(long value) throws InterruptedException;
	public void waitUntilEqualTo(float value) throws InterruptedException;
	public void waitUntilEqualTo(double value) throws InterruptedException;
	public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	public void waitUntilNotEqualTo(int value) throws InterruptedException;
	public void waitUntilNotEqualTo(long value) throws InterruptedException;
	public void waitUntilNotEqualTo(float value) throws InterruptedException;
	public void waitUntilNotEqualTo(double value) throws InterruptedException;
	public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilNotEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	public void waitUntilLessThan(int value) throws InterruptedException;
	public void waitUntilLessThan(long value) throws InterruptedException;
	public void waitUntilLessThan(float value) throws InterruptedException;
	public void waitUntilLessThan(double value) throws InterruptedException;
	public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilLessThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilLessThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	public void waitUntilGreaterThan(int value) throws InterruptedException;
	public void waitUntilGreaterThan(long value) throws InterruptedException;
	public void waitUntilGreaterThan(float value) throws InterruptedException;
	public void waitUntilGreaterThan(double value) throws InterruptedException;
	public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilGreaterThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilGreaterThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	public void waitUntilEqualToZero() throws InterruptedException;
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualToZero(a.timeout(), a.unit());
	}
	
	public void waitUntilNotEqualToZero() throws InterruptedException;
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilNotEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualToZero(a.timeout(), a.unit());
	}
	
	public void waitUntilLessThanZero() throws InterruptedException;
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilLessThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanZero(a.timeout(), a.unit());
	}
	
	public void waitUntilGreaterThanZero() throws InterruptedException;
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilGreaterThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanZero(a.timeout(), a.unit());
	}
	
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException;
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilLessThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualToZero(a.timeout(), a.unit());
	}
	
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException;
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilGreaterThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualToZero(a.timeout(), a.unit());
	}

}
