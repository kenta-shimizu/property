package com.shimizukenta.property;

import java.util.Arrays;
import java.util.function.BiPredicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class NumericComparativeComputionBuilder {
	
	private NumericComparativeComputionBuilder() {
		/* Nothing */
	}
	
	private static class SingletonHolder {
		private static final NumericComparativeComputionBuilder inst = new NumericComparativeComputionBuilder();
	}
	
	public static NumericComparativeComputionBuilder getInstance() {
		return SingletonHolder.inst;
	}
	
	public AbstractBiPredicateCompution<Number, Number> equalTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return this.buildDoubleEqualTo(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() == r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() == r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() == r.intValue());
		}
		
		return this.buildDoubleEqualTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildDoubleEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() == r.doubleValue());
	}
	
	public AbstractBiPredicateCompution<Number, Number> notEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return this.buildDoubleNotEqualTo(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() != r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() != r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() != r.intValue());
		}
		
		return this.buildDoubleNotEqualTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildDoubleNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() != r.doubleValue());
	}
	
	public AbstractBiPredicateCompution<Number, Number> lessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return this.buildDoubleLessThan(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() < r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() < r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() < r.intValue());
		}
		
		return this.buildDoubleLessThan(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildDoubleLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() < r.doubleValue());
	}
	
	public AbstractBiPredicateCompution<Number, Number> lessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return this.buildDoubleLessThanOrEqualTo(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() <= r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() <= r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() <= r.intValue());
		}
		
		return this.buildDoubleLessThanOrEqualTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildDoubleLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() <= r.doubleValue());
	}
	
	public AbstractBiPredicateCompution<Number, Number> greaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return this.buildDoubleGreaterThan(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() > r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() > r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() > r.intValue());
		}
		
		return this.buildDoubleGreaterThan(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildDoubleGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() > r.doubleValue());
	}
	
	public AbstractBiPredicateCompution<Number, Number> greaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return this.buildDoubleGreaterThanOrEqualTo(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() >= r.floatValue());
		}
		
		if ( isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() >= r.longValue());
		}
		
		if ( isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() >= r.intValue());
		}
		
		return this.buildDoubleGreaterThanOrEqualTo(left, right);
	}
	
	private AbstractBiPredicateCompution<Number, Number> buildDoubleGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() >= r.doubleValue());
	}
	
	private static final Integer ZERO = Integer.valueOf(0);
	
	private AbstractBiPredicateCompution<Number, Number> buildNumberComparative(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			BiPredicate<Number, Number> compute) {
		
		final AbstractBiPredicateCompution<Number, Number> i = new AbstractBiPredicateCompution<Number, Number>(compute, ZERO, ZERO) {
			
			private static final long serialVersionUID = 5610468194150491897L;
		};
		
		i.bindLeft(left);
		i.bindRight(right);
		
		return i;
	}
	
	private static  boolean isDouble(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return Arrays.asList(a, b).stream().anyMatch(o -> o.isDouble());
	}
	
	private static boolean isFloat(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return Arrays.asList(a, b).stream().anyMatch(o -> o.isFloat());
	}
	
	private static boolean isLong(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return Arrays.asList(a, b).stream().anyMatch(o -> o.isLong());
	}
	
	private static boolean isInteger(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return Arrays.asList(a, b).stream().anyMatch(o -> o.isInteger());
	}
	
}
