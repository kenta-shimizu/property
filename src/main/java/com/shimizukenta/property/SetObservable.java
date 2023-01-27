package com.shimizukenta.property;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <E> Element
 */
public interface SetObservable<E> extends CollectionObservable<E, Set<E>> {
	
	@Override
	default public BooleanCompution computeIsEmpty() {
		return CollectionUtils.computeIsEmpty(this, new HashSet<>());
	}
	
	@Override
	default public BooleanCompution computeIsNotEmpty() {
		return CollectionUtils.computeIsNotEmpty(this, new HashSet<>());
	}
	
	@Override
	default public BooleanCompution computeContains(Object o) {
		return CollectionUtils.computeContains(this, new HashSet<>(), o);
	}
	
	@Override
	default public BooleanCompution computeNotContains(Object o) {
		return CollectionUtils.computeNotContains(this, new HashSet<>(), o);
	}
	
	@Override
	default public BooleanCompution computeContainsAll(Collection<?> c) {
		return CollectionUtils.computeContainsAll(this, new HashSet<>(), c);
	}
	
	@Override
	default public BooleanCompution computeNotContainsAll(Collection<?> c) {
		return CollectionUtils.computeNotContainsAll(this, new HashSet<>(), c);
	}
	
	@Override
	default public void waitUntilIsEmpty() throws InterruptedException {
		CollectionUtils.waitUntil(CollectionUtils.computeIsEmpty(this, new HashSet<>()), this);
	}
	
	@Override
	default public void waitUntilIsEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeIsEmpty(this, new HashSet<>()), this, timeout, unit);
	}
	
	@Override
	default public void waitUntilIsEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeIsEmpty(this, new HashSet<>()), this, p);
	}
	
	@Override
	default public void waitUntilIsNotEmpty() throws InterruptedException {
		CollectionUtils.waitUntil(CollectionUtils.computeIsNotEmpty(this, new HashSet<>()), this);
	}
	
	@Override
	default public void waitUntilIsNotEmpty(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeIsNotEmpty(this, new HashSet<>()), this, timeout, unit);
	}
	
	@Override
	default public void waitUntilIsNotEmpty(TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeIsNotEmpty(this, new HashSet<>()), this, p);
	}
	
	@Override
	default public void waitUntilContains(Object o) throws InterruptedException {
		CollectionUtils.waitUntil(CollectionUtils.computeContains(this, new HashSet<>(), o), this);
	}
	
	@Override
	default public void waitUntilContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeContains(this, new HashSet<>(), o), this, timeout, unit);
	}
	
	@Override
	default public void waitUntilContains(Object o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeContains(this, new HashSet<>(), o), this, p);
	}
	
	@Override
	default public void waitUntilNotContains(Object o) throws InterruptedException {
		CollectionUtils.waitUntil(CollectionUtils.computeNotContains(this, new HashSet<>(), o), this);
	}
	
	@Override
	default public void waitUntilNotContains(Object o, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeNotContains(this, new HashSet<>(), o), this, timeout, unit);
	}
	
	@Override
	default public void waitUntilNotContains(Object o, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeNotContains(this, new HashSet<>(), o), this, p);
	}
	
	@Override
	default public void waitUntilContainsAll(Collection<?> c) throws InterruptedException {
		CollectionUtils.waitUntil(CollectionUtils.computeContainsAll(this, new HashSet<>(), c), this);
	}
	
	@Override
	default public void waitUntilContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeContainsAll(this, new HashSet<>(), c), this, timeout, unit);
	}
	
	@Override
	default public void waitUntilContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeContainsAll(this, new HashSet<>(), c), this, p);
	}
	
	@Override
	default public void waitUntilNotContainsAll(Collection<?> c) throws InterruptedException {
		CollectionUtils.waitUntil(CollectionUtils.computeNotContainsAll(this, new HashSet<>(), c), this);
	}
	
	@Override
	default public void waitUntilNotContainsAll(Collection<?> c, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeNotContainsAll(this, new HashSet<>(), c), this, timeout, unit);
	}
	
	@Override
	default public void waitUntilNotContainsAll(Collection<?> c, TimeGettable p) throws InterruptedException, TimeoutException {
		CollectionUtils.waitUntil(CollectionUtils.computeNotContainsAll(this, new HashSet<>(), c), this, p);
	}

}
