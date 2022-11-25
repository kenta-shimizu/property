package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface ObjectObservable<T> extends Observable<T> {
	
	public T waitUntilNotNull() throws InterruptedException;
	
	public T waitUntilNotNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public T waitUntilNotNull(TimeGettable p) throws InterruptedException, TimeoutException;
	
	public void waitUntilNull() throws InterruptedException;
	
	public void waitUntilNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public void waitUntilNull(TimeGettable p) throws InterruptedException, TimeoutException;
	
}
