package com.shimizukenta.property;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractBooleanCompution extends AbstractCompution<Boolean> implements BooleanCompution {
	
	private static final long serialVersionUID = 628986372297013412L;
	
	protected AbstractBooleanCompution(Boolean initial) {
		super(initial);
	}
	
	@Override
	public boolean booleanValue() {
		return this._simpleGet().booleanValue();
	}
	
}
