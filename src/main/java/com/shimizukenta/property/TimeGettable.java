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

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface TimeGettable extends Gettable<TimeoutAndUnit> {
	
	/**
	 * Value getter.
	 * 
	 * @return value.
	 */
	public TimeoutAndUnit get();
	
	/**
	 * Returns {@link #get()}.timeout().
	 * 
	 * @return get().timeout()
	 */
	default public long getTimeout() {
		return this.get().timeout();
	}
	
	/**
	 * Returns {@link #get()}.unit().
	 * 
	 * @return get().unit().
	 */
	default public TimeUnit getTimeUnit() {
		return this.get().unit();
	}
	
	/**
	 * Thread sleep.
	 * 
	 * @throws InterruptedException
	 */
	default public void sleep() throws InterruptedException {
		TimeoutAndUnit a = this.get();
		a.unit().sleep(a.timeout());
	}
	
	/**
	 * Thread join.
	 * 
	 * @param thread
	 * @throws InterruptedException
	 */
	default public void join(Thread thread) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		a.unit().timedJoin(thread, a.timeout());
	}
	
	/**
	 * Synchronized wait.
	 * 
	 * @param sync
	 * @throws InterruptedException
	 */
	default public void wait(Object sync) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		a.unit().timedWait(sync, a.timeout());
	}
	
	/**
	 * BlockingQueue poll.
	 * 
	 * @param <T>
	 * @param queue
	 * @return poll-value
	 * @throws InterruptedException
	 */
	default public <T> T poll(BlockingQueue<T> queue) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return queue.poll(a.timeout(),  a.unit());
	}
	
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
	default public <T> T future(Future<T> future) throws InterruptedException, TimeoutException, ExecutionException {
		TimeoutAndUnit a = this.get();
		return future.get(a.timeout(), a.unit());
	}
	
	/**
	 * ExecutorService invokeAll.
	 * 
	 * @param <T>
	 * @param executorService
	 * @param tasks
	 * @return Future result list
	 * @throws InterruptedException
	 */
	default public <T> List<Future<T>> invokeAll(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tasks)
					throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return executorService.invokeAll(tasks, a.timeout(), a.unit());
	}
	
	/**
	 * ExecutorService invokeAny.
	 * 
	 * @param <T>
	 * @param executorService
	 * @param tasks
	 * @return Callable result
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 */
	default public <T> T invokeAny(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tasks)
					throws InterruptedException, TimeoutException, ExecutionException {
		TimeoutAndUnit a = this.get();
		return executorService.invokeAny(tasks, a.timeout(), a.unit());
	}
	
}
