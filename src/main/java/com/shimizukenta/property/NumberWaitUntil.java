package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class NumberWaitUntil extends AbstractWaitUntil {

	protected NumberWaitUntil() {
		super();
	}
	
	private static class SingletonHolder {
		private static final NumberWaitUntil inst = new NumberWaitUntil();
	}
	
	public static NumberWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	private AbstractComparativeCompution<Number, Number> buildIsEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumberComparativeComputionBuilder.getInstance().equalTo(left, right);
	}
	
	private AbstractComparativeCompution<Number, Number> buildIsNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumberComparativeComputionBuilder.getInstance().notEqualTo(left, right);
	}
	
	private AbstractComparativeCompution<Number, Number> buildIsLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumberComparativeComputionBuilder.getInstance().lessThan(left, right);
	}
	
	private AbstractComparativeCompution<Number, Number> buildIsLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumberComparativeComputionBuilder.getInstance().lessThanOrEqualTo(left, right);
	}
	
	private AbstractComparativeCompution<Number, Number> buildIsGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumberComparativeComputionBuilder.getInstance().greaterThan(left, right);
	}
	
	private AbstractComparativeCompution<Number, Number> buildIsGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumberComparativeComputionBuilder.getInstance().greaterThanOrEqualTo(left, right);
	}
	
	private void waitUntil(
			AbstractComparativeCompution<Number, Number> i,
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		try {
			i.waitUntilTrue();
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	private void waitUntil(
			AbstractComparativeCompution<Number, Number> i,
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(timeout, unit);
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	private void waitUntil(
			AbstractComparativeCompution<Number, Number> i,
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	public void isEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		this.waitUntil(this.buildIsEqualTo(left, right), left, right);
	}
	
	public void isEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsEqualTo(left, right), left, right, timeout, unit);
	}
	
	public void isEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsEqualTo(left, right), left, right, p);
	}
	
	public void isNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		this.waitUntil(this.buildIsNotEqualTo(left, right), left, right);
	}
	
	public void isNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsNotEqualTo(left, right), left, right, timeout, unit);
	}
	
	public void isNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsNotEqualTo(left, right), left, right, p);
	}
	
	public void isLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		this.waitUntil(this.buildIsLessThan(left, right), left, right);
	}
	
	public void isLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsLessThan(left, right), left, right, timeout, unit);
	}
	
	public void isLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsLessThan(left, right), left, right, p);
	}
	
	public void isLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		this.waitUntil(this.buildIsLessThanOrEqualTo(left, right), left, right);
	}
	
	public void isLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsLessThanOrEqualTo(left, right), left, right, timeout, unit);
	}
	
	public void isLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsLessThanOrEqualTo(left, right), left, right, p);
	}
	
	public void isGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		this.waitUntil(this.buildIsGreaterThan(left, right), left, right);
	}
	
	public void isGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsGreaterThan(left, right), left, right, timeout, unit);
	}
	
	public void isGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsGreaterThan(left, right), left, right, p);
	}
	
	public void isGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		this.waitUntil(this.buildIsGreaterThanOrEqualTo(left, right), left, right);
	}
	
	public void isGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsGreaterThanOrEqualTo(left, right), left, right, timeout, unit);
	}
	
	public void isGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		this.waitUntil(this.buildIsGreaterThanOrEqualTo(left, right), left, right, p);
	}
	
}
