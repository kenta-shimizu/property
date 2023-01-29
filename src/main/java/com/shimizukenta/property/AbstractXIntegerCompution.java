package com.shimizukenta.property;

public abstract class AbstractXIntegerCompution extends AbstractNumberCompution implements IntegerCompution {
	
	private static final long serialVersionUID = 1478234076700632753L;
	
	private static final Integer INITIAL = Integer.valueOf(0);
	
	public AbstractXIntegerCompution() {
		super(INITIAL);
	}
	
	@Override
	public boolean isInteger() {
		return true;
	}
	
}
