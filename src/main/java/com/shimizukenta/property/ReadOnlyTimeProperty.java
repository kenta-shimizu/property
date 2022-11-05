package com.shimizukenta.property;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface ReadOnlyTimeProperty extends ReadOnlyProperty<TimeoutAndUnit> {
	
	/**
	 * Returns {@link #get()}.timeout().
	 * 
	 * @return get().timeout()
	 */
	public long getTimeout();
	
	/**
	 * Returns {@link #get()}.unit().
	 * 
	 * @return get().unit(.
	 */
	public TimeUnit getTimeUnit();
	
	/**
	 * Thread sleep.
	 * 
	 * @throws InterruptedException
	 */
	public void sleep() throws InterruptedException;
	
	/**
	 * Thread join.
	 * 
	 * @param thread
	 * @throws InterruptedException
	 */
	public void join(Thread thread) throws InterruptedException;
	
	/**
	 * Synchronized wait.
	 * 
	 * @param sync
	 * @throws InterruptedException
	 */
	public void wait(Object sync) throws InterruptedException;
	
	/**
	 * BlockingQueue poll.
	 * 
	 * @param <T>
	 * @param queue
	 * @return poll-value
	 * @throws InterruptedException
	 */
	public <T> T poll(BlockingQueue<T> queue) throws InterruptedException;
	
	/**
	 * Future get.
	 * 
	 * @param <T>
	 * @param future
	 * @return future-result
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 */
	public <T> T future(Future<T> future) throws InterruptedException, TimeoutException, ExecutionException;
	
	/**
	 * ExecutorService invokeAll.
	 * 
	 * @param <T>
	 * @param executorService
	 * @param tasks
	 * @return Future result list
	 * @throws InterruptedException
	 */
	public <T> List<Future<T>> invokeAll(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tasks)
					throws InterruptedException;
	
	/**
	 * ExecutorService invokeAny.
	 * 
	 * @param <T>
	 * @param executorService
	 * @param tatks
	 * @return Callable result
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 */
	public <T> T invokeAny(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tatks)
					throws InterruptedException, TimeoutException, ExecutionException;
	
}
