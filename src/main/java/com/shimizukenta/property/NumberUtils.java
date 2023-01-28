package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class NumberUtils {

	private NumberUtils() {
		/* Nothing */
	}
	
	public static NumberCompution sum(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return sumDouble(c);
		}
		
		if ( isFloat(c) ) {
			
			//TODO
		}
		
		if ( isLong(c) ) {
			
			//TODO
		}
		
		if ( isInteger(c) ) {
			
			//TODO
		}
		
		return sumDouble(c);
	}
	
	private static DoubleCompution sumDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		
		//TODO
		
		return null;
	}
	
	public static NumberCompution multiply(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return multiplyDouble(c);
		}
		
		if ( isFloat(c) ) {
			
			//TODO
		}
		
		if ( isLong(c) ) {
			
			//TODO
		}
		
		if ( isInteger(c) ) {
			
			//TODO
		}
		
		return multiplyDouble(c);
	}
	
	private static DoubleCompution multiplyDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		
		//TODO
		
		return null;
	}
	
	public static NumberCompution max(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return maxDouble(c);
		}
		
		if ( isFloat(c) ) {
			
			//TODO
		}
		
		if ( isLong(c) ) {
			
			//TODO
		}
		
		if ( isInteger(c) ) {
			
			//TODO
		}
		
		return maxDouble(c);
	}
	
	private static DoubleCompution maxDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		
		//TODO
		
		return null;
	}
	
	public static NumberCompution min(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return minDouble(c);
		}
		
		if ( isFloat(c) ) {
			
			//TODO
		}
		
		if ( isLong(c) ) {
			
			//TODO
		}
		
		if ( isInteger(c) ) {
			
			//TODO
		}
		
		
		return minDouble(c);
	}
	
	private static DoubleCompution minDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		
		//TODO
		
		return null;
	}
	
	public static NumberCompution negate(NumberObservable<? extends Number> o) {
		
		final Collection<? extends NumberObservable<? extends Number>> c = Collections.singleton(o);
		
		if ( isDouble(c) ) {
			return negateDouble(o);
		}
		
		if ( isFloat(c) ) {
			
			//TODO
		}
		
		if ( isLong(c) ) {
			
			//TODO
		}
		
		if ( isInteger(c) ) {
			
			//TODO
		}
		
		return negateDouble(o);
	}
	
	private static DoubleCompution negateDouble(NumberObservable<? extends Number> o) {
		
		//TODO
		
		return null;
	}
	
	public static NumberCompution subtrate(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		final Collection<? extends NumberObservable<? extends Number>> c = Arrays.asList(a, b);
		
		if ( isDouble(c) ) {
			return subtrateDouble(a, b);
		}
		
		if ( isFloat(c) ) {
			
			//TODO
		}
		
		if ( isLong(c) ) {
			
			//TODO
		}
		
		if ( isInteger(c) ) {
			
			//TODO
		}
		
		return subtrateDouble(a, b);
	}
	
	private static DoubleCompution subtrateDouble(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		//TODO
		
		return null;
	}
	
	private static boolean isDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isDouble());
	}
	
	private static boolean isFloat(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isFloat());
	}
	
	private static boolean isLong(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isLong());
	}
	
	private static boolean isInteger(Collection<? extends NumberObservable<? extends Number>> observables) {
		return observables.stream().anyMatch(o -> o.isInteger());
	}
	
}
