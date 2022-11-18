package com.shimizukenta.property;

import java.util.EventListener;

/**
 * 
 * @author kenta-shimizu
 *
 * @param <T> Type
 */
public interface ChangeListener<T> extends EventListener {
	
	/**
	 * Changed.
	 * 
	 * @param v
	 */
	public void changed(T v);
}
