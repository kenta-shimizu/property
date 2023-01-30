package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class BooleanUtils {
	
	private BooleanUtils() {
		/* Nothing */
	}
	
	private static AbstractUnmodifiableBooleanProperty buildUnmodifiableBoolean(boolean f) {
		return new AbstractUnmodifiableBooleanProperty(f) {
			
			private static final long serialVersionUID = 715033907568380106L;
		};
	}
	
	private static final AbstractUnmodifiableBooleanProperty UNMOD_FALSE = buildUnmodifiableBoolean(false);
	private static final AbstractUnmodifiableBooleanProperty UNMOD_TRUE = buildUnmodifiableBoolean(true);
	
	public static AbstractUnmodifiableBooleanProperty getUnmodifiableFalse() {
		return UNMOD_FALSE;
	}
	
	public static AbstractUnmodifiableBooleanProperty getUnmodifiableTrue() {
		return UNMOD_TRUE;
	}
	
	public static AbstractUnmodifiableBooleanProperty getUnmodifiableBoolean(boolean f) {
		if ( f ) {
			return getUnmodifiableTrue();
		} else {
			return getUnmodifiableFalse();
		}
	}
	
	public static AbstractLogicalCompution and(Collection<? extends BooleanObservable> observers) {
		return new InnerCollection(observers, c -> c.stream().allMatch(Boolean::booleanValue));
	}
	
	public static AbstractLogicalCompution or(Collection<? extends BooleanObservable> observers) {
		return new InnerCollection(observers, c -> c.stream().anyMatch(Boolean::booleanValue));
	}
	
	public static AbstractLogicalCompution not(BooleanObservable observer) {
		return new InnerMono(observer, f -> ! f.booleanValue());
	}
	
	public static AbstractLogicalCompution xor(BooleanObservable a, BooleanObservable b) {
		return new InnerBi(a, b, (l, r) -> l.booleanValue() ^ r.booleanValue());
	}
	
	public static AbstractLogicalCompution nand(Collection<? extends BooleanObservable> observers) {
		return not(and(observers));
	}
	
	public static AbstractLogicalCompution nor(Collection<? extends BooleanObservable> observers) {
		return not(or(observers));
	}
	
	private static class InnerMono extends AbstractLogicalCompution {
		
		private static final long serialVersionUID = 4222943579843798685L;
		
		public InnerMono(BooleanObservable observer, Predicate<Boolean> compute) {
			super();
			
			observer.addChangeListener(f -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(Boolean.valueOf(compute.test(f)));
				}
			});
		}
	}
	
	private static class InnerBi extends AbstractLogicalCompution {
		
		private static final long serialVersionUID = -2708885090031897205L;
		
		private Boolean ll;
		private Boolean rr;
		
		public InnerBi(
				BooleanObservable left,
				BooleanObservable right,
				BiPredicate<Boolean, Boolean> compute) {
			
			super();
			
			left.addChangeListener(f -> {
				synchronized ( this._sync ) {
					this.ll = f;
					this._syncSetAndNotifyChanged(compute.test(this.ll, this.rr));
				}
			});
			
			right.addChangeListener(f -> {
				synchronized ( this._sync ) {
					this.rr = f;
					this._syncSetAndNotifyChanged(compute.test(this.ll, this.rr));
				}
			});
		}
	}
	
	private static class InnerCollection extends AbstractLogicalCompution {
		
		private static final long serialVersionUID = -1549973920268106365L;
		
		private final Collection<Inner> inners = new ArrayList<>();
		private final Predicate<? super Collection<Boolean>> compute;
		
		public InnerCollection(
				Collection<? extends BooleanObservable> observers,
				Predicate<? super Collection<Boolean>> compute) {
			
			super();
			
			this.compute = compute;
			
			observers.forEach(o -> {
				Inner i = new Inner();
				this.inners.add(i);
				o.addChangeListener(i);
			});
		}
		
		private class Inner implements ChangeListener<Boolean> {
			
			boolean last;
			
			public Inner() {
				this.last = false;
			}

			@Override
			public void changed(Boolean v) {
				synchronized ( InnerCollection.this._sync ) {
					this.last = v;
					InnerCollection.this._syncSetAndNotifyChanged(
							InnerCollection.this.compute.test(
									InnerCollection.this.inners.stream()
									.map(i -> i.last)
									.collect(Collectors.toList())));
				}
			}
		}
	}
	
}