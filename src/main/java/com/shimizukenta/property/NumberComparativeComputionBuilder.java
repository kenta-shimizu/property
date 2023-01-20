package com.shimizukenta.property;

import java.util.function.BiPredicate;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class NumberComparativeComputionBuilder extends AbstractComputionBuilder {
	
	private NumberComparativeComputionBuilder() {
		super();
	}
	
	private static class SingletonHolder {
		private static final NumberComparativeComputionBuilder inst = new NumberComparativeComputionBuilder();
	}
	
	public static NumberComparativeComputionBuilder getInstance() {
		return SingletonHolder.inst;
	}
	
	public ComparativeCompution equalTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( this.isDouble(left, right) ) {
			return this.buildDoubleEqualTo(left, right);
		}
		
		if ( this.isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() == r.floatValue());
		}
		
		if ( this.isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() == r.longValue());
		}
		
		if ( this.isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() == r.intValue());
		}
		
		return this.buildDoubleEqualTo(left, right);
	}
	
	private ComparativeCompution buildDoubleEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() == r.doubleValue());
	}
	
	public ComparativeCompution notEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( this.isDouble(left, right) ) {
			return this.buildDoubleNotEqualTo(left, right);
		}
		
		if ( this.isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() != r.floatValue());
		}
		
		if ( this.isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() != r.longValue());
		}
		
		if ( this.isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() != r.intValue());
		}
		
		return this.buildDoubleNotEqualTo(left, right);
	}
	
	private ComparativeCompution buildDoubleNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() != r.doubleValue());
	}
	
	public ComparativeCompution lessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( this.isDouble(left, right) ) {
			return this.buildDoubleLessThan(left, right);
		}
		
		if ( this.isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() < r.floatValue());
		}
		
		if ( this.isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() < r.longValue());
		}
		
		if ( this.isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() < r.intValue());
		}
		
		return this.buildDoubleLessThan(left, right);
	}
	
	private ComparativeCompution buildDoubleLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() < r.doubleValue());
	}
	
	public ComparativeCompution lessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( this.isDouble(left, right) ) {
			return this.buildDoubleLessThanOrEqualTo(left, right);
		}
		
		if ( this.isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() <= r.floatValue());
		}
		
		if ( this.isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() <= r.longValue());
		}
		
		if ( this.isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() <= r.intValue());
		}
		
		return this.buildDoubleLessThanOrEqualTo(left, right);
	}
	
	private ComparativeCompution buildDoubleLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() <= r.doubleValue());
	}
	
	public ComparativeCompution greaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( this.isDouble(left, right) ) {
			return this.buildDoubleGreaterThan(left, right);
		}
		
		if ( this.isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() > r.floatValue());
		}
		
		if ( this.isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() > r.longValue());
		}
		
		if ( this.isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() > r.intValue());
		}
		
		return this.buildDoubleGreaterThan(left, right);
	}
	
	private ComparativeCompution buildDoubleGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() > r.doubleValue());
	}
	
	public ComparativeCompution greaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( this.isDouble(left, right) ) {
			return this.buildDoubleGreaterThanOrEqualTo(left, right);
		}
		
		if ( this.isFloat(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.floatValue() >= r.floatValue());
		}
		
		if ( this.isLong(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.longValue() >= r.longValue());
		}
		
		if ( this.isInteger(left, right) ) {
			return buildNumberComparative(
					left, right,
					(l, r) -> l.intValue() >= r.intValue());
		}
		
		return this.buildDoubleGreaterThanOrEqualTo(left, right);
	}
	
	private ComparativeCompution buildDoubleGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() >= r.doubleValue());
	}
	
	private ComparativeCompution buildNumberComparative(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			BiPredicate<Number, Number> compute) {
		
		return new AbstractNumberComparativeCompution(left, right, compute) {

			private static final long serialVersionUID = 6239537024871859844L;
		};
	}
	
}
