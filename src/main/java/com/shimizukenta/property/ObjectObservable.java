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
	
	/**
	 * Wait until value is <b>NOT</b> {@code null}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is <b>NOT</b> {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @return value
	 * @throws InterruptedException
	 */
	public T waitUntilNotNull() throws InterruptedException;
	
	/**
	 * Wait until value is <b>NOT</b> {@code null}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is <b>NOT</b> {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @return value
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public T waitUntilNotNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until value is <b>NOT</b> {@code null}, and return value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is <b>NOT</b> {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @return value
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public T waitUntilNotNull(TimeGettable p) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until value is {@code null}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void waitUntilNull() throws InterruptedException;
	
	/**
	 * Wait until value is {@code null}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilNull(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Wait until value is {@code null}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is {@code null}, return value immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	public void waitUntilNull(TimeGettable p) throws InterruptedException, TimeoutException;
	
}
