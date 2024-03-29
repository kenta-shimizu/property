package com.shimizukenta.property.impl;

import com.shimizukenta.property.StringCompution;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractStringCompution extends AbstractCompution<String> implements StringCompution {

	private static final long serialVersionUID = -8288909421132872799L;
	
	/**
	 * Constructor.
	 */
	public AbstractStringCompution() {
		super("");
	}

}
