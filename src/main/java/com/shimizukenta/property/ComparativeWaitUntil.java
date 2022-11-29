package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiPredicate;

public class ComparativeWaitUntil extends AbstractWaitUntil {

	protected ComparativeWaitUntil() {
		super();
	}
	
	private static class SingletonHolder {
		private static final ComparativeWaitUntil inst = new ComparativeWaitUntil();
	}
	
	private static final Integer initialZero = Integer.valueOf(0);
	
	public static ComparativeWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	private class Inner extends AbstractInner {
		
		private final Object sync = new Object();
		
		private final BiPredicate<Number, Number> bp;
		private Number left;
		private Number right;
		
		private Inner(boolean f, BiPredicate<Number, Number> bp) {
			super(f);
			this.bp = bp;
			this.left = initialZero;
			this.right = initialZero;
		}
		
		private void leftChanged(Number n) {
			synchronized ( this.sync ) {
				this.left = n;
				this.set(bp.test(this.left, this.right));
			}
		}
		
		private final ChangeListener<Number> leftLstnr = this::leftChanged;
		
		public ChangeListener<Number> leftListener() {
			return leftLstnr;
		}
		
		private void rightChanged(Number n) {
			synchronized ( this.sync ) {
				this.right = n;
				this.set(bp.test(this.left, this.right));
			}
		}
		
		private final ChangeListener<Number> rightLstnr = this::rightChanged;
		
		public ChangeListener<Number> rightListener() {
			return rightLstnr;
		}
	}
	
	private boolean isInteger(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return left.isInteger() || right.isInteger();
	}
	
	private boolean isLong(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return left.isLong() || right.isLong();
	}
	
	private boolean isFloat(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return left.isFloat() || right.isFloat();
	}
	
	private boolean isDouble(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		return left.isDouble() || right.isDouble();
	}
	
	private Inner buildIsEqualTo(boolean f, NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildConvertDoubleIsEqualTo(f);
		}
		
		if ( isFloat(left, right) ) {
			return new Inner(f, (l, r) -> l.floatValue() == r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return new Inner(f, (l, r) -> l.longValue() == r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return new Inner(f, (l, r) -> l.intValue() == r.intValue());
		}
		
		return buildConvertDoubleIsEqualTo(f);
	}
	
	private Inner buildConvertDoubleIsEqualTo(boolean f) {
		return new Inner(f, (l, r) -> l.doubleValue() == r.doubleValue());
	}
	
	private Inner buildIsLessThan(boolean f, NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildConvertDoubleIsLessThan(f);
		}
		
		if ( isFloat(left, right) ) {
			return new Inner(f, (l, r) -> l.floatValue() < r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return new Inner(f, (l, r) -> l.longValue() < r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return new Inner(f, (l, r) -> l.intValue() < r.intValue());
		}
		
		return buildConvertDoubleIsLessThan(f);
	}
	
	private Inner buildConvertDoubleIsLessThan(boolean f) {
		return new Inner(f, (l, r) -> l.doubleValue() < r.doubleValue());
	}
	
	private void addListeners(Inner i, NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		left.addChangeListener(i.leftListener());
		right.addChangeListener(i.rightListener());
	}
	
	private void removeListeners(Inner i, NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) {
		left.removeChangeListener(i.leftListener());
		right.removeChangeListener(i.rightListener());
	}
	
	public void isEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) throws InterruptedException {
		final Inner i = this.buildIsEqualTo(true, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil();
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsEqualTo(true, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsEqualTo(true, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(p);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isNotEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) throws InterruptedException {
		final Inner i = this.buildIsEqualTo(false, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil();
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isNotEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsEqualTo(false, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isNotEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsEqualTo(false, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(p);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isLessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) throws InterruptedException {
		final Inner i = this.buildIsLessThan(true, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil();
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isLessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(true, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isLessThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(true, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(p);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isLessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) throws InterruptedException {
		final Inner i = this.buildIsLessThan(false, right, left);
		try {
			this.addListeners(i, right, left);
			i.waitUntil();
		}
		finally {
			this.removeListeners(i, right, left);
		}
	}
	
	public void isLessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(false, right, left);
		try {
			this.addListeners(i, right, left);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeListeners(i, right, left);
		}
	}
	
	public void isLessThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(false, right, left);
		try {
			this.addListeners(i, right, left);
			i.waitUntil(p);
		}
		finally {
			this.removeListeners(i, right, left);
		}
	}
	
	public void isGreaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) throws InterruptedException {
		final Inner i = this.buildIsLessThan(true, right, left);
		try {
			this.addListeners(i, right, left);
			i.waitUntil();
		}
		finally {
			this.removeListeners(i, right, left);
		}
	}
	
	public void isGreaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(true, right, left);
		try {
			this.addListeners(i, right, left);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeListeners(i, right, left);
		}
	}
	
	public void isGreaterThan(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(true, right, left);
		try {
			this.addListeners(i, right, left);
			i.waitUntil(p);
		}
		finally {
			this.removeListeners(i, right, left);
		}
	}
	
	public void isGreaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right) throws InterruptedException {
		final Inner i = this.buildIsLessThan(false, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil();
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isGreaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(false, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(timeout, unit);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
	public void isGreaterThanOrEqualTo(NumberObservable<? extends Number> left, NumberObservable<? extends Number> right, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = this.buildIsLessThan(false, left, right);
		try {
			this.addListeners(i, left, right);
			i.waitUntil(p);
		}
		finally {
			this.removeListeners(i, left, right);
		}
	}
	
}
