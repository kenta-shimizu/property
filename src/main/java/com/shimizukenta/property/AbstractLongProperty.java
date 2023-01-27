package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractLongProperty extends AbstractNumberProperty<Long> implements LongProperty {
	
	private static final long serialVersionUID = 9186020409952044558L;

	public AbstractLongProperty(long initial) {
		super(Long.valueOf(initial));
	}
	
	@Override
	public void set(long value) {
		this._syncSetAndNotifyChanged(Long.valueOf(value));
	}
	
	@Override
	public boolean isLong() {
		return true;
	}
	
}
