package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CollectionWaitUntil extends AbstractWaitUntil {

	protected CollectionWaitUntil() {
		super();
	}
	
	private static final class SingletonHolder {
		private static final CollectionWaitUntil inst = new CollectionWaitUntil();
	}
	
	public static CollectionWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	private class InnerContains<E, T extends Collection<E>> extends AbstractInner implements ChangeListener<T> {
		
		private final Object ref;
		
		private InnerContains(boolean contains, Object o) {
			super(contains);
			this.ref = o;
		}
		
		@Override
		public void changed(T value) {
			this.set(value.contains(this.ref));
		}
	}
	
	public <E, T extends Collection<E>> void contains(CollectionObservable<E, T> observable, boolean contains, Object o) throws InterruptedException {
		final InnerContains<E, T> i = new InnerContains<>(contains, o);
		try {
			observable.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <E, T extends Collection<E>> void contains(CollectionObservable<E, T> observable, boolean contains, Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContains<E, T> i = new InnerContains<>(contains, o);
		try {
			observable.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}

	public <E, T extends Collection<E>> void contains(CollectionObservable<E, T> observable, boolean contains, Object o, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerContains<E, T> i = new InnerContains<>(contains, o);
		try {
			observable.addChangeListener(i);
			i.waitUntil(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	private class InnerContainsAll<E, T extends Collection<E>> extends AbstractInner implements ChangeListener<T> {
		
		private final Collection<?> ref;
		
		private InnerContainsAll(boolean contains, Collection<?> c) {
			super(contains);
			this.ref = c;
		}
		
		@Override
		public void changed(T value) {
			set(value.containsAll(this.ref));
		}
	}
	
	public <E, T extends Collection<E>> void containsAll(CollectionObservable<E, T> observable, boolean contains, Collection<?> c) throws InterruptedException {
		final InnerContainsAll<E, T> i = new InnerContainsAll<>(contains, c);
		try {
			observable.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <E, T extends Collection<E>> void containsAll(CollectionObservable<E, T> observable, boolean contains, Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerContainsAll<E, T> i = new InnerContainsAll<>(contains, c);
		try {
			observable.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <E, T extends Collection<E>> void containsAll(CollectionObservable<E, T> observable, boolean contains, Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerContainsAll<E, T> i = new InnerContainsAll<>(contains, c);
		try {
			observable.addChangeListener(i);
			i.waitUntil(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	private class InnerIsEmpty<E, T extends Collection<E>> extends AbstractInner implements ChangeListener<T> {
		
		private InnerIsEmpty(boolean isEmpty) {
			super(isEmpty);
		}
		
		@Override
		public void changed(T value) {
			this.set(value.isEmpty());
		}
	}
	
	public <E, T extends Collection<E>> void isEmpty(CollectionObservable<E, T> observable, boolean isEmpty) throws InterruptedException {
		final InnerIsEmpty<E, T> i = new InnerIsEmpty<>(isEmpty);
		try {
			observable.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <E, T extends Collection<E>> void isEmpty(CollectionObservable<E, T> observable, boolean isEmpty, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerIsEmpty<E, T> i = new InnerIsEmpty<>(isEmpty);
		try {
			observable.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public <E, T extends Collection<E>> void isEmpty(CollectionObservable<E, T> observable, boolean isEmpty, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerIsEmpty<E, T> i = new InnerIsEmpty<>(isEmpty);
		try {
			observable.addChangeListener(i);
			i.waitUntil(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	private class InnerSizeObservable<E, T extends Collection<E>> implements IntegerObservable, ChangeListener<T> {
		
		private final Object sync = new Object();
		int size;
		
		private InnerSizeObservable() {
			this.size = 0;
		}
		
		@Override
		public boolean isInteger() {
			return true;
		}
		
		@Override
		public boolean isLong() {
			return false;
		}
		
		@Override
		public boolean isFloat() {
			return false;
		}
		
		@Override
		public boolean isDouble() {
			return false;
		}
		
		private final Collection<ChangeListener<? super Integer>> lstnrs = new HashSet<>();
		
		@Override
		public boolean addChangeListener(ChangeListener<? super Integer> l) {
			synchronized ( this.sync ) {
				boolean f = this.lstnrs.add(l);
				if ( f ) {
					l.changed(Integer.valueOf(this.size));
				}
				return f;
			}
		}

		@Override
		public boolean removeChangeListener(ChangeListener<? super Integer> l) {
			synchronized ( this.sync ) {
				return this.lstnrs.remove(l);
			}
		}
		
		@Override
		public void changed(T value) {
			synchronized ( this.sync ) {
				int v = value.size();
				if ( v != this.size ) {
					this.size = v;
					final Integer i = Integer.valueOf(this.size);
					this.lstnrs.forEach(l -> {
						l.changed(i);
					});
				}
			}
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsEqualTo(CollectionObservable<E, T> observable, int value) throws InterruptedException {
		this.sizeIsEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	public <E , T extends Collection<E>> void sizeIsEqualTo(CollectionObservable<E, T> observable, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.sizeIsEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	public <E , T extends Collection<E>> void sizeIsEqualTo(CollectionObservable<E, T> observable, int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.sizeIsEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
	}
	
	public <E , T extends Collection<E>> void sizeIsNotEqualTo(CollectionObservable<E, T> observable, int value) throws InterruptedException {
		this.sizeIsNotEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	public <E , T extends Collection<E>> void sizeIsNotEqualTo(CollectionObservable<E, T> observable, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.sizeIsNotEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	public <E , T extends Collection<E>> void sizeIsNotEqualTo(CollectionObservable<E, T> observable, int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.sizeIsNotEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThan(CollectionObservable<E, T> observable, int value) throws InterruptedException {
		this.sizeIsLessThan(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThan(CollectionObservable<E, T> observable, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.sizeIsLessThan(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThan(CollectionObservable<E, T> observable, int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.sizeIsLessThan(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThanOrEqualTo(CollectionObservable<E, T> observable, int value) throws InterruptedException {
		this.sizeIsLessThanOrEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThanOrEqualTo(CollectionObservable<E, T> observable, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.sizeIsLessThanOrEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThanOrEqualTo(CollectionObservable<E, T> observable, int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.sizeIsLessThanOrEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThan(CollectionObservable<E, T> observable, int value) throws InterruptedException {
		this.sizeIsGreaterThan(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThan(CollectionObservable<E, T> observable, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.sizeIsGreaterThan(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThan(CollectionObservable<E, T> observable, int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.sizeIsGreaterThan(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThanOrEqualTo(CollectionObservable<E, T> observable, int value) throws InterruptedException {
		this.sizeIsGreaterThanOrEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value));
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThanOrEqualTo(CollectionObservable<E, T> observable, int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		this.sizeIsGreaterThanOrEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), timeout, unit);
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThanOrEqualTo(CollectionObservable<E, T> observable, int value, TimeGettable p) throws InterruptedException, TimeoutException {
		this.sizeIsGreaterThanOrEqualTo(observable, UnmodifiablePropertyBuilder.getInstance().newInteger(value), p);
	}
	
	public <E , T extends Collection<E>> void sizeIsEqualTo(CollectionObservable<E, T> observable, IntegerObservable i) throws InterruptedException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isEqualTo(x, i);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isEqualTo(x, i, timeout, unit);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isEqualTo(x, i, p);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsNotEqualTo(CollectionObservable<E, T> observable, IntegerObservable i) throws InterruptedException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isNotEqualTo(x, i);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsNotEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isNotEqualTo(x, i, timeout, unit);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsNotEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isNotEqualTo(x, i, p);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThan(CollectionObservable<E, T> observable, IntegerObservable i) throws InterruptedException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isLessThan(x, i);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThan(CollectionObservable<E, T> observable, IntegerObservable i, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isLessThan(x, i, timeout, unit);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThan(CollectionObservable<E, T> observable, IntegerObservable i, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isLessThan(x, i, p);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThanOrEqualTo(CollectionObservable<E, T> observable, IntegerObservable i) throws InterruptedException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isLessThanOrEqualTo(x, i);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThanOrEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isLessThanOrEqualTo(x, i, timeout, unit);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsLessThanOrEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isLessThanOrEqualTo(x, i, p);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThan(CollectionObservable<E, T> observable, IntegerObservable i) throws InterruptedException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isGreaterThan(x, i);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThan(CollectionObservable<E, T> observable, IntegerObservable i, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isGreaterThan(x, i, timeout, unit);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThan(CollectionObservable<E, T> observable, IntegerObservable i, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isGreaterThan(x, i, p);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThanOrEqualTo(CollectionObservable<E, T> observable, IntegerObservable i) throws InterruptedException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isGreaterThanOrEqualTo(x, i);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThanOrEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isGreaterThanOrEqualTo(x, i, timeout, unit);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
	public <E , T extends Collection<E>> void sizeIsGreaterThanOrEqualTo(CollectionObservable<E, T> observable, IntegerObservable i, TimeGettable p) throws InterruptedException, TimeoutException {
		final InnerSizeObservable<E, T> x = new InnerSizeObservable<>();
		try {
			observable.addChangeListener(x);
			NumericComparativeWaitUntil.getInstance().isGreaterThanOrEqualTo(x, i, p);
		}
		finally {
			observable.removeChangeListener(x);
		}
	}
	
}
