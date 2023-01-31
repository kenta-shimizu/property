/**
 * 
 */
package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Number value Observer.
 * 
 * @author kenta-shimizu
 * @see Number
 * @see Observable
 *
 */
public interface NumberObservable<T extends Number> extends Observable<T> {
	
	/**
	 * Returns {@code true} if Number is instance of Integer, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Integer, otherwise {@code false}.
	 */
	default public boolean isInteger() {
		return false;
	}
	
	/**
	 * Returns {@code true} if Number is instance of Long, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Long, otherwise {@code false}.
	 */
	default public boolean isLong() {
		return false;
	}
	
	/**
	 * Returns {@code true} if Number is instance of Float, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Float, otherwise {@code false}.
	 */
	default public boolean isFloat() {
		return false;
	}
	
	/**
	 * Returns {@code true} if Number is instance of Double, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Double, otherwise {@code false}.
	 */
	default public boolean isDouble() {
		return false;
	}
	
	
	/* Casts */
	
	/**
	 * Returns IntegerCompution coverted instance.
	 * 
	 * @return IntegerComution converted instance.
	 */
	default public IntegerCompution toInteger() {
		return NumberUtils.toInteger(this);
	}
	
	/**
	 * Returns LongComputionn converted instance.
	 * 
	 * @return LongCompution converted instance.
	 */
	default public LongCompution toLong() {
		return NumberUtils.toLong(this);
	}
	
	/**
	 * Returns FloatCompution converted instance.
	 * 
	 * @return FloatCompution converted instance.
	 */
	default public FloatCompution toFloat() {
		return NumberUtils.toFloat(this);
	}
	
	/**
	 * Returns DoubleCompution converted instance.
	 * 
	 * @return DoubleCompution comerted instance.
	 */
	default public DoubleCompution toDouble() {
		return NumberUtils.toDouble(this);
	}
	
	/* Number Compution Bases */
	
	/**
	 * Returns NumberCompution of this.value + observable.value.
	 * 
	 * @param observable
	 * @return NumberCompution of this.value + observable.value.
	 */
	default public NumberCompution add(NumberObservable<? extends Number> observer) {
		return NumberCompution.sum(this, observer);
	}
	
	/**
	 * NumberCompution of this.value * observable.value.
	 * 
	 * @param observable
	 * @return NumberCompution of this.value * observable.value.
	 */
	default public NumberCompution multiply(NumberObservable<? extends Number> observer) {
		return NumberCompution.multiply(this, observer);
	}
	
	/**
	 * Returns NumberCompution of this.value - observable.value.
	 * 
	 * @param observable
	 * @return NumberCompution of this.value - observable.value.
	 */
	default public NumberCompution subtract(NumberObservable<? extends Number> observer) {
		return NumberCompution.subtract(this, observer);
	}
	
