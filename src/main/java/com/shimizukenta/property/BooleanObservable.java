package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface BooleanObservable extends Observable<Boolean, BooleanSettable> {
	
	/**
	 * Waiting until {@code (f == this.get().booleanValue())}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * @param f is {@code boolean}.
	 * @throws InterruptedException
	 */
	public void waitUntil(boolean f) throws InterruptedException;
	
	/**
	 * Waiting until {@code (f == this.get().booleanValue())}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * 
	 * @param f is {@code boolean}.
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	public void waitUntil(boolean f, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Returns (this && observable) LogicalCompution instance.
	 * 
	 * @param observable
	 * @return (this && observable) LogicalCompution instance.
	 */
	default public LogicalCompution and(BooleanObservable observable) {
		return LogicalCompution.and(this, observable);
	}
	
	/**
	 * Returns (this || observable) LogicalCompution instance.
	 * 
	 * @param observable
	 * @return (this || observable) LogicalCompution instance.
	 */
	default public LogicalCompution or(BooleanObservable observable) {
		return LogicalCompution.or(this, observable);
	}
	
	/**
	 * Returns (! this) LogicalCompution instance.
	 * 
	 * @return (! this) LogicalCompution instance.
	 */
	default public LogicalCompution not() {
		return LogicalCompution.not(this);
	}
	
	/**
	 * Returns (this ^ observable) LogicalCompution instance.
	 * 
	 * @param observable
	 * @return (this ^ observable) LogicalCompution instance.
	 */
	default public LogicalCompution xor(BooleanObservable observable) {
		return LogicalCompution.xor(this, observable);
	}
	
	/**
	 * Returns (! (this && observable)) LogicalCompution instance.
	 * 
	 * @param observable
	 * @return (! (this && observable)) LogicalCompution instance.
	 */
	default public LogicalCompution nand(BooleanObservable observable) {
		return LogicalCompution.nand(this, observable);
	}
	
	/**
	 * Returns (! (this || observable))aaa LogicalCompution instance.
	 * 
	 * @param observable
	 * @return (! (this || observable)) LogicalCompution instance.
	 */
	default public LogicalCompution nor(BooleanObservable observable) {
		return LogicalCompution.nor(this, observable);
	}
	
	/**
	 * Returns (this && f) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (this && f) LogicalCompution instance.
	 */
	default public LogicalCompution and(boolean f) {
		return this.and(UnmodifiablePropertyBuilder.getInstance().getBoolean(f));
	}
	
	/**
	 * Returns (this || f) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (this || f) LogicalCompution instance.
	 */
	default public LogicalCompution or(boolean f) {
		return this.or(UnmodifiablePropertyBuilder.getInstance().getBoolean(f));
	}
	
	/**
	 * Returns (this ^ f) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (this ^ f) LogicalCompution instance.
	 */
	default public LogicalCompution xor(boolean f) {
		return this.xor(UnmodifiablePropertyBuilder.getInstance().getBoolean(f));
	}
	
	/**
	 * Returns (! (this && f)) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (! (this && f)) LogicalCompution instance.
	 */
	default public LogicalCompution nand(boolean f) {
		return this.nand(UnmodifiablePropertyBuilder.getInstance().getBoolean(f));
	}
	
	/**
	 * Returns (! (this || f)) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (! (this || f)) LogicalCompution instance.
	 */
	default public LogicalCompution nor(boolean f) {
		return this.nor(UnmodifiablePropertyBuilder.getInstance().getBoolean(f));
	}
	
	/**
	 * Waiting until {@code (f == this.get().booleanValue())}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * @param f is {@code boolean}.
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntil(boolean f, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntil(f, a.timeout(), a.unit());
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == true)}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilTrue() throws InterruptedException {
		this.waitUntil(true);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == true)}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntilTrue(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntil(true, timeout, unit);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == true)}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntilTrue(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntil(true, p);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == false)}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilFalse() throws InterruptedException {
		this.waitUntil(false);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == false)}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntilFalse(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntil(false, timeout, unit);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == false)}.
	 * 
	 * <p>This is blocking method.</p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntilFalse(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntil(false, p);
	}
	
}
