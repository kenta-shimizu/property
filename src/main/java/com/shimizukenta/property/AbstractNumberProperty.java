package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public abstract class AbstractNumberProperty<T extends Number> extends AbstractProperty<T> implements NumberProperty<T> {
	
	private static final long serialVersionUID = -5768297706611678591L;
	
	public AbstractNumberProperty(T initial) {
		super(initial);
	}
	
	@Override
	public byte byteValue() {
		return this._simpleGet().byteValue();
	}
	
	@Override
	public short shortValue() {
		return this._simpleGet().shortValue();
	}
	
	@Override
	public int intValue() {
		return this._simpleGet().intValue();
	}
	
	@Override
	public long longValue() {
		return this._simpleGet().longValue();
	}
	
	@Override
	public float floatValue() {
		return this._simpleGet().floatValue();
	}
	
	@Override
	public double doubleValue() {
		return this._simpleGet().doubleValue();
	}
	
	@Override
	public boolean isInteger() {
		return false;
	}
	
	@Override
	public boolean isLong() {
		return false;
	}
	
	@Override
	public boolean isFloat() {
		return false;
	}
	
	@Override
	public boolean isDouble() {
		return false;
	}
	
}
