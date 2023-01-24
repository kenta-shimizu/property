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
	
	public AbstractComparativeCompution<Number, Number> equalTo(
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
	
	private AbstractComparativeCompution<Number, Number> buildDoubleEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() == r.doubleValue());
	}
	
	public AbstractComparativeCompution<Number, Number> notEqualTo(
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
	
	private AbstractComparativeCompution<Number, Number> buildDoubleNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() != r.doubleValue());
	}
	
	public AbstractComparativeCompution<Number, Number> lessThan(
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
	
	private AbstractComparativeCompution<Number, Number> buildDoubleLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() < r.doubleValue());
	}
	
	public AbstractComparativeCompution<Number, Number> lessThanOrEqualTo(
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
	
	private AbstractComparativeCompution<Number, Number> buildDoubleLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() <= r.doubleValue());
	}
	
	public AbstractComparativeCompution<Number, Number> greaterThan(
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
	
	private AbstractComparativeCompution<Number, Number> buildDoubleGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() > r.doubleValue());
	}
	
	public AbstractComparativeCompution<Number, Number> greaterThanOrEqualTo(
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
	
	private AbstractComparativeCompution<Number, Number> buildDoubleGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() >= r.doubleValue());
	}
	
	private static final Integer ZERO = Integer.valueOf(0);
	
	private AbstractComparativeCompution<Number, Number> buildNumberComparative(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			BiPredicate<Number, Number> compute) {
		
		final AbstractComparativeCompution<Number, Number> i = new AbstractComparativeCompution<Number, Number>(compute, ZERO, ZERO) {
			
			private static final long serialVersionUID = 5610468194150491897L;
		};
		
		i.bindLeft(left);
		i.bindRight(right);
		
		return i;
	}
	
}
