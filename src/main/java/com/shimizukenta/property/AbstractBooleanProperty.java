package com.shimizukenta.property;

/**
 * @author kenta-shimizu
 *
 */
public abstract class AbstractBooleanProperty extends AbstractProperty<Boolean> implements BooleanProperty {
	
	private static final long serialVersionUID = 3470538189679094943L;
	
	protected AbstractBooleanProperty(boolean initial) {
		super(Boolean.valueOf(initial));
	}
	
	@Override
	public boolean booleanValue() {
		return this._simpleGet().booleanValue();
	}
	
	@Override
	public void set(boolean value) {
		this._syncSetAndNotifyChanged(Boolean.valueOf(value));
	}
	
}
