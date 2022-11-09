package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LogicalComputionBuilder extends AbstractComputionBuilder {
	
	public static LogicalComputionBuilder getInstance() {
		return SingletonHolder.inst;
	}
	
	private static class SingletonHolder {
		private static final LogicalComputionBuilder inst = new LogicalComputionBuilder();
	}
	
	private LogicalComputionBuilder() {
		super();
	}
	
	public LogicalCompution and(BooleanObservable... observables) {
		return and(Arrays.asList(observables));
	}
	
	public LogicalCompution and(Collection<? extends BooleanObservable> observables) {
		return buildLogical(observables, vv -> {
			return vv.stream().allMatch(Boolean::booleanValue);
		});
	}
	
	public LogicalCompution or(BooleanObservable... observables) {
		return or(Arrays.asList(observables));
	}
	
	public LogicalCompution or(Collection<? extends BooleanObservable> observables) {
		return buildLogical(observables, vv -> {
			return vv.stream().anyMatch(Boolean::booleanValue);
		});
	}
	
	public LogicalCompution not(BooleanObservable observable) {
		return buildLogical(
				Collections.singleton(observable),
				vv -> (! vv.get(0).booleanValue()));
	}
	
	public LogicalCompution xor(BooleanObservable a, BooleanObservable b) {
		return buildLogical(
				Arrays.asList(a, b),
				vv -> (vv.get(0).booleanValue() ^ vv.get(1).booleanValue()));
	}
	
	public LogicalCompution nand(BooleanObservable... observables) {
		return not(and(observables));
	}
	
	public LogicalCompution nand(Collection<? extends BooleanObservable> observables) {
		return not(and(observables));
	}
	
	public LogicalCompution nor(Collection<? extends BooleanObservable> observables) {
		return not(or(observables));
	}
	
	public LogicalCompution nor(BooleanObservable... observables) {
		return not(or(observables));
	}
	
	private LogicalCompution buildLogical(
			Collection<? extends BooleanObservable> observables,
			Predicate<? super List<? extends Boolean>> compute
			) {
		
		return new AbstractLogicalCompution(observables, compute) {
			
			private static final long serialVersionUID = -8470691097922793792L;
		};
	}
	
}
