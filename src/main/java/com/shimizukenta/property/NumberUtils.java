package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberUtils {

	private NumberUtils() {
		/* Nothing */
	}
	
	
	private static boolean isDouble(NumberObservable<? extends Number> observer) {
		return observer.isDouble();
	}
	
	private static boolean isDouble(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return a.isDouble() || b.isDouble();
	}
	
	private static boolean isDouble(Collection<? extends NumberObservable<? extends Number>> observers) {
		return observers.stream().anyMatch(o -> o.isDouble());
	}
	
	private static boolean isFloat(NumberObservable<? extends Number> observer) {
		return observer.isFloat();
	}
	
	private static boolean isFloat(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return a.isFloat() || b.isFloat();
	}
	
	private static boolean isFloat(Collection<? extends NumberObservable<? extends Number>> observers) {
		return observers.stream().anyMatch(o -> o.isFloat());
	}
	
	private static boolean isLong(NumberObservable<? extends Number> observer) {
		return observer.isLong();
	}
	
	private static boolean isLong(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return a.isLong() || b.isLong();
	}
	
	private static boolean isLong(Collection<? extends NumberObservable<? extends Number>> observers) {
		return observers.stream().anyMatch(o -> o.isLong());
	}
	
	private static boolean isInteger(NumberObservable<? extends Number> observer) {
		return observer.isInteger();
	}
	
	private static boolean isInteger(NumberObservable<? extends Number> a, NumberObservable<? extends Number> b) {
		return a.isInteger() || b.isInteger();
	}
	
	private static boolean isInteger(Collection<? extends NumberObservable<? extends Number>> observers) {
		return observers.stream().anyMatch(o -> o.isInteger());
	}
	
	public static AbstractUnmodifiableIntegerProperty unmodifiableInteger(int v) {
		return new AbstractUnmodifiableIntegerProperty(v) {
			
			private static final long serialVersionUID = 2763128385052210963L;
		};
	}
	
	public static AbstractUnmodifiableLongProperty unmodifiableLong(long v) {
		return new AbstractUnmodifiableLongProperty(v) {
			
			private static final long serialVersionUID = -4322447626845819876L;
			
		};
	}
	
	public static AbstractUnmodifiableFloatProperty unmodifiableFloat(float v) {
		return new AbstractUnmodifiableFloatProperty(v) {
			
			private static final long serialVersionUID = -5717571651965795638L;
		};
	}
	
	public static AbstractUnmodifiableDoubleProperty unmodifiableDouble(double v) {
		return new AbstractUnmodifiableDoubleProperty(v) {
			
			private static final long serialVersionUID = -7632858837733284592L;
		};
	}
	
	private static AbstractUnmodifiableIntegerProperty UNMOD_ZERO = unmodifiableInteger(0);
	
	public static AbstractUnmodifiableIntegerProperty getUnmodifiableZero() {
		return UNMOD_ZERO;
	}
	
	public static AbstractIntegerCompution toInteger(NumberObservable<? extends Number> o) {
		return new InnerMonoInteger(n -> Integer.valueOf(n.intValue()), o);
	}
	
	public static AbstractLongCompution toLong(NumberObservable<? extends Number> o) {
		return new InnerMonoLong(n -> Long.valueOf(n.longValue()), o);
	}
	
	public static AbstractFloatCompution toFloat(NumberObservable<? extends Number> o) {
		return new InnerMonoFloat(n -> Float.valueOf(n.floatValue()), o);
	}
	
	public static AbstractDoubleCompution toDouble(NumberObservable<? extends Number> o) {
		return new InnerMonoDouble(n -> Double.valueOf(n.doubleValue()), o);
	}
	
	
	public static AbstractNumberCompution sum(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return sumDouble(c);
		}
		
		if ( isFloat(c) ) {
			return new InnerCollectionFloat(
					nn -> {
						float v = 0.0F;
						for ( Number n : nn ) {
							v += n.floatValue();
						}
						return Float.valueOf(v);
					}, c);
		}
		
		if ( isLong(c) ) {
			return new InnerCollectionLong(
					nn -> {
						long v = 0L;
						for ( Number n : nn ) {
							v += n.longValue();
						}
						return Long.valueOf(v);
					}, c);
		}
		
		if ( isInteger(c) ) {
			return new InnerCollectionInteger(
					nn -> {
						int v = 0;
						for ( Number n : nn ) {
							v += n.intValue();
						}
						return Integer.valueOf(v);
					}, c);
		}
		
		return sumDouble(c);
	}
	
	private static AbstractDoubleCompution sumDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		return new InnerCollectionDouble(
				nn -> {
					double v = 0.0D;
					for ( Number n : nn ) {
						v += n.doubleValue();
					}
					return Double.valueOf(v);
				}, c);
	}
	
	public static AbstractNumberCompution multiply(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return multiplyDouble(c);
		}
		
		if ( isFloat(c) ) {
			return new InnerCollectionFloat(
					nn -> {
						float v = 1.0F;
						for ( Number n : nn ) {
							v *= n.floatValue();
						}
						return Float.valueOf(v);
					}, c);
		}
		
		if ( isLong(c) ) {
			return new InnerCollectionLong(
					nn -> {
						long v = 1L;
						for ( Number n : nn ) {
							v *= n.longValue();
						}
						return Long.valueOf(v);
					}, c);
		}
		
		if ( isInteger(c) ) {
			return new InnerCollectionInteger(
					nn -> {
						int v = 1;
						for ( Number n : nn ) {
							v *= n.intValue();
						}
						return Integer.valueOf(v);
					}, c);
		}
		
		return multiplyDouble(c);
	}
	
	private static AbstractDoubleCompution multiplyDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		return new InnerCollectionDouble(
				nn -> {
					double v = 1.0D;
					for ( Number n : nn ) {
						v *= n.doubleValue();
					}
					return Double.valueOf(v);
				}, c);
	}
	
	
	public static AbstractNumberCompution max(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return maxDouble(c);
		}
		
		if ( isFloat(c) ) {
			return new InnerCollectionFloat(
					nn -> {
						float v = Float.MIN_VALUE;
						for ( Number n : nn ) {
							float x = n.floatValue();
							if ( x > v ) {
								v = x;
							}
						}
						return Float.valueOf(v);
					}, c);
		}
		
		if ( isLong(c) ) {
			return new InnerCollectionLong(
					nn -> {
						long v = Long.MIN_VALUE;
						for ( Number n : nn ) {
							long x = n.longValue();
							if ( x > v ) {
								v = x;
							}
						}
						return Long.valueOf(v);
					}, c);
		}
		
		if ( isInteger(c) ) {
			return new InnerCollectionInteger(
					nn -> {
						int v = Integer.MIN_VALUE;
						for ( Number n : nn ) {
							int x = n.intValue();
							if ( x > v ) {
								v = x;
							}
						}
						return Integer.valueOf(v);
					}, c);
		}
		
		return maxDouble(c);
	}
	
	private static AbstractDoubleCompution maxDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		return new InnerCollectionDouble(
				nn -> {
					double v = Double.MIN_VALUE;
					for ( Number n : nn ) {
						double x = n.doubleValue();
						if ( x > v ) {
							v = x;
						}
					}
					return Double.valueOf(v);
				}, c);
	}
	
	
	public static AbstractNumberCompution min(Collection<? extends NumberObservable<? extends Number>> c) {
		
		if ( isDouble(c) ) {
			return minDouble(c);
		}
		
		if ( isFloat(c) ) {
			return new InnerCollectionFloat(
					nn -> {
						float v = Float.MAX_VALUE;
						for ( Number n : nn ) {
							float x = n.floatValue();
							if ( x < v ) {
								v = x;
							}
						}
						return Float.valueOf(v);
					}, c);
		}
		
		if ( isLong(c) ) {
			return new InnerCollectionLong(
					nn -> {
						long v = Long.MAX_VALUE;
						for ( Number n : nn ) {
							long x = n.longValue();
							if ( x < v ) {
								v = x;
							}
						}
						return Long.valueOf(v);
					}, c);
		}
		
		if ( isInteger(c) ) {
			return new InnerCollectionInteger(
					nn -> {
						int v = Integer.MAX_VALUE;
						for ( Number n : nn ) {
							int x = n.intValue();
							if ( x < v ) {
								v = x;
							}
						}
						return Integer.valueOf(v);
					}, c);
		}
		
		
		return minDouble(c);
	}
	
	private static AbstractDoubleCompution minDouble(Collection<? extends NumberObservable<? extends Number>> c) {
		return new InnerCollectionDouble(
				nn -> {
					double v = Double.MAX_VALUE;
					for ( Number n : nn ) {
						double x = n.doubleValue();
						if ( x < v ) {
							v = x;
						}
					}
					return Double.valueOf(v);
				}, c);
	}
	
	
	public static AbstractNumberCompution negate(NumberObservable<? extends Number> o) {
		
		if ( isDouble(o) ) {
			return negateDouble(o);
		}
		
		if ( isFloat(o) ) {
			return new InnerMonoFloat(n -> Float.valueOf(- n.floatValue()), o);
		}
		
		if ( isLong(o) ) {
			return new InnerMonoLong(n -> Long.valueOf(- n.longValue()), o);
		}
		
		if ( isInteger(o) ) {
			return new InnerMonoInteger(n -> Integer.valueOf(- n.intValue()), o);
		}
		
		return negateDouble(o);
	}
	
	private static AbstractDoubleCompution negateDouble(NumberObservable<? extends Number> o) {
		return new InnerMonoDouble(n -> Double.valueOf(- n.doubleValue()), o);
	}
	
	public static NumberCompution subtrate(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return subtrateDouble(left, right);
		}
		
		if ( isFloat(left, right) ) {
			return new InnerBiFloat((l, r) -> Float.valueOf(l.floatValue() - r.floatValue()), left, right);
		}
		
		if ( isLong(left, right) ) {
			return new InnerBiLong((l, r) -> Long.valueOf(l.longValue() - r.longValue()), left, right);
		}
		
		if ( isInteger(left, right) ) {
			return new InnerBiInteger((l, r) -> Integer.valueOf(l.intValue() - r.intValue()), left, right);
		}
		
		return subtrateDouble(left, right);
	}
	
	private static AbstractDoubleCompution subtrateDouble(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return new InnerBiDouble((l, r) -> Double.valueOf(l.doubleValue() - r.doubleValue()), left, right);
	}
	
	
	private static class InnerMonoDouble extends AbstractDoubleCompution {
		
		private static final long serialVersionUID = 618814770456239140L;
		
		public InnerMonoDouble(
				Function<? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> o) {
			
			super();
			
			o.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(compute.apply(n));
				}
			});
		}
	}
	
	private static class InnerBiDouble extends AbstractDoubleCompution {
		
		private static final long serialVersionUID = 5910278463014712219L;
		
		private Number ll;
		private Number rr;
		
		public InnerBiDouble(
				BiFunction<? super Number, ? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> left,
				NumberObservable<? extends Number> right) {
			
			super();
			
			this.ll = Integer.valueOf(0);
			this.rr = Integer.valueOf(0);
			
			left.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.ll = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
			right.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.rr = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
		}
	}
	
	private static class InnerCollectionDouble extends AbstractDoubleCompution {
		
		private static final long serialVersionUID = -7357880935855506552L;
		
		private final Collection<Inner> ii = new ArrayList<>();
		private final Function<? super Collection<? extends Number>, ? extends Number> compute;
		
		public InnerCollectionDouble(
				Function<? super Collection<? extends Number>, ? extends Number> compute,
				Collection<? extends NumberObservable<? extends Number>> c) {
			
			super();
			
			this.compute = compute;
			
			c.forEach(o -> {
				final Inner i = new Inner();
				ii.add(i);
				o.addChangeListener(i);
			});
		}
		
		private class Inner implements ChangeListener<Number> {
			
			private Number last;
			
			public Inner() {
				this.last = Integer.valueOf(0);
			}
			
			@Override
			public void changed(Number n) {
				synchronized ( InnerCollectionDouble.this._sync ) {
					this.last = n;
					InnerCollectionDouble.this._syncSetAndNotifyChanged(
						InnerCollectionDouble.this.compute.apply(
								InnerCollectionDouble.this.ii.stream()
								.map(x -> x.last)
								.collect(Collectors.toList())));
				}
			}
		}
	}
	
	private static class InnerMonoFloat extends AbstractFloatCompution {
		
		private static final long serialVersionUID = 5644463084688658066L;
		
		public InnerMonoFloat(
				Function<? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> o) {
			
			super();
			
			o.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(compute.apply(n));
				}
			});
		}
	}
	
	private static class InnerBiFloat extends AbstractFloatCompution {
		
		private static final long serialVersionUID = -7588697025601206572L;
		
		private Number ll;
		private Number rr;
		
		public InnerBiFloat(
				BiFunction<? super Number, ? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> left,
				NumberObservable<? extends Number> right) {
			
			super();
			
			this.ll = Integer.valueOf(0);
			this.rr = Integer.valueOf(0);
			
			left.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.ll = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
			right.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.rr = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
		}
	}
	
	private static class InnerCollectionFloat extends AbstractFloatCompution {
		
		private static final long serialVersionUID = 1501050646643232885L;
		
		private final Collection<Inner> ii = new ArrayList<>();
		private final Function<? super Collection<? extends Number>, ? extends Number> compute;
		
		public InnerCollectionFloat(
				Function<? super Collection<? extends Number>, ? extends Number> compute,
				Collection<? extends NumberObservable<? extends Number>> c) {
			
			super();
			
			this.compute = compute;
			
			c.forEach(o -> {
				final Inner i = new Inner();
				ii.add(i);
				o.addChangeListener(i);
			});
		}
		
		private class Inner implements ChangeListener<Number> {
			
			private Number last;
			
			public Inner() {
				this.last = Integer.valueOf(0);
			}
			
			@Override
			public void changed(Number n) {
				synchronized ( InnerCollectionFloat.this._sync ) {
					this.last = n;
					InnerCollectionFloat.this._syncSetAndNotifyChanged(
						InnerCollectionFloat.this.compute.apply(
								InnerCollectionFloat.this.ii.stream()
								.map(x -> x.last)
								.collect(Collectors.toList())));
				}
			}
		}
	}
	
	private static class InnerMonoLong extends AbstractLongCompution {
		
		private static final long serialVersionUID = -4415969225922324642L;
		
		public InnerMonoLong(
				Function<? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> o) {
			
			super();
			
			o.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(compute.apply(n));
				}
			});
		}
	}
	
	private static class InnerBiLong extends AbstractLongCompution {
		
		private static final long serialVersionUID = -6906142855226203986L;
		
		private Number ll;
		private Number rr;
		
		public InnerBiLong(
				BiFunction<? super Number, ? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> left,
				NumberObservable<? extends Number> right) {
			
			super();
			
			this.ll = Integer.valueOf(0);
			this.rr = Integer.valueOf(0);
			
			left.addChangeListener(n -> {
				synchronized  ( this._sync ) {
					this.ll = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
			right.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.rr = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
		}
	}
	
	private static class InnerCollectionLong extends AbstractLongCompution {
		
		private static final long serialVersionUID = -8190167768164461682L;
		
		private final Collection<Inner> ii = new ArrayList<>();
		private final Function<? super Collection<? extends Number>, ? extends Number> compute;
		
		public InnerCollectionLong(
				Function<? super Collection<? extends Number>, ? extends Number> compute,
				Collection<? extends NumberObservable<? extends Number>> c) {
			
			super();
			
			this.compute = compute;
			
			c.forEach(o -> {
				final Inner i = new Inner();
				ii.add(i);
				o.addChangeListener(i);
			});
		}
		
		private class Inner implements ChangeListener<Number> {
			
			private Number last;
			
			public Inner() {
				this.last = Integer.valueOf(0);
			}
			
			@Override
			public void changed(Number n) {
				synchronized ( InnerCollectionLong.this._sync ) {
					this.last = n;
					InnerCollectionLong.this._syncSetAndNotifyChanged(
						InnerCollectionLong.this.compute.apply(
								InnerCollectionLong.this.ii.stream()
								.map(x -> x.last)
								.collect(Collectors.toList())));
				}
			}
		}
	}
	
	private static class InnerMonoInteger extends AbstractIntegerCompution {
		
		private static final long serialVersionUID = 6378002639155298062L;
		
		public InnerMonoInteger(
				Function<? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> o) {
			
			super();
			
			o.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(compute.apply(n));
				}
			});
		}
	}
	
	private static class InnerBiInteger extends AbstractIntegerCompution {
		
		private static final long serialVersionUID = 4682522814212682485L;
		
		private Number ll;
		private Number rr;
		
		public InnerBiInteger(
				BiFunction<? super Number, ? super Number, ? extends Number> compute,
				NumberObservable<? extends Number> left,
				NumberObservable<? extends Number> right) {
			
			super();
			
			this.ll = Integer.valueOf(0);
			this.rr = Integer.valueOf(0);
			
			left.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.ll = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
			right.addChangeListener(n -> {
				synchronized ( this._sync ) {
					this.rr = n;
					this._syncSetAndNotifyChanged(compute.apply(this.ll, this.rr));
				}
			});
			
		}
	}
	
	private static class InnerCollectionInteger extends AbstractIntegerCompution {
		
		private static final long serialVersionUID = 668196625823765702L;
		
		private final Collection<Inner> ii = new ArrayList<>();
		private final Function<? super Collection<? extends Number>, ? extends Number> compute;
		
		public InnerCollectionInteger(
				Function<? super Collection<? extends Number>, ? extends Number> compute,
				Collection<? extends NumberObservable<? extends Number>> c) {
			
			super();
			
			this.compute = compute;
			
			c.forEach(o -> {
				final Inner i = new Inner();
				ii.add(i);
				o.addChangeListener(i);
			});
		}
		
		private class Inner implements ChangeListener<Number> {
			
			private Number last;
			
			public Inner() {
				this.last = Integer.valueOf(0);
			}
			
			@Override
			public void changed(Number n) {
				synchronized ( InnerCollectionInteger.this._sync ) {
					this.last = n;
					InnerCollectionInteger.this._syncSetAndNotifyChanged(
						InnerCollectionInteger.this.compute.apply(
								InnerCollectionInteger.this.ii.stream()
								.map(x -> x.last)
								.collect(Collectors.toList())));
				}
			}
		}
	}
	
	
	public static AbstractBiPredicateCompution<Number, Number> isEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildDoubleIsEqualTo(left, right);
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
		
		return buildDoubleIsEqualTo(left, right);
	}
	
	private static AbstractBiPredicateCompution<Number, Number> buildDoubleIsEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() == r.doubleValue());
	}
	
	public static AbstractBiPredicateCompution<Number, Number> isNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildDoubleIsNotEqualTo(left, right);
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
		
		return buildDoubleIsNotEqualTo(left, right);
	}
	
	private static AbstractBiPredicateCompution<Number, Number> buildDoubleIsNotEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() != r.doubleValue());
	}
	
	public static AbstractBiPredicateCompution<Number, Number> isLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildDoubleIaLessThan(left, right);
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
		
		return buildDoubleIaLessThan(left, right);
	}
	
	private static AbstractBiPredicateCompution<Number, Number> buildDoubleIaLessThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() < r.doubleValue());
	}
	
	public static AbstractBiPredicateCompution<Number, Number> isLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildDoubleIsLessThanOrEqualTo(left, right);
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
		
		return buildDoubleIsLessThanOrEqualTo(left, right);
	}
	
	private static AbstractBiPredicateCompution<Number, Number> buildDoubleIsLessThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() <= r.doubleValue());
	}
	
	public static AbstractBiPredicateCompution<Number, Number> isGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildDoubleIsGreaterThan(left, right);
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
		
		return buildDoubleIsGreaterThan(left, right);
	}
	
	private static AbstractBiPredicateCompution<Number, Number> buildDoubleIsGreaterThan(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() > r.doubleValue());
	}
	
	public static AbstractBiPredicateCompution<Number, Number> isGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		if ( isDouble(left, right) ) {
			return buildDoubleIsGreaterThanOrEqualTo(left, right);
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
		
		return buildDoubleIsGreaterThanOrEqualTo(left, right);
	}
	
	private static AbstractBiPredicateCompution<Number, Number> buildDoubleIsGreaterThanOrEqualTo(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) {
		
		return buildNumberComparative(
				left, right,
				(l, r) -> l.doubleValue() >= r.doubleValue());
	}
	
	private static final Integer ZERO = Integer.valueOf(0);
	
	private static AbstractBiPredicateCompution<Number, Number> buildNumberComparative(
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			BiPredicate<Number, Number> compute) {
		
		final AbstractBiPredicateCompution<Number, Number> i = new AbstractBiPredicateCompution<Number, Number>(compute, ZERO, ZERO) {
			
			private static final long serialVersionUID = 6840864360085285080L;
		};
		
		i.bindLeft(left);
		i.bindRight(right);
		
		return i;
	}
	
	public static void waitUntil(
			AbstractBiPredicateCompution<Number, Number> i,
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right) throws InterruptedException {
		
		try {
			i.waitUntilTrue();
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	public static void waitUntil(
			AbstractBiPredicateCompution<Number, Number> i,
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(timeout, unit);
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	public static void waitUntil(
			AbstractBiPredicateCompution<Number, Number> i,
			NumberObservable<? extends Number> left,
			NumberObservable<? extends Number> right,
			TimeGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
}
