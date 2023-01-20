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
	
	public <T, U> ComparativeCompution equalTo(
			ObjectObservable<T> a,
			ObjectObservable<U> b) {
		
		return buildObjectComparative(a, b, (aa, bb) -> Objects.equals(aa, bb));
	}
	
	public <T, U> ComparativeCompution notEqualTo(
			ObjectObservable<T> a,
			ObjectObservable<U> b) {
		
		return buildObjectComparative(a, b, (aa, bb) -> ! Objects.equals(aa, bb));
	}
	
	private <T, U> ComparativeCompution buildObjectComparative(
			ObjectObservable<T> a,
			ObjectObservable<U> b,
			BiPredicate<Object, Object> compute) {
		
		final AbstractObjectComparativeCompution<T, U> i =  new AbstractObjectComparativeCompution<T, U>(a, b, compute) {
			
			private static final long serialVersionUID = -8304155634232757312L;
		};
		
		return i;
	}
	
}
