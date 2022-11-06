package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface NumberGettable<T extends Number> extends Gettable<T> {
	
	/**
	 * Returns the value of the specified number as a byte.
	 * 
	 * <p>This implementation returns {@link Number#byteValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type byte.
	 */
	default public byte byteValue() {
		return this.get().byteValue();
	}
	
	/**
	 * Returns the value of the specified number as a short.
	 * 
	 * <p>This implementation returns {@link Number#shortValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type short.
	 */
	default public short shortValue() {
		return this.get().shortValue();
		
	}
	
	/**
	 * Returns the value of the specified number as a int.
	 * 
	 * <p>This implementation returns {@link Number#intValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type int.
	 */
	default public int intValue() {
		return this.get().intValue();
	}
	
	/**
	 * Returns the value of the specified number as a long.
	 * 
	 * <p>This implementation returns {@link Number#longValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type long.
	 */
	default public long longValue() {
		return this.get().longValue();
	}
	
	/**
	 * Returns the value of the specified number as a float.
	 * 
	 * <p>This implementation returns {@link Number#floatValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type float.
	 */
	default public float floatValue() {
		return this.get().floatValue();
	}
	
	/**
	 * Returns the value of the specified number as a double.
	 * 
	 * <p>This implementation returns {@link Number#doubleValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type double.
	 */
	default public double doubleValue() {
		return this.get().doubleValue();
	}
	
}
