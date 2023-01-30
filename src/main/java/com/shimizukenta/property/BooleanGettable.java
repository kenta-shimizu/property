package com.shimizukenta.property;

/**
 * Boolean value Getter.
 * 
 * @author kenta-shimizu
 * @see Boolean
 * @see Gettable
 */
public interface BooleanGettable extends Gettable<Boolean> {
	
	/**
	 * Returns the value of this Boolean object as a boolean primitive.
	 * 
	 * <p>This implementation returns {@link Boolean#booleanValue()}.</p>
	 * 
	 * @return the primitive boolean value of this object.
	 */
	public boolean booleanValue();
	
}
