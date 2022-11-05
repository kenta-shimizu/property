package com.shimizukenta.property;

import java.util.EventListener;

public interface ChangeListener<T> extends EventListener {
	
	public void changed(T v);
}
