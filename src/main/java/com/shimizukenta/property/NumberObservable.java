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
	
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		ComparativeCompution.equalTo(this, observable).waitUntilTrue();
	}
	
	default public void waitUntilEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ComparativeCompution.equalTo(this, observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		ComparativeCompution.notEqualTo(this, observable).waitUntilTrue();
	}
	
	default public void waitUntilNotEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ComparativeCompution.notEqualTo(this, observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable) throws InterruptedException {
		ComparativeCompution.lessThan(this, observable).waitUntilTrue();
	}
	
	default public void waitUntilLessThan(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ComparativeCompution.lessThan(this, observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		ComparativeCompution.lessThanOrEqualTo(this, observable).waitUntilTrue();
	}
	
	default public void waitUntilLessThanOrEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ComparativeCompution.lessThanOrEqualTo(this, observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable) throws InterruptedException {
		ComparativeCompution.greaterThan(this, observable).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThan(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ComparativeCompution.greaterThan(this, observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable) throws InterruptedException {
		ComparativeCompution.greaterThanOrEqualTo(this, observable).waitUntilTrue();
	}
	
	default public void waitUntilGreaterThanOrEqualTo(NumberObservable<? extends Number> observable, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		ComparativeCompution.greaterThanOrEqualTo(this, observable).waitUntilTrue(timeout, unit);
	}
	
	default public void waitUntilEqualTo(int value) throws InterruptedException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public void waitUntilEqualTo(long value) throws InterruptedException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public void waitUntilEqualTo(float value) throws InterruptedException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public void waitUntilEqualTo(double value) throws InterruptedException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(int value) throws InterruptedException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public void waitUntilNotEqualTo(long value) throws InterruptedException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public void waitUntilNotEqualTo(float value) throws InterruptedException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public void waitUntilNotEqualTo(double value) throws InterruptedException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(int value) throws InterruptedException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public void waitUntilLessThan(long value) throws InterruptedException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public void waitUntilLessThan(float value) throws InterruptedException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public void waitUntilLessThan(double value) throws InterruptedException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(int value) throws InterruptedException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public void waitUntilGreaterThan(long value) throws InterruptedException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public void waitUntilGreaterThan(float value) throws InterruptedException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public void waitUntilGreaterThan(double value) throws InterruptedException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThan(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThan(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newLong(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newFloat(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().newDouble(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value, TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualTo(value, a.timeout(), a.unit());
	}
	
	default public void waitUntilEqualToZero() throws InterruptedException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
	}
	
	default public void waitUntilEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualToZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
	}
	
	default public void waitUntilNotEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualToZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
	}
	
	default public void waitUntilLessThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
	}
	
	default public void waitUntilGreaterThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualToZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero());
	}
	
	default public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(UnmodifiablePropertyBuilder.getInstance().getIntegerZero(), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualToZero(a.timeout(), a.unit());
	}

}
