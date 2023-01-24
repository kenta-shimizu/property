package com.shimizukenta.property;

import java.util.Objects;
import java.util.function.BiPredicate;

public class ObjectComparativeComputionBuilder extends AbstractComputionBuilder {

	private ObjectComparativeComputionBuilder() {
		super();
	}
	
	private static class SingletonHolder {
		private static final ObjectComparativeComputionBuilder inst = new ObjectComparativeComputionBuilder();
	}
	
	public static ObjectComparativeComputionBuilder getInstance() {
		return SingletonHolder.inst;
	}
	
	public <T, U> AbstractComparativeCompution<T, U> equalTo(
			ObjectObservable<T> a,
			ObjectObservable<U> b) {
		
		return buildObjectComparative(a, b, (aa, bb) -> Objects.equals(aa, bb));
	}
	
	public <T, U> AbstractComparativeCompution<T, U> notEqualTo(
			ObjectObservable<T> a,
			ObjectObservable<U> b) {
		
		return buildObjectComparative(a, b, (aa, bb) -> (! Objects.equals(aa, bb)));
	}
	
	private <T, U> AbstractComparativeCompution<T, U> buildObjectComparative(
			ObjectObservable<T> left,
			ObjectObservable<U> right,
			BiPredicate<Object, Object> compute) {
		
		final AbstractComparativeCompution<T, U> i =  new AbstractComparativeCompution<T, U>(compute) {

			private static final long serialVersionUID = -156911330079558280L;
		};
		
		i.bindLeft(left);
		i.bindRight(right);
		
		return i;
	}
	
}
