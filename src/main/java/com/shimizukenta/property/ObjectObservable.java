package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T>
 */
public interface ObjectObservable<T> extends Observable<T> {
	
	public T waitUntilNotNull() throws InterruptedException;
	
	public T waitUntilNotNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public T waitUntilNotNull(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		return this.waitUntilNotNull(a.timeout(), a.unit());
	}
	
	public void waitUntilNull() throws InterruptedException;
	
	public void waitUntilNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	default public void waitUntilNull(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNull(a.timeout(), a.unit());
	}

}
