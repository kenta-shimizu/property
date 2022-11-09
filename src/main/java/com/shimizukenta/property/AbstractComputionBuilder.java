package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
		return isDouble(Collections.singleton(observable));
	}
	
	protected boolean isDouble(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isDouble(Arrays.asList(a, b));
	}
	
	protected boolean isDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> {
			return (o instanceof DoubleObservable) || (o instanceof DoubleCompution);
		});
	}
	
	protected boolean isFloat(NumberObservable<? extends Number> observable) {
		return isFloat(Collections.singleton(observable));
	}
	
	protected boolean isFloat(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isFloat(Arrays.asList(a, b));
	}
	
	protected boolean isFloat(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> {
			return (o instanceof FloatObservable) || (o instanceof FloatCompution);
		});
	}
	
	protected boolean isLong(NumberObservable<? extends Number> observable) {
		return isLong(Collections.singleton(observable));
	}
	
	protected boolean isLong(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isLong(Arrays.asList(a, b));
	}
	
	protected boolean isLong(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> {
			return (o instanceof LongObservable) || (o instanceof LongCompution);
		});
	}
	
	protected boolean isInteger(NumberObservable<? extends Number> observable) {
		return isInteger(Collections.singleton(observable));
	}
	
	protected boolean isInteger(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return isInteger(Arrays.asList(a, b));
	}
	
	protected boolean isInteger(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> {
			return (o instanceof IntegerObservable) || (o instanceof IntegerCompution);
		});
	}

}
