package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface BooleanGettable extends Gettable<Boolean> {
	
	/**
	 * Returns the value of this Boolean object as a boolean primitive.
	 * 
	 * <p>This implementation returns {@link Boolean#booleanValue()}.</p>
	 * 
	 * @return the primitive boolean value of this object.
	 */
	default public boolean booleanValue() {
		return this.get().booleanValue();
	}
	
}
