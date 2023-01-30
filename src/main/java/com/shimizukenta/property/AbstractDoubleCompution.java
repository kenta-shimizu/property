package com.shimizukenta.property;

public abstract class AbstractDoubleCompution extends AbstractNumberCompution implements DoubleCompution {
	
	private static final long serialVersionUID = 3508416232137836839L;
	
	private static final Double INITIAL = Double.valueOf(0.0D);
	
	public AbstractDoubleCompution() {
		super(INITIAL);
	}
	
	@Override
	public boolean isDouble() {
		return true;
	}
	
}
