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
	public byte byteValue();
	
	/**
	 * Returns the value of the specified number as a short.
	 * 
	 * <p>This implementation returns {@link Number#shortValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type short.
	 */
	public short shortValue();
	
	/**
	 * Returns the value of the specified number as a int.
	 * 
	 * <p>This implementation returns {@link Number#intValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type int.
	 */
	public int intValue();
	
	/**
	 * Returns the value of the specified number as a long.
	 * 
	 * <p>This implementation returns {@link Number#longValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type long.
	 */
	public long longValue();
	
	/**
	 * Returns the value of the specified number as a float.
	 * 
	 * <p>This implementation returns {@link Number#floatValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type float.
	 */
	public float floatValue();
	
	/**
	 * Returns the value of the specified number as a double.
	 * 
	 * <p>This implementation returns {@link Number#doubleValue()}.</p>
	 * 
	 * @return the numeric value represented by this object after conversion to type double.
	 */
	public double doubleValue();
	
}
