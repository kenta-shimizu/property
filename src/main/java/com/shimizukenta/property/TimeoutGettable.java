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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * TimeoutAndUnit value Getter.
 * 
 * @author kenta-shimizu
 * @see TimeUnit
 * @see TimeoutAndUnit
 * @see Gettable
 * 
 */
public interface TimeoutGettable extends Gettable<TimeoutAndUnit> {
	
	/**
	 * Value Getter.
	 * 
	 * @return value.
	 */
	public TimeoutAndUnit get();
	
	/**
	 * Returns timeout(long) value.
	 * 
	 * @return timeout(long) value.
	 * @see TimeoutAndUnit#timeout()
	 */
	default public long getTimeout() {
		return this.get().timeout();
	}
	
	/**
	 * Returns TimeUnit.
	 * 
	 * @return TImeUnit.
	 * @see TimeoutAndUnit#unit()
	 */
	default public TimeUnit getTimeUnit() {
		return this.get().unit();
	}
	
	/**
	 * This calls TimeUnit#sleep(long).
	 * 
	 * @throws InterruptedException
	 * @see {@link TimeUnit#sleep(long)}
	 */
	default public void sleep() throws InterruptedException {
		TimeoutAndUnit a = this.get();
		a.unit().sleep(a.timeout());
	}
	
	/**
	 * This calls TimeUnit#timedJoin(Thread, long).
	 * 
	 * @param thread
	 * @throws InterruptedException
	 * @see {@link TimeUnit#timedJoin(Thread, long)}
	 */
	default public void join(Thread thread) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		a.unit().timedJoin(thread, a.timeout());
	}
	
	/**
	 * This calls TimeUnit#timedWait(Object, long).
	 * 
	 * @param sync
	 * @throws InterruptedException
	 * @see {@link TimeUnit#timedWait(Object, long)}
	 */
	default public void wait(Object sync) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		a.unit().timedWait(sync, a.timeout());
	}
	
	/**
	 * This calls BlockingQueue#poll(long, TimeUnit).
	 * 
	 * @param <T> Type
	 * @param queue
	 * @return poll-value
	 * @throws InterruptedException
	 * @see {@link BlockingQueue#poll(long, TimeUnit)}
	 */
	default public <T> T blockingQueuePoll(BlockingQueue<T> queue) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return queue.poll(a.timeout(),  a.unit());
	}
	
	/**
	 * This calls Lock#tryLock(long, TimeUnit).
	 * 
	 * @param lock
	 * @return true if the lock was acquired and false if the waiting time elapsed before the lock was acquired
	 * @throws InterruptedException
	 * @see {@link Lock#tryLock(long, TimeUnit)}
	 */
	default public boolean lockTryLock(Lock lock) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return lock.tryLock(a.timeout(), a.unit());
	}
	
	/**
	 * This calls Condition#await(long, TimeUnit).
	 * 
	 * @param condition
	 * @return false if the waiting time detectably elapsed before return from the method, else true
	 * @throws InterruptedException
	 * @see {@link Condition#await(long, TimeUnit)}
	 */
	default public boolean conditionAwait(Condition condition) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return condition.await(a.timeout(), a.unit());
	}
	
	/**
	 * This calls Future#get(long, TimeUnit).
	 * 
	 * @param <T> Type
	 * @param future
	 * @return future-result
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 * @see {@link Future#get(long, TimeUnit)}
	 */
	default public <T> T futureGet(Future<T> future) throws InterruptedException, TimeoutException, ExecutionException {
		TimeoutAndUnit a = this.get();
		return future.get(a.timeout(), a.unit());
	}
	
	/**
	 * This calls ExecutorService#invokeAll(Collection, long, TimeUnit).
	 * 
	 * @param <T> Type
	 * @param executorService
	 * @param tasks
	 * @return Future result list
	 * @throws InterruptedException
	 * @see {@link ExecutorService#invokeAll(Collection, long, TimeUnit)}
	 */
	default public <T> List<Future<T>> invokeAll(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tasks)
					throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return executorService.invokeAll(tasks, a.timeout(), a.unit());
	}
	
	/**
	 * This calls ExecutorService#invokeAny(Collection, long, TimeUnit).
	 * 
	 * @param <T> Type
	 * @param executorService
	 * @param tasks
	 * @return Callable result
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 * @see {@link ExecutorService#invokeAny(Collection, long, TimeUnit)}
	 */
	default public <T> T invokeAny(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tasks)
					throws InterruptedException, TimeoutException, ExecutionException {
		TimeoutAndUnit a = this.get();
		return executorService.invokeAny(tasks, a.timeout(), a.unit());
	}
	
	/**
	 * This calls ExecutorService#awaitTermination(long, TimeUnit).
	 * 
	 * @param executorService
	 * @return true if this executor terminated and false if the timeout elapsed before termination
	 * @throws InterruptedException if interrupted while waiting
	 * @see ExecutorService#awaitTermination(long, TimeUnit)
	 */
	default boolean awaitTermination(ExecutorService executorService) throws InterruptedException {
		TimeoutAndUnit a = this.get();
		return executorService.awaitTermination(a.timeout(), a.unit());
	}
	
}
