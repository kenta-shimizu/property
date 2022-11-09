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
		this.waitUntilEqualTo(IntegerProperty.newInstance(value));
	}
	
	default public void waitUntilEqualTo(long value) throws InterruptedException {
		this.waitUntilEqualTo(LongProperty.newInstance(value));
	}
	
	default public void waitUntilEqualTo(float value) throws InterruptedException {
		this.waitUntilEqualTo(FloatProperty.newInstance(value));
	}
	
	default public void waitUntilEqualTo(double value) throws InterruptedException {
		this.waitUntilEqualTo(DoubleProperty.newInstance(value));
	}
	
	default public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(IntegerProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(LongProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(FloatProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(DoubleProperty.newInstance(value), timeout, unit);
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
		this.waitUntilNotEqualTo(IntegerProperty.newInstance(value));
	}
	
	default public void waitUntilNotEqualTo(long value) throws InterruptedException {
		this.waitUntilNotEqualTo(LongProperty.newInstance(value));
	}
	
	default public void waitUntilNotEqualTo(float value) throws InterruptedException {
		this.waitUntilNotEqualTo(FloatProperty.newInstance(value));
	}
	
	default public void waitUntilNotEqualTo(double value) throws InterruptedException {
		this.waitUntilNotEqualTo(DoubleProperty.newInstance(value));
	}
	
	default public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(IntegerProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(LongProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(FloatProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(DoubleProperty.newInstance(value), timeout, unit);
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
		this.waitUntilLessThan(IntegerProperty.newInstance(value));
	}
	
	default public void waitUntilLessThan(long value) throws InterruptedException {
		this.waitUntilLessThan(LongProperty.newInstance(value));
	}
	
	default public void waitUntilLessThan(float value) throws InterruptedException {
		this.waitUntilLessThan(FloatProperty.newInstance(value));
	}
	
	default public void waitUntilLessThan(double value) throws InterruptedException {
		this.waitUntilLessThan(DoubleProperty.newInstance(value));
	}
	
	default public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(IntegerProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(LongProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(FloatProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(DoubleProperty.newInstance(value), timeout, unit);
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
		this.waitUntilLessThanOrEqualTo(IntegerProperty.newInstance(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(LongProperty.newInstance(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(FloatProperty.newInstance(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(DoubleProperty.newInstance(value));
	}
	
	default public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(IntegerProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(LongProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(FloatProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(DoubleProperty.newInstance(value), timeout, unit);
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
		this.waitUntilGreaterThan(IntegerProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThan(long value) throws InterruptedException {
		this.waitUntilGreaterThan(LongProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThan(float value) throws InterruptedException {
		this.waitUntilGreaterThan(FloatProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThan(double value) throws InterruptedException {
		this.waitUntilGreaterThan(DoubleProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(IntegerProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(LongProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(FloatProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(DoubleProperty.newInstance(value), timeout, unit);
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
		this.waitUntilGreaterThanOrEqualTo(IntegerProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(LongProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(FloatProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(DoubleProperty.newInstance(value));
	}
	
	default public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(IntegerProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(LongProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(FloatProperty.newInstance(value), timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(DoubleProperty.newInstance(value), timeout, unit);
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
		this.waitUntilEqualTo(0);
	}
	
	default public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilEqualTo(0, timeout, unit);
	}
	
	default public void waitUntilEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilEqualToZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilNotEqualToZero() throws InterruptedException {
		this.waitUntilNotEqualTo(0);
	}
	
	default public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilNotEqualTo(0, timeout, unit);
	}
	
	default public void waitUntilNotEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilNotEqualToZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanZero() throws InterruptedException {
		this.waitUntilLessThan(0);
	}
	
	default public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThan(0, timeout, unit);
	}
	
	default public void waitUntilLessThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanZero() throws InterruptedException {
		this.waitUntilGreaterThan(0);
	}
	
	default public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThan(0, timeout, unit);
	}
	
	default public void waitUntilGreaterThanZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilLessThanOrEqualToZero() throws InterruptedException {
		this.waitUntilLessThanOrEqualTo(0);
	}
	
	default public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilLessThanOrEqualTo(0, timeout, unit);
	}
	
	default public void waitUntilLessThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilLessThanOrEqualToZero(a.timeout(), a.unit());
	}
	
	default public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException {
		this.waitUntilGreaterThanOrEqualTo(0);
	}
	
	default public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.waitUntilGreaterThanOrEqualTo(0, timeout, unit);
	}
	
	default public void waitUntilGreaterThanOrEqualToZero(TimeGettable p) throws InterruptedException, TimeoutException {
		TimeoutAndUnit a = p.get();
		this.waitUntilGreaterThanOrEqualToZero(a.timeout(), a.unit());
	}

}
