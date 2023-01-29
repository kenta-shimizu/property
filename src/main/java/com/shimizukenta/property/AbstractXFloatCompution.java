package com.shimizukenta.property;

public abstract class AbstractXFloatCompution extends AbstractNumberCompution implements FloatCompution {
	
	private static final long serialVersionUID = 3652138284609831622L;
	
	private static final Float INITIAL = Float.valueOf(0.0F);
	
	public AbstractXFloatCompution() {
		super(INITIAL);
	}
	
	@Override
	public boolean isFloat() {
		return true;
	}
	
}
