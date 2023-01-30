package com.shimizukenta.property;

public abstract class AbstractFloatCompution extends AbstractNumberCompution implements FloatCompution {
	
	private static final long serialVersionUID = 3652138284609831622L;
	
	private static final Float INITIAL = Float.valueOf(0.0F);
	
	public AbstractFloatCompution() {
		super(INITIAL);
	}
	
	@Override
	public boolean isFloat() {
		return true;
	}
	
}
