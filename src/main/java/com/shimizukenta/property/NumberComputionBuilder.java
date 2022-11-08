package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class NumberComputionBuilder extends AbstractComputionBuilder {
	
	public static NumberComputionBuilder getInstance() {
		return SingletonHolder.inst;
	}
	
	private static class SingletonHolder {
		private static final NumberComputionBuilder inst = new NumberComputionBuilder();
	}
	
	private NumberComputionBuilder() {
		super();
	}
	
	public NumberCompution add(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildAddDoubleCompution(observables);
		}
		if ( isFloat(observables) ) {
			
			//TODO
		}
		if ( isLong(observables) ) {
			
			//TODO
		}
		if ( isInteger(observables) ) {
			
			//TODO
		}
		
		return buildAddDoubleCompution(observables);
	}
	
	private DoubleCompution buildAddDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		return new AbstractAddDoubleCompution(observables) {

			private static final long serialVersionUID = -5302331492985226538L;
		};
	}
	
	public NumberCompution multiply(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildMultiplyDoubleCompution(observables);
		}
		if ( isFloat(observables) ) {
			
			//TODO
		}
		if ( isLong(observables) ) {
			
			//TODO
		}
		if ( isInteger(observables) ) {
			
			//TODO
		}
		
		return buildMultiplyDoubleCompution(observables);
	}
	
	private DoubleCompution buildMultiplyDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		return new AbstractMultiplyDoubleCompution(observables) {

			private static final long serialVersionUID = -1421793079027397897L;
			
		};
	}
	
	public NumberCompution negate(NumberObservable<? extends Number> observable) {
		
		if ( isDouble(observable) ) {
			return buildNegateDoubleCompution(observable);
		}
		if ( isFloat(observable) ) {
			
			//TODO
		}
		if ( isLong(observable) ) {
			
			//TODO
		}
		if ( isInteger(observable) ) {
			
			//TODO
		}
		
		return buildNegateDoubleCompution(observable);
	}
	
	private DoubleCompution buildNegateDoubleCompution(NumberObservable<? extends Number> observable) {
		return new AbstractNegateDoubleCompution(observable) {

			private static final long serialVersionUID = -6421387028892281532L;
		};
	}
	
	public NumberCompution substract(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return add(Arrays.asList(a, negate(b)));
	}
	
	public NumberCompution max(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildMaxDoubleCompution(observables);
		}
		if ( isFloat(observables) ) {
			
			//TODO
		}
		if ( isLong(observables) ) {
			
			//TODO
		}
		if ( isInteger(observables) ) {
			
			//TODO
		}
		
		return buildMaxDoubleCompution(observables);
	}
	
	private DoubleCompution buildMaxDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		return new AbstractMaxDoubleCompution(observables) {

			private static final long serialVersionUID = 9078372399486678375L;
		};
	}
	
	public NumberCompution min(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildMinDoubleCompution(observables);
		}
		if ( isFloat(observables) ) {
			
			//TODO
		}
		if ( isLong(observables) ) {
			
			//TODO
		}
		if ( isInteger(observables) ) {
			
			//TODO
		}
		
		return buildMinDoubleCompution(observables);
	}
	
	private DoubleCompution buildMinDoubleCompution(Collection<? extends NumberObservable<? extends Number>> observables) {
		return new AbstractMinDoubleCompution(observables) {

			private static final long serialVersionUID = 5191431177016025043L;
		};
	}

}
