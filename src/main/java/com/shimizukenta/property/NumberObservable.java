/**
 * 
 */
package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberObservable<T extends Number> extends Observable<T> {
	
	/**
	 * Returns {@code true} if Number is instance of Integer, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Integer, otherwise {@code false}.
	 */
	public boolean isInteger();
	
	/**
	 * Returns {@code true} if Number is instance of Long, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Long, otherwise {@code false}.
	 */
	public boolean isLong();
	
	/**
	 * Returns {@code true} if Number is instance of Float, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Float, otherwise {@code false}.
	 */
	public boolean isFloat();
	
	/**
	 * Returns {@code true} if Number is instance of Double, otherwise {@code false}.
	 * 
	 * @return {@code true} if Number is instance of Double, otherwise {@code false}.
	 */
	public boolean isDouble();
	
	/* Casts */
	
	/**
	 * Returns IntegerCompution coverted instance.
	 * 
	 * @return IntegerComution converted instance.
	 */
	default public IntegerCompution toInteger() {
		return NumberComputionBuilder.getInstance().toInteger(this);
	}
	
	/**
	 * Returns LongComputionn converted instance.
	 * 
	 * @return LongCompution converted instance.
	 */
	default public LongCompution toLong() {
		return NumberComputionBuilder.getInstance().toLong(this);
	}
	
	/**
	 * Returns FloatCompution converted instance.
	 * 
	 * @return FloatCompution converted instance.
	 */
	default public FloatCompution toFloat() {
		return NumberComputionBuilder.getInstance().toFloat(this);
	}
	
	/**
	 * Returns DoubleCompution converted instance.
	 * 
	 * @return DoubleCompution comerted instance.
	 */
	default public DoubleCompution toDouble() {
		return NumberComputionBuilder.getInstance().toDouble(this);
	}
	
	/* Number Compution Bases */
	
	/**
	 * Returns NumberCompution of this.value + observable.value.
	 * 
	 * @param observable
	 * @return NumberCompution of this.value + observable.value.
	 */
	default public NumberCompution add(NumberObservable<? extends Number> observable) {
		return NumberCompution.add(this, observable);
	}
	
	/**
	 * NumberCompution of this.value * observable.value.
	 * 
	 * @param observable
	 * @return NumberCompution of this.value * observable.value.
	 */
	default public NumberCompution multiply(NumberObservable<? extends Number> observable) {
		return NumberCompution.multiply(this, observable);
	}
	
	/**
	 * Returns NumberCompution of this.value - observable.value.
	 * 
	 * @param observable
	 * @return NumberCompution of this.value - observable.value.
	 */
	default public NumberCompution subtract(NumberObservable<? extends Number> observable) {
		return NumberCompution.subtract(this, observable);
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
		return this.add(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(long value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(float value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns NumberCompution of this.value + value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value + value.
	 */
	default public NumberCompution add(double value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(int value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}

	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(long value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}

	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(float value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns NumberCompution of this.value * value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value * value.
	 */
	default public NumberCompution multiply(double value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(int value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(long value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(float value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns NumberCompution of this.value - value.
	 * 
	 * @param value
	 * @return NumberCompution of this.value - value.
	 */
	default public NumberCompution subtract(double value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/* Comparative Compution Bases */
	
	/**
	 * Returns ComparativeCompution of this.value == observable.value.
	 * 
	 * @param observable
	 * @return
	 */
	default ComparativeCompution isEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.equalTo(this, observable);
	}
	
	/**
	 * Returns ComparativeCompution of this.value != observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value != observable.value.
	 */
	default ComparativeCompution isNotEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.notEqualTo(this, observable);
	}
	
	/**
	 * Returns ComparativeCompution of this.value < observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value < observable.value.
	 */
	default ComparativeCompution isLessThan(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.lessThan(this, observable);
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= observable.value.
	 * @param observable
	 * @return ComparativeCompution of this.value <= observable.value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.lessThanOrEqualTo(this, observable);
	}
	
	/**
	 * Returns ComparativeCompution of this.value > observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value > observable.value.
	 */
	default ComparativeCompution isGreaterThan(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.greaterThan(this, observable);
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= observable.value.
	 * 
	 * @param observable
	 * @return ComparativeCompution of this.value >= observable.value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.greaterThanOrEqualTo(this, observable);
	}
	
	/* Comparative Compution Primitives */
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(int value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(long value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(float value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == value.
	 */
	default ComparativeCompution isEqualTo(double value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(int value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isNotEqualTo(long value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(float value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isNotEqualTo(double value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value != value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != value.
	 */
	default ComparativeCompution isLessThan(int value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value < value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < value.
	 */
	default ComparativeCompution isLessThan(long value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value < value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < value.
	 */
	default ComparativeCompution isLessThan(float value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value < value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < value.
	 */
	default ComparativeCompution isLessThan(double value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(int value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(long value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(float value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value <= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= value.
	 */
	default ComparativeCompution isLessThanOrEqualTo(double value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(int value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(long value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(float value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value > value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > value.
	 */
	default ComparativeCompution isGreaterThan(double value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(int value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(long value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(float value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value >= value.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= value.
	 */
	default ComparativeCompution isGreaterThanOrEqualTo(double value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/**
	 * Returns ComparativeCompution of this.value == 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value == 0.
	 */
	default ComparativeCompution isEqualToZero() {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	/**
	 * Returns ComparativeCompution of this.value != 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value != 0.
	 */
	default ComparativeCompution isNotEqualToZero() {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	/**
	 * Returns ComparativeCompution of this.value < 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value < 0.
	 */
	default ComparativeCompution isLessThanZero() {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}

	/**
	 * Returns ComparativeCompution of this.value <= 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value <= 0.
	 */
	default ComparativeCompution isLessThanOrEqualToZero() {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}

	/**
	 * Returns ComparativeCompution of this.value > 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value > 0.
	 */
	default ComparativeCompution isGreaterThanZero() {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}

	/**
	 * Returns ComparativeCompution of this.value >= 0.
	 * 
	 * @param value
	 * @return ComparativeCompution of this.value >= 0.
	 */
	default ComparativeCompution isGreaterThanOrEqualToZero() {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		NumberWaitUntil.getInstance().isEqualTo(this, observable);
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
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isEqualTo(this, observable, timeout, unit);
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
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isEqualTo(this, observable, p);
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
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		NumberWaitUntil.getInstance().isNotEqualTo(this, observable);
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
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isNotEqualTo(this, observable, timeout, unit);
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
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isNotEqualTo(this, observable, p);
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
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable) throws InterruptedException {
		NumberWaitUntil.getInstance().isLessThan(this, observable);
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
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isLessThan(this, observable, timeout, unit);
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
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isLessThan(this, observable, p);
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
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		NumberWaitUntil.getInstance().isLessThanOrEqualTo(this, observable);
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
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isLessThanOrEqualTo(this, observable, timeout, unit);
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
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isLessThanOrEqualTo(this, observable, p);
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
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable) throws InterruptedException {
		NumberWaitUntil.getInstance().isGreaterThan(this, observable);
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
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isGreaterThan(this, observable, timeout, unit);
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
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isGreaterThan(this, observable, p);
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
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		NumberWaitUntil.getInstance().isGreaterThanOrEqualTo(this, observable);
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
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isGreaterThanOrEqualTo(this, observable, timeout, unit);
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
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		NumberWaitUntil.getInstance().isGreaterThanOrEqualTo(this, observable, p);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), p);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), p);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), p);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), p);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), p);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), p);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value), p);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value), p);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value), p);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), p);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), p);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), p);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value), p);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value), p);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value), p);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(timeout, unit);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), p);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), p);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), p);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
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
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), p);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
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
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), p);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
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
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), p);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
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
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), p);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
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
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), p);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
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
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), p);
	}
	
}
