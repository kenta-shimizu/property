package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractFloatProperty extends AbstractNumberProperty<Float> implements FloatProperty {

	private static final long serialVersionUID = 7439939403442859342L;

	protected AbstractFloatProperty(float initial) {
		super(Float.valueOf(initial));
	}
	
	@Override
	public void set(float value) {
		this._syncSetAndNotifyChanged(Float.valueOf(value));
	}
	
	@Override
	public boolean isFloat() {
		return true;
	}
	
}
