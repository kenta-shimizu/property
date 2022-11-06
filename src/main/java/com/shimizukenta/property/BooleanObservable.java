package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author kenta-shimizu
 *
 */
public interface BooleanObservable extends Observable<Boolean, BooleanSettable> {
	
	public void waitUntil(boolean f) throws InterruptedException;
	
	public void waitUntil(boolean f, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntil(boolean f, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntil(f, a.timeout(), a.unit());
	}
	
	default public void waitUntilTrue() throws InterruptedException {
		this.waitUntil(true);
	}
	
	default public void waitUntilTrue(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntil(true, timeout, unit);
	}
	
	default public void waitUntilTrue(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntil(true, p);
	}
	
	default public void waitUntilFalse() throws InterruptedException {
		this.waitUntil(false);
	}
	
	default public void waitUntilFalse(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntil(false, timeout, unit);
	}
	
	default public void waitUntilFalse(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntil(false, p);
	}
	
}