	/**
	 * Returns NumberCompution of -(this.value).
	 * 
	 * @return NumberCompution of -(this.value).
	 */
	default public NumberCompution negate() {
		return NumberCompution.negate(this);
	}
	
	
	/* Number Compution Premitives */
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(int value) {
		return this.add(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(long value) {
		return this.add(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(float value) {
		return this.add(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(double value) {
		return this.add(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(int value) {
		return this.multiply(NumberUtils.unmodifiableInteger(value));
	}

	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(long value) {
		return this.multiply(NumberUtils.unmodifiableLong(value));
	}

	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(float value) {
		return this.multiply(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(double value) {
		return this.multiply(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(int value) {
		return this.subtract(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(long value) {
		return this.subtract(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(float value) {
		return this.subtract(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(double value) {
		return this.subtract(NumberUtils.unmodifiableDouble(value));
	}
	
	
	/* Comparative Compution Bases */
	
	/**
	 * Returns ComparativeCompution of this.value == observable.value.
	 * 
	 * @param observable
	 * @return
	 */
	default ComparativeCompution isEqualTo(NumberObservable<? extends Number> observer) {
		return ComparativeCompution.isEqualTo(this, observer);
	}
	
	/**
	 * Returns ComparativeCompution of this.value != observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value != observable.value.
	 */
	default ComparativeCompution isNotEqualTo(NumberObservable<? extends Number> observer) {
		return ComparativeCompution.isNotEqualTo(this, observer);
	}
	
	/**
	 * Returns ComparativeCompution of this.value < observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value < observable.value.
	 */
	default ComparativeCompution isLessThan(NumberObservable<? extends Number> observer) {
		return ComparativeCompution.isLessThan(this, observer);
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= observable.value.
	 * @param observable
	 * @return ComparativeCompution of this.value <= observable.value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(NumberObservable<? extends Number> observer) {
		return ComparativeCompution.isLessThanOrEqualTo(this, observer);
	}
	
	/**
	 * Returns ComparativeCompution of this.value > observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value > observable.value.
	 */
	default ComparativeCompution isGreaterThan(NumberObservable<? extends Number> observer) {
		return ComparativeCompution.isGreaterThan(this, observer);
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value >= observable.value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(NumberObservable<? extends Number> observer) {
		return ComparativeCompution.isGreaterThanOrEqualTo(this, observer);
	}
	
	/* Comparative Compution Primitives */
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(int value) {
		return this.isEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(long value) {
		return this.isEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(float value) {
		return this.isEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(double value) {
		return this.isEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(int value) {
		return this.isNotEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(long value) {
		return this.isNotEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(float value) {
		return this.isNotEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(double value) {
		return this.isNotEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isLessThan(int value) {
		return this.isLessThan(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value < value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < value.
	 */
	default ComparativeCompution isLessThan(long value) {
		return this.isLessThan(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value < value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < value.
	 */
	default ComparativeCompution isLessThan(float value) {
		return this.isLessThan(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value < value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < value.
	 */
	default ComparativeCompution isLessThan(double value) {
		return this.isLessThan(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(int value) {
		return this.isLessThanOrEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(long value) {
		return this.isLessThanOrEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(float value) {
		return this.isLessThanOrEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(double value) {
		return this.isLessThanOrEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(int value) {
		return this.isGreaterThan(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(long value) {
		return this.isGreaterThan(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(float value) {
		return this.isGreaterThan(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(double value) {
		return this.isGreaterThan(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(int value) {
		return this.isGreaterThanOrEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(long value) {
		return this.isGreaterThanOrEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(float value) {
		return this.isGreaterThanOrEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(double value) {
		return this.isGreaterThanOrEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == 0.
	 */
	default ComparativeCompution isEqualToZero() {
		return this.isEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Returns ComparativeCompution of this.value != 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != 0.
	 */
	default ComparativeCompution isNotEqualToZero() {
		return this.isNotEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Returns ComparativeCompution of this.value < 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < 0.
	 */
	default ComparativeCompution isLessThanZero() {
		return this.isLessThan(NumberUtils.getUnmodifiableZero());
	}

	/**
	 * Returns ComparativeCompution of this.value <= 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= 0.
	 */
	default ComparativeCompution isLessThanOrEqualToZero() {
		return this.isLessThanOrEqualTo(NumberUtils.getUnmodifiableZero());
	}

	/**
	 * Returns ComparativeCompution of this.value > 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > 0.
	 */
	default ComparativeCompution isGreaterThanZero() {
		return this.isGreaterThan(NumberUtils.getUnmodifiableZero());
	}

	/**
	 * Returns ComparativeCompution of this.value >= 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= 0.
	 */
	default ComparativeCompution isGreaterThanOrEqualToZero() {
		return this.isGreaterThanOrEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/* Wait Until Bases */
	
	/**
	 * Wait until this value == observable value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @throws InterruptedException
	 */
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observer) throws InterruptedException {
		NumberUtils.waitUntil(NumberUtils.isEqualTo(this, observer), this, observer);
	}
	
	/**
	 * Wait until this.value == observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observer, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isEqualTo(this, observer), this, observer, timeout, unit);
	}
	
	/**
	 * Wait until this.value == observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observer, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isEqualTo(this, observer), this, observer, p);
	}
	
	/**
	 * Wait until this.value != observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observer) throws InterruptedException {
		NumberUtils.waitUntil(NumberUtils.isNotEqualTo(this, observer), this, observer);
	}
	
	/**
	 * Wait until this.value != observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observer, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isNotEqualTo(this, observer), this, observer, timeout, unit);
	}
	
	/**
	 * Wait until this.value != observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observer, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isNotEqualTo(this, observer), this, observer, p);
	}
	
	/**
	 * Wait until this.value < observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThan(NumberObservable<? extends Number> observer) throws InterruptedException {
		NumberUtils.waitUntil(NumberUtils.isLessThan(this, observer), this, observer);
	}
	
	/**
	 * Wait until this.value < observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(NumberObservable<? extends Number> observer, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isLessThan(this, observer), this, observer, timeout, unit);
	}
	
	/**
	 * Wait until this.value < observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(NumberObservable<? extends Number> observer, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isLessThan(this, observer), this, observer, p);
	}
	
	/**
	 * Wait until this.value <= observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observer) throws InterruptedException {
		NumberUtils.waitUntil(NumberUtils.isLessThanOrEqualTo(this, observer), this, observer);
	}
	
	/**
	 * Wait until this.value <= observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observer, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isLessThanOrEqualTo(this, observer), this, observer, timeout, unit);
	}
	
	/**
	 * Wait until this.value <= observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observer, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isLessThanOrEqualTo(this, observer), this, observer, p);
	}
	
	/**
	 * Wait until this.value > observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observer) throws InterruptedException {
		NumberUtils.waitUntil(NumberUtils.isGreaterThan(this, observer), this, observer);
	}
	
	/**
	 * Wait until this.value > observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observer, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isGreaterThan(this, observer), this, observer, timeout, unit);
	}
	
	/**
	 * Wait until this.value > observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observer, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isGreaterThan(this, observer), this, observer, p);
	}
	
	/**
	 * Wait until this.value >= observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observer) throws InterruptedException {
		NumberUtils.waitUntil(NumberUtils.isGreaterThanOrEqualTo(this, observer), this, observer);
	}
	
	/**
	 * Wait until this.value >= observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observer, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isGreaterThanOrEqualTo(this, observer), this, observer, timeout, unit);
	}
	
	/**
	 * Wait until this.value >= observable.value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param observable
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observer, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberUtils.waitUntil(NumberUtils.isGreaterThanOrEqualTo(this, observer), this, observer, p);
	}
	
	/* Wait until Primitives */
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilEqualTo(int value) throws InterruptedException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilEqualTo(long value) throws InterruptedException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilEqualTo(float value) throws InterruptedException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilEqualTo(double value) throws InterruptedException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableInteger(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableLong(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableFloat(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableDouble(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableInteger(value), p);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableLong(value), p);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableFloat(value), p);
	}
	
	/**
	 * Wait until this.value == value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.unmodifiableDouble(value), p);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEqualTo(int value) throws InterruptedException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEqualTo(long value) throws InterruptedException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEqualTo(float value) throws InterruptedException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEqualTo(double value) throws InterruptedException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableInteger(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableLong(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableFloat(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableDouble(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableInteger(value), p);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableLong(value), p);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableFloat(value), p);
	}
	
	/**
	 * Wait until this.value != value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.unmodifiableDouble(value), p);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThan(int value) throws InterruptedException {
		this.waitUntilLessThan(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThan(long value) throws InterruptedException {
		this.waitUntilLessThan(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThan(float value) throws InterruptedException {
		this.waitUntilLessThan(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThan(double value) throws InterruptedException {
		this.waitUntilLessThan(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableInteger(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableLong(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableFloat(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableDouble(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableInteger(value), p);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableLong(value), p);
	}
	
	/**
v	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableFloat(value), p);
	}
	
	/**
	 * Wait until this.value < value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.unmodifiableDouble(value), p);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableInteger(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableLong(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableFloat(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableDouble(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableInteger(value), p);
	}
	
	/**
v	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableLong(value), p);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableFloat(value), p);
	}
	
	/**
	 * Wait until this.value <= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.unmodifiableDouble(value), p);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThan(int value) throws InterruptedException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThan(long value) throws InterruptedException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThan(float value) throws InterruptedException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThan(double value) throws InterruptedException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableInteger(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableLong(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableFloat(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableDouble(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableInteger(value), p);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableLong(value), p);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableFloat(value), p);
	}
	
	/**
	 * Wait until this.value > value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.unmodifiableDouble(value), p);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableInteger(value));
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableLong(value));
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableFloat(value));
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableDouble(value));
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableInteger(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableLong(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableFloat(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableDouble(value), timeout, unit);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableInteger(value), p);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableLong(value), p);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableFloat(value), p);
	}
	
	/**
	 * Wait until this.value >= value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param value
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.unmodifiableDouble(value), p);
	}
	
	/* Wait Until ZEROs */
	
	/**
	 * Wait until this.value == 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilEqualToZero() throws InterruptedException {
		this.waitUntilEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Wait until this.value == 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.getUnmodifiableZero(), timeout, unit);
	}
	
	/**
	 * Wait until this.value == 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(NumberUtils.getUnmodifiableZero(), p);
	}
	
	/**
	 * Wait until this.value != 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Wait until this.value != 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.getUnmodifiableZero(), timeout, unit);
	}
	
	/**
	 * Wait until this.value != 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilNotEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(NumberUtils.getUnmodifiableZero(), p);
	}
	
	/**
	 * Wait until this.value < 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Wait until this.value < 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.getUnmodifiableZero(), timeout, unit);
	}
	
	/**
	 * Wait until this.value < 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(NumberUtils.getUnmodifiableZero(), p);
	}
	
	/**
	 * Wait until this.value <= 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Wait until this.value <= 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.getUnmodifiableZero(), timeout, unit);
	}
	
	/**
	 * Wait until this.value <= 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilLessThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(NumberUtils.getUnmodifiableZero(), p);
	}
	
	/**
	 * Wait until this.value > 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Wait until this.value > 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.getUnmodifiableZero(), timeout, unit);
	}
	
	/**
	 * Wait until this.value > 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p is TimeProperty
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(NumberUtils.getUnmodifiableZero(), p);
	}
	
	/**
	 * Wait until this.value >= 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	default public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.getUnmodifiableZero());
	}
	
	/**
	 * Wait until this.value >= 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param timeout
	 * @param unit
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.getUnmodifiableZero(), timeout, unit);
	}
	
	/**
	 * Wait until this.value >= 0.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already condition is {@code true}, pass through immediately.<br />
	 * </p>
	 * 
	 * @param p
	 * @throws InterruptedException
	 * @throws TimeoutException if timeout.
	 */
	default public void waitUntilGreaterThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(NumberUtils.getUnmodifiableZero(), p);
	}
	
}
