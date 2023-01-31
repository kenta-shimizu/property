package com.shimizukenta.property;

import java.util.EventListener;

/**
 * Change Listener, used in Observer.
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 * @see EventListener
 * @see Observable
 */
public interface ChangeListener<T> extends EventListener {
	
	/**
	 * Changed.
	 * 
	 * @param v
	 */
	public void changed(T v);
}
