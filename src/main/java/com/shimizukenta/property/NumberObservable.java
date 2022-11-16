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
public interface NumberObservable<T extends Number> extends Observable<T, NumberSettable<T>> {
	
	/* Casts */
	
	default public IntegerCompution toInteger() {
		return NumberComputionBuilder.getInstance().toInteger(this);
	}
	
	default public LongCompution toLong() {
		return NumberComputionBuilder.getInstance().toLong(this);
	}
	
	default public FloatCompution toFloat() {
		return NumberComputionBuilder.getInstance().toFloat(this);
	}
	
	default public DoubleCompution toDouble() {
		return NumberComputionBuilder.getInstance().toDouble(this);
	}
	
	/* Number Compution Bases */
	
	default public NumberCompution add(NumberObservable<? extends Number> observable) {
		return NumberCompution.add(this, observable);
	}
	
	default public NumberCompution multiply(NumberObservable<? extends Number> observable) {
		return NumberCompution.multiply(this, observable);
	}
	
	default public NumberCompution subtract(NumberObservable<? extends Number> observable) {
		return NumberCompution.subtract(this, observable);
	}
	
	default public NumberCompution negate() {
		return NumberCompution.negate(this);
	}
	
	/* Number Compution Premitives */
	
	default public NumberCompution add(int value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public NumberCompution add(long value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public NumberCompution add(float value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public NumberCompution add(double value) {
		return this.add(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public NumberCompution multiply(int value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}

	default public NumberCompution multiply(long value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}

	default public NumberCompution multiply(float value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public NumberCompution multiply(double value) {
		return this.multiply(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public NumberCompution subtract(int value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public NumberCompution subtract(long value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public NumberCompution subtract(float value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public NumberCompution subtract(double value) {
		return this.subtract(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	/* Comparative Compution Bases */
	
	default ComparativeCompution isEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.equalTo(this, observable);
	}
	
	default ComparativeCompution isNotEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.notEqualTo(this, observable);
	}
	
	default ComparativeCompution isLessThan(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.lessThan(this, observable);
	}

	default ComparativeCompution isLessThanOrEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.lessThanOrEqualTo(this, observable);
	}

	default ComparativeCompution isGreaterThan(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.greaterThan(this, observable);
	}

	default ComparativeCompution isGreaterThanOrEqualTo(NumberObservable<? extends Number> observable) {
		return ComparativeCompution.greaterThanOrEqualTo(this, observable);
	}
	
	/* Comparative Compution Primitives */
	
	default ComparativeCompution isEqualTo(int value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isEqualTo(long value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default ComparativeCompution isEqualTo(float value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default ComparativeCompution isEqualTo(double value) {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default ComparativeCompution isNotEqualTo(int value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isNotEqualTo(long value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default ComparativeCompution isNotEqualTo(float value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default ComparativeCompution isNotEqualTo(double value) {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default ComparativeCompution isLessThan(int value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isLessThan(long value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default ComparativeCompution isLessThan(float value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default ComparativeCompution isLessThan(double value) {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default ComparativeCompution isLessThanOrEqualTo(int value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isLessThanOrEqualTo(long value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default ComparativeCompution isLessThanOrEqualTo(float value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default ComparativeCompution isLessThanOrEqualTo(double value) {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default ComparativeCompution isGreaterThan(int value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isGreaterThan(long value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default ComparativeCompution isGreaterThan(float value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default ComparativeCompution isGreaterThan(double value) {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default ComparativeCompution isGreaterThanOrEqualTo(int value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default ComparativeCompution isGreaterThanOrEqualTo(long value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default ComparativeCompution isGreaterThanOrEqualTo(float value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default ComparativeCompution isGreaterThanOrEqualTo(double value) {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default ComparativeCompution isEqualToZero() {
		return this.isEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default ComparativeCompution isNotEqualToZero() {
		return this.isNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default ComparativeCompution isLessThanZero() {
		return this.isLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}

	default ComparativeCompution isLessThanOrEqualToZero() {
		return this.isLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}

	default ComparativeCompution isGreaterThanZero() {
		return this.isGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}

	default ComparativeCompution isGreaterThanOrEqualToZero() {
		return this.isGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	/* Wait Until Bases */
	
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		this.isEqualTo(observable).waitUntilTrue();
	}
	
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isEqualTo(observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isEqualTo(observable).waitUntilTrue(p);
	}
	
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		this.isNotEqualTo(observable).waitUntilTrue();
	}
	
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(observable).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable) throws InterruptedException {
		this.isLessThan(observable).waitUntilTrue();
	}
	
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThan(observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThan(observable).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		this.isLessThanOrEqualTo(observable).waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(observable).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable) throws InterruptedException {
		this.isGreaterThan(observable).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThan(observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThan(observable).waitUntilTrue(p);
	}
	
	
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		this.isGreaterThanOrEqualTo(observable).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(observable).waitUntilTrue(p);
	}
	
	/* Wait until Primitives */
	
	default public void waitUntilEqualTo(int value) throws InterruptedException {
		this.isEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilEqualTo(long value) throws InterruptedException {
		this.isEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilEqualTo(float value) throws InterruptedException {
		this.isEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilEqualTo(double value) throws InterruptedException {
		this.isEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilNotEqualTo(int value) throws InterruptedException {
		this.isNotEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilNotEqualTo(long value) throws InterruptedException {
		this.isNotEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilNotEqualTo(float value) throws InterruptedException {
		this.isNotEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilNotEqualTo(double value) throws InterruptedException {
		this.isNotEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilNotEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilNotEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilNotEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isNotEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThan(int value) throws InterruptedException {
		this.isLessThan(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThan(long value) throws InterruptedException {
		this.isLessThan(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThan(float value) throws InterruptedException {
		this.isLessThan(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThan(double value) throws InterruptedException {
		this.isLessThan(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException {
		this.isLessThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException {
		this.isLessThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException {
		this.isLessThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException {
		this.isLessThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThan(int value) throws InterruptedException {
		this.isGreaterThan(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThan(long value) throws InterruptedException {
		this.isGreaterThan(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThan(float value) throws InterruptedException {
		this.isGreaterThan(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThan(double value) throws InterruptedException {
		this.isGreaterThan(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThan(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualTo(value).waitUntilTrue(p);
	}
	
	/* Wait Until ZEROs */
	
	default public void waitUntilEqualToZero() throws InterruptedException {
		this.isEqualToZero().waitUntilTrue();
	}
	
	default public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isEqualToZero().waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.isEqualToZero().waitUntilTrue(p);
	}
	
	default public void waitUntilNotEqualToZero() throws InterruptedException {
		this.isNotEqualToZero().waitUntilTrue();
	}
	
	default public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isNotEqualToZero().waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.isNotEqualToZero().waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanZero() throws InterruptedException {
		this.isLessThanZero().waitUntilTrue();
	}
	
	default public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanZero().waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanZero().waitUntilTrue(p);
	}
	
	default public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.isLessThanOrEqualToZero().waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualToZero().waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.isLessThanOrEqualToZero().waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThanZero() throws InterruptedException {
		this.isGreaterThanZero().waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanZero().waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanZero().waitUntilTrue(p);
	}
	
	default public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.isGreaterThanOrEqualToZero().waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualToZero().waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		this.isGreaterThanOrEqualToZero().waitUntilTrue(p);
	}

}
