package com.shimizukenta.property;

public abstract class AbstractXLongCompution extends AbstractNumberCompution implements LongCompution {
	
	private static final long serialVersionUID = -8168294359294221578L;
	
	private static final Long INITIAL = Long.valueOf(0L);
	
	public AbstractXLongCompution() {
		super(INITIAL);
	}
	
	@Override
	public boolean isLong() {
		return true;
	}
	
}
