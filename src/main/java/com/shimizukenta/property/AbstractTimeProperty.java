package com.shimizukenta.property;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
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
public abstract class AbstractTimeProperty extends AbstractProperty<TimeoutAndUnit, WritableTimeProperty> implements TimeProperty {
	
	private static final long serialVersionUID = -8510457745679120175L;
	
	protected AbstractTimeProperty(TimeoutAndUnit initial) {
		super(initial);
	}
	
	@Override
	public long getTimeout() {
		return get().timeout();
	}
	
	@Override
	public TimeUnit getTimeUnit() {
		return get().unit();
	}
	
	@Override
	public void set(TimeoutAndUnit value) {
		super.set(Objects.requireNonNull(value));
	}
	
	@Override
	public void set(int seconds) {
		this.set((long)seconds);
	}
	
	@Override
	public void set(long seconds) {
		this.set(seconds, TimeUnit.SECONDS);
	}
	
	@Override
	public void set(float seconds) {
		long ms = (long)(seconds * 1000.0F);
		this.set(ms, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public void set(double seconds) {
		long ms = (long)(seconds * 1000.0D);
		this.set(ms, TimeUnit.MILLISECONDS);
	}

	@Override
	public void set(long timeout, TimeUnit unit) {
		TimeoutAndUnit v = new TimeoutAndUnit(timeout, unit);
		super.set(v);
	}
	
	@Override
	public void sleep() throws InterruptedException {
		TimeoutAndUnit a = get();
		a.unit().sleep(a.timeout());
	}
	
	@Override
	public void join(Thread thread) throws InterruptedException {
		TimeoutAndUnit a = get();
		a.unit().timedJoin(thread, a.timeout());
	}
	
	@Override
	public void wait(Object sync) throws InterruptedException {
		TimeoutAndUnit a = get();
		a.unit().timedWait(sync, a.timeout());
	}
	
	@Override
	public <T> T poll(BlockingQueue<T> queue) throws InterruptedException {
		TimeoutAndUnit a = get();
		return queue.poll(a.timeout(), a.unit());
	}
	
	@Override
	public <T> T future(Future<T> future) throws InterruptedException, TimeoutException, ExecutionException {
		TimeoutAndUnit a = get();
		return future.get(a.timeout(), a.unit());
	}
	
	@Override
	public <T> List<Future<T>> invokeAll(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tasks)
					throws InterruptedException {
		
		TimeoutAndUnit a = get();
		return executorService.invokeAll(tasks, a.timeout(), a.unit());
	}
	
	@Override
	public <T> T invokeAny(
			ExecutorService executorService,
			Collection<? extends Callable<T>> tatks)
					throws InterruptedException,
					TimeoutException,
					ExecutionException {
		
		TimeoutAndUnit a = get();
		return executorService.invokeAny(tatks, a.timeout(), a.unit());
	}
	
	@Override
	public String toString() {
		TimeoutAndUnit a = this.get();
		return "{\"timeout\": " + a.timeout() + ", \"unit\": " + a.unit() + "}";
	}
}
