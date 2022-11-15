package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class UnmodifiablePropertyBuilder {
	
	public static UnmodifiablePropertyBuilder getInstance() {
		return SingletonBuilderHolder.inst;
	}
	
	private static class SingletonBuilderHolder {
		private static final UnmodifiablePropertyBuilder inst = new UnmodifiablePropertyBuilder();
	}
	
	protected UnmodifiablePropertyBuilder() {
		/* Nothing */
	}
	
	public BooleanProperty getBoolean(boolean f) {
		if ( f ) {
			return SingletonTrueHolder.inst;
		} else {
			return SingletonFalseHolder.inst;
		}
	}
	
	private static class SingletonTrueHolder {
		private static final BooleanProperty inst = buildUnmodifiableBooleanProperty(true);
	}
	
	private static class SingletonFalseHolder {
		private static final BooleanProperty inst = buildUnmodifiableBooleanProperty(false);
	}
	
	private static BooleanProperty buildUnmodifiableBooleanProperty(boolean f) {
		return new AbstractBooleanProperty(false) {
			
			private static final long serialVersionUID = -7765500375552713489L;
		};
	}
	
	public IntegerProperty newInteger(int value) {
		return buildInteger(value);
	}
	
	public LongProperty newLong(long value) {
		return buildLong(value);
	}
	
	public FloatProperty newFloat(float value) {
		return buildFloat(value);
	}
	
	public DoubleProperty newDouble(double value) {
		return buildDouble(value);
	}
	
	public IntegerProperty getIntegerZero() {
		return SingletonIntegerZeroHolder.inst;
	}
	
	private static IntegerProperty buildInteger(int value) {
		return new AbstractUnmodifiableIntegerProperty(value) {
			
			private static final long serialVersionUID = 4020676969990201529L;
		};
	}
	
	private static LongProperty buildLong(long value) {
		return new AbstractUnmodifiableLongProperty(value) {

			private static final long serialVersionUID = 2702622372607129814L;
		};
	}
	
	private static FloatProperty buildFloat(float value) {
		return new AbstractUnmodifiableFloatProperty(value) {

			private static final long serialVersionUID = -202643943136450558L;
		};
	}
	
	private static DoubleProperty buildDouble(double value) {
		return new AbstractUnmodifiableDoubleProperty(value) {

			private static final long serialVersionUID = -9155890056253784008L;
		};
	}
	
	private static class SingletonIntegerZeroHolder {
		private static final IntegerProperty inst = buildInteger(0);
	}
	
}
