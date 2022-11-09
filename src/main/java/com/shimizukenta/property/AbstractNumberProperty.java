/**
 * 
 */
package com.shimizukenta.property;

import java.util.Objects;

/**
 * @author kenta-shimizu
 *
 */
public abstract class AbstractNumberProperty<T extends Number> extends AbstractProperty<T, NumberSettable<T>> implements NumberProperty<T> {
	
	private static final long serialVersionUID = -5768297706611678591L;
	
	protected AbstractNumberProperty(T initial) {
		super(initial);
	}
	
	@Override
	public void set(T value) {
		synchronized ( this._sync ) {
			if ( ! Objects.equals(this._get(), value) ) {
				this._set(value);
				this._notifyChanged(value);
				this._sync.notifyAll();
			}
		}
	}
	
	@Override
	public String toString() {
		return get().toString();
	}
	
}
