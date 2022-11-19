package com.shimizukenta.property;

import java.util.Objects;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractNumberCompution extends AbstractCompution<Number> implements NumberCompution {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2433088920743345120L;

	public AbstractNumberCompution(Number initial) {
		super(initial);
	}
	
	@Override
	protected void _set(Number value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(this._get(), value) ) {
				super._set(value);
				this._notifyChanged(value);
				this._sync.notifyAll();
			}
		}
	}
	
	@Override
	public boolean isInteger() {
		return false;
	}
	
	@Override
	public boolean isLong() {
		return false;
	}
	
	@Override
	public boolean isFloat() {
		return false;
	}
	
	@Override
	public boolean isDouble() {
		return false;
	}
	
	@Override
	public String toString() {
		return this.get().toString();
	}

}
