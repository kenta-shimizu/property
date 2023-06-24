package com.shimizukenta.property.impl;

import com.shimizukenta.property.IntegerCompution;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractIntegerCompution extends AbstractNumberCompution implements IntegerCompution {
	
	private static final long serialVersionUID = 1478234076700632753L;
	
	private static final Integer INITIAL = Integer.valueOf(0);
	
	/**
	 * Constructor.
	 * 
	 */
	public AbstractIntegerCompution() {
		super(INITIAL);
	}
	
	@Override
	public boolean isInteger() {
		return true;
	}
	
}
