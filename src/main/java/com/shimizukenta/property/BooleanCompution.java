package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface BooleanCompution extends Compution<Boolean, BooleanSettable>, BooleanGettable, BooleanObservable {
	
	public static BooleanCompution and(BooleanObservable... observables) {
		return and(Arrays.asList(observables));
	}
	
	public static BooleanCompution and(Collection<? extends BooleanObservable> observables) {
		return new AbstractAndBooleanCompution(observables) {
			
			private static final long serialVersionUID = 7267460580158670298L;
		};
	}
	
	public static BooleanCompution or(BooleanObservable... observables) {
		return or(Arrays.asList(observables));
	}
	
	public static BooleanCompution or(Collection<? extends BooleanObservable> observables) {
		return new AbstractOrBooleanCompution(observables) {
			
			private static final long serialVersionUID = 6296068890114364016L;
		};
	}
	
	public static BooleanCompution not(BooleanObservable observables) {
		return new AbstractNotBooleanCompution(observables) {
			
			private static final long serialVersionUID = -5546414119644980854L;
		};
	}
	
	public static BooleanCompution xor(BooleanObservable a, BooleanObservable b) {
		return new AbstractXorBooleanCompution(a, b) {
			
			private static final long serialVersionUID = -6464964256437884007L;
		};
	}
	
	public static BooleanCompution nand(BooleanObservable... observables) {
		return not(and(observables));
	}
	
	public static BooleanCompution nand(Collection<? extends BooleanObservable> observables) {
		return not(and(observables));
	}
	
	public static BooleanCompution nor(BooleanObservable... observables) {
		return not(or(observables));
	}
	
	public static BooleanCompution nor(Collection<? extends BooleanObservable> observables) {
		return not(or(observables));
	}
	
	//TODO
	//equalto
	//notequalTo
	//lessThan
	//lessThanOrEqualTo
	//greaterThan
	//greaterThanOrEqualTo
	
}
