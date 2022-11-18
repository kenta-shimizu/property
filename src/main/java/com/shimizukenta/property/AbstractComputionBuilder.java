package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractComputionBuilder {

	protected AbstractComputionBuilder() {
		/* Nothing */
	}
	
	protected boolean isDouble(NumberObservable<? extends Number> observable) {
		return observable.isDouble();
	}
	
	protected boolean isDouble(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isDouble(Arrays.asList(a, b));
	}
	
	protected boolean isDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isDouble());
	}
	
	protected boolean isFloat(NumberObservable<? extends Number> observable) {
		return observable.isFloat();
	}
	
	protected boolean isFloat(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isFloat(Arrays.asList(a, b));
	}
	
	protected boolean isFloat(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isFloat());
	}
	
	protected boolean isLong(NumberObservable<? extends Number> observable) {
		return observable.isLong();
	}
	
	protected boolean isLong(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isLong(Arrays.asList(a, b));
	}
	
	protected boolean isLong(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isLong());
	}
	
	protected boolean isInteger(NumberObservable<? extends Number> observable) {
		return observable.isInteger();
	}
	
	protected boolean isInteger(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isInteger(Arrays.asList(a, b));
	}
	
	protected boolean isInteger(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isInteger());
	}
	
}
