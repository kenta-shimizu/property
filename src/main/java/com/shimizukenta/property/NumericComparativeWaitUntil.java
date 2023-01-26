package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class NumericComparativeWaitUntil {

	private NumericComparativeWaitUntil() {
		/* Nothing */
	}
	
	private static class SingletonHolder {
		private static final NumericComparativeWaitUntil inst = new NumericComparativeWaitUntil();
	}
	
	public static NumericComparativeWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildIsEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumericComparativeComputionBuilder.getInstance().equalTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildIsNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumericComparativeComputionBuilder.getInstance().notEqualTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildIsLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumericComparativeComputionBuilder.getInstance().lessThan(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildIsLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumericComparativeComputionBuilder.getInstance().lessThanOrEqualTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildIsGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumericComparativeComputionBuilder.getInstance().greaterThan(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildIsGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return NumericComparativeComputionBuilder.getInstance().greaterThanOrEqualTo(left, right);
	}
	
	private void waitUntil(
			AbstractBiPredicateCompution<Number, Number> i,
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
			AbstractBiPredicateCompution<Number, Number> i,
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
			AbstractBiPredicateCompution<Number, Number> i,
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
