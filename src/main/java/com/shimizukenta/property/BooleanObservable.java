package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Boolean value Observer.
 * 
 * @author kenta-shimizu
 * @see Boolean
 * @see Observable
 * @see LogicalCompution
 *
 */
public interface BooleanObservable extends Observable<Boolean> {
	
	/**
	 * Returns (this && observer) LogicalCompution instance.
	 * 
	 * @param observer
	 * @return (this && observer) LogicalCompution instance
	 * @see #and(boolean)
	 * @see LogicalCompution#and(BooleanObservable...)
	 */
	default public LogicalCompution and(BooleanObservable observer) {
		return LogicalCompution.and(this, observer);
	}
	
	/**
	 * Returns (this || observer) LogicalCompution instance.
	 * 
	 * @param observer
	 * @return (this || observer) LogicalCompution instance
	 * @see LogicalCompution#or(BooleanObservable...)
	 */
	default public LogicalCompution or(BooleanObservable observer) {
		return LogicalCompution.or(this, observer);
	}
	
	/**
	 * Returns (! this) LogicalCompution instance.
	 * 
	 * @return (! this) LogicalCompution instance
	 * @see LogicalCompution#not(BooleanObservable)
	 */
	default public LogicalCompution not() {
		return LogicalCompution.not(this);
	}
	
	/**
	 * Returns (this ^ observer) LogicalCompution instance.
	 * 
	 * @param observer
	 * @return (this ^ observer) LogicalCompution instance
	 * @see #xor(boolean)
	 * @see LogicalCompution#xor(BooleanObservable, BooleanObservable)
	 */
	default public LogicalCompution xor(BooleanObservable observer) {
		return LogicalCompution.xor(this, observer);
	}
	
	/**
	 * Returns (! (this && observer)) LogicalCompution instance.
	 * 
	 * @param observer
	 * @return (! (this && observer)) LogicalCompution instance
	 * @see LogicalCompution#nand(BooleanObservable...)
	 * 
	 */
	default public LogicalCompution nand(BooleanObservable observer) {
		return LogicalCompution.nand(this, observer);
	}
	
	/**
	 * Returns (! (this || observer))aaa LogicalCompution instance.
	 * 
	 * @param observer
	 * @return (! (this || observer)) LogicalCompution instance.
	 * @see #nor(boolean)
	 * @see LogicalCompution#nor(BooleanObservable...)
	 */
	default public LogicalCompution nor(BooleanObservable observer) {
		return LogicalCompution.nor(this, observer);
	}
	
	/**
	 * Returns (this && f) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (this && f) LogicalCompution instance
	 * @see #and(BooleanObservable)
	 * @see #and(BooleanObservable)
	 * @see LogicalCompution#and(BooleanObservable...)
	 */
	default public LogicalCompution and(boolean f) {
		return this.and(BooleanUtils.getUnmodifiableBoolean(f));
	}
	
	/**
	 * Returns (this || f) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (this || f) LogicalCompution instance
	 * @see #or(BooleanObservable)
	 * @see LogicalCompution#or(BooleanObservable...)
	 */
	default public LogicalCompution or(boolean f) {
		return this.or(BooleanUtils.getUnmodifiableBoolean(f));
	}
	
	/**
	 * Returns (this ^ f) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (this ^ f) LogicalCompution instance
	 * @see #xor(BooleanObservable)
	 * @see LogicalCompution#xor(BooleanObservable...)
	 */
	default public LogicalCompution xor(boolean f) {
		return this.xor(BooleanUtils.getUnmodifiableBoolean(f));
	}
	
	/**
	 * Returns (! (this && f)) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (! (this && f)) LogicalCompution instance
	 * @see #nand(BooleanObservable)
	 * @see LogicalCompution#nand(BooleanObservable...)
	 */
	default public LogicalCompution nand(boolean f) {
		return this.nand(BooleanUtils.getUnmodifiableBoolean(f));
	}
	
	/**
	 * Returns (! (this || f)) LogicalCompution instance.
	 * 
	 * @param f is boolean
	 * @return (! (this || f)) LogicalCompution instance.
	 * @see #nor(BooleanObservable)
	 * @see LogicalCompution#nor(BooleanObservable...)
	 */
	default public LogicalCompution nor(boolean f) {
		return this.nor(BooleanUtils.getUnmodifiableBoolean(f));
	}
	
	/**
	 * Waiting until {@code (condtion == this.get().booleanValue())}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param condition is {@code boolean}.
	 * @throws InterruptedException
	 */
	public void waitUntil(boolean condition) throws InterruptedException;
	
	/**
	 * Waiting until {@code (condition == this.get().booleanValue())}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * 
	 * @param condition is {@code boolean}.
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	public void waitUntil(boolean condition, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	/**
	 * Waiting until {@code (condition == this.get().booleanValue())}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param condition is {@code boolean}.
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntil(boolean condition, TimeGettable p) throws InterruptedException, TimeoutException {
		final TimeoutAndUnit a = p.get();
		this.waitUntil(condition, a.timeout(), a.unit());
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == true)}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilTrue() throws InterruptedException {
		this.waitUntil(true);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == true)}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
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
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
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
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilFalse() throws InterruptedException {
		this.waitUntil(false);
	}
	
	/**
	 * Waiting until {@code (this.get().booleanValue() == false)}.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
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
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException throw if timeout.
	 */
	default public void waitUntilFalse(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntil(false, p);
	}
	
}
