package com.shimizukenta.property;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class NumberComputionBuilder {
	
	public static NumberComputionBuilder getInstance() {
		return SingletonHolder.inst;
	}
	
	private static class SingletonHolder {
		private static final NumberComputionBuilder inst = new NumberComputionBuilder();
	}
	
	private NumberComputionBuilder() {
		/* Nothing */
	}
	
	public IntegerCompution toInteger(NumberObservable<? extends Number> observable) {
		return buildInteger(Collections.singleton(observable), vv -> {
			int r = 0;
			for ( Number n : vv ) {
				r = n.intValue();
			}
			return Integer.valueOf(r);
		});
	}
	
	public LongCompution toLong(NumberObservable<? extends Number> observable) {
		return buildLong(Collections.singleton(observable), vv -> {
			long r = 0L;
			for ( Number n : vv ) {
				r = n.longValue();
			}
			return Long.valueOf(r);
		});
	}
	
	public FloatCompution toFloat(NumberObservable<? extends Number> observable) {
		return buildFloat(Collections.singleton(observable), vv -> {
			float r = 0.0F;
			for ( Number n : vv ) {
				r = n.floatValue();
			}
			return Float.valueOf(r);
		});
	}
	
	public DoubleCompution toDouble(NumberObservable<? extends Number> observable) {
		return buildDouble(Collections.singleton(observable), vv -> {
			double r = 0.0D;
			for ( Number n : vv ) {
				r = n.doubleValue();
			}
			return Double.valueOf(r);
		});
	}
	
	public NumberCompution add(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildAddDouble(observables);
		}
		
		if ( isFloat(observables) ) {
			return buildFloat(observables, vv -> {
				float r = 0.0F;
				for (Number n : vv) {
					r += n.floatValue();
				}
				return Float.valueOf(r);
			});
		}
		
		if ( isLong(observables) ) {
			return buildLong(observables, vv -> {
				long r = 0L;
				for (Number n : vv) {
					r += n.longValue();
				}
				return Long.valueOf(r);
			});
		}
		
		if ( isInteger(observables) ) {
			return buildInteger(observables, vv -> {
				int r = 0;
				for (Number n : vv) {
					r += n.intValue();
				}
				return Integer.valueOf(r);
			});
		}
		
		return buildAddDouble(observables);
	}
	
	private DoubleCompution buildAddDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return buildDouble(observables, vv -> {
			double r = 0.0D;
			for (Number n : vv) {
				r += n.doubleValue();
			}
			return Double.valueOf(r);
		});
	}
	
	public NumberCompution multiply(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildMultiplyDouble(observables);
		}
		
		if ( isFloat(observables) ) {
			return buildFloat(observables, vv -> {
				float r = 1.0F;
				for (Number n : vv) {
					r *= n.floatValue();
				}
				return Float.valueOf(r);
			});
		}
		
		if ( isLong(observables) ) {
			return buildLong(observables, vv -> {
				long r = 1L;
				for (Number n : vv) {
					r *= n.longValue();
				}
				return Long.valueOf(r);
			});
		}
		
		if ( isInteger(observables) ) {
			return buildInteger(observables, vv -> {
				int r = 1;
				for (Number n : vv) {
					r *= n.intValue();
				}
				return Integer.valueOf(r);
			});
		}
		
		return buildMultiplyDouble(observables);
	}
	
	private DoubleCompution buildMultiplyDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return buildDouble(observables, vv -> {
			double r = 1.0D;
			for (Number n : vv) {
				r *= n.doubleValue();
			}
			return Double.valueOf(r);
		});
	}
	
	public NumberCompution negate(NumberObservable<? extends Number> observable) {
		
		final Collection<? extends NumberObservable<? extends Number>> observables = Collections.singleton(observable);
		
		if ( observable.isDouble() ) {
			return buildNegateDouble(observables);
		}
		
		if ( observable.isFloat() ) {
			return buildFloat(observables, vv -> {
				float r = 0.0F;
				for (Number n : vv) {
					r = - n.floatValue();
				}
				return Float.valueOf(r);
			});
		}
		
		if ( observable.isLong() ) {
			return buildLong(observables, vv -> {
				long r = 0L;
				for (Number n : vv) {
					r = - n.longValue();
				}
				return Long.valueOf(r);
			});
		}
		
		if ( observable.isInteger() ) {
			return buildInteger(observables, vv -> {
				int r = 0;
				for (Number n : vv) {
					r = - n.intValue();
				}
				return Integer.valueOf(r);
			});
		}
		
		return buildNegateDouble(observables);
	}
	
	private DoubleCompution buildNegateDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return buildDouble(observables, vv -> {
			double r = 0.0D;
			for (Number n : vv) {
				r = - n.doubleValue();
			}
			return Double.valueOf(r);
		});
	}
	
	public NumberCompution substract(
			NumberObservable<? extends Number> a,
			NumberObservable<? extends Number> b) {
		
		return add(Arrays.asList(a, negate(b)));
	}
	
	public NumberCompution max(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildMaxDouble(observables);
		}
		
		if ( isFloat(observables) ) {
			return buildFloat(observables, vv -> {
				float r = Float.NEGATIVE_INFINITY;
				for (Number n : vv) {
					float v = n.floatValue();
					if ( v > r ) {
						r = v;
					}
				}
				return Float.valueOf(r);
			});
		}
		
		if ( isLong(observables) ) {
			return buildLong(observables, vv -> {
				long r = Long.MIN_VALUE;
				for (Number n : vv) {
					long v = n.longValue();
					if ( v > r ) {
						r = v;
					}
				}
				return Long.valueOf(r);
			});
		}
		
		if ( isInteger(observables) ) {
			return buildInteger(observables, vv -> {
				int r = Integer.MIN_VALUE;
				for (Number n : vv) {
					int v = n.intValue();
					if ( v > r ) {
						r = v;
					}
				}
				return Integer.valueOf(r);
			});
		}
		
		return buildMaxDouble(observables);
	}
	
	private DoubleCompution buildMaxDouble(Collection<? extends NumberObservable<? extends Number>> observables) {
		return buildDouble(observables, vv -> {
			double r = Double.NEGATIVE_INFINITY;
			for (Number n : vv) {
				double v = n.doubleValue();
				if ( v > r ) {
					r = v;
				}
			}
			return Double.valueOf(r);
		});
	}
	
	public NumberCompution min(Collection<? extends NumberObservable<? extends Number>> observables) {
		
		if ( isDouble(observables) ) {
			return buildMinDouble(observables);
		}
		
		if ( isFloat(observables) ) {
			return buildFloat(observables, vv -> {
				float r = Float.POSITIVE_INFINITY;
				for (Number n : vv) {
					float v = n.floatValue();
					if ( v < r ) {
						r = v;
					}
				}
				return Float.valueOf(r);
			});
		}
		
		if ( isLong(observables) ) {
			return buildLong(observables, vv -> {
				long r = Long.MAX_VALUE;
				for (Number n : vv) {
					long v = n.longValue();
					if ( v < r ) {
						r = v;
					}
				}
				return Long.valueOf(r);
			});
		}
		
		if ( isInteger(observables) ) {
			return buildInteger(observables, vv -> {
				int r = Integer.MAX_VALUE;
				for (Number n : vv) {
					int v = n.intValue();
					if ( v < r ) {
						r = v;
					}
				}
				return Integer.valueOf(r);
			});
		}
		
		return buildMinDouble(observables);
	}
	
	private DoubleCompution buildMinDouble(
			Collection<? extends NumberObservable<? extends Number>> observables) {
		
		return buildDouble(observables, vv -> {
			double r = Double.POSITIVE_INFINITY;
			for (Number n : vv) {
				double v = n.doubleValue();
				if ( v < r ) {
					r = v;
				}
			}
			return Double.valueOf(r);
		});
	}
	
	private DoubleCompution buildDouble(
			Collection<? extends NumberObservable<? extends Number>> observables,
			Function<List<? extends Number>, Double> compute) {
		
		return new AbstractDoubleCompution(observables, compute) {

			private static final long serialVersionUID = 803445995478588497L;
			
		};
	}
	
	private FloatCompution buildFloat(
			Collection<? extends NumberObservable<? extends Number>> observables,
			Function<List<? extends Number>, Float> compute) {
		
		return new AbstractFloatCompution(observables, compute) {
			
			private static final long serialVersionUID = 803445995478588497L;
		};
	}
	
	private LongCompution buildLong(
			Collection<? extends NumberObservable<? extends Number>> observables,
			Function<List<? extends Number>, Long> compute) {
		
		return new AbstractLongCompution(observables, compute) {
			
			private static final long serialVersionUID = -745885808746970569L;
		};
	}
	
	private IntegerCompution buildInteger(
			Collection<? extends NumberObservable<? extends Number>> observables,
			Function<List<? extends Number>, Integer> compute) {
		
		return new AbstractIntegerCompution(observables, compute) {
			
			private static final long serialVersionUID = 3175580553554522461L;
		};
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
