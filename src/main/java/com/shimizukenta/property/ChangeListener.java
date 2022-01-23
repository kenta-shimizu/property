package com.shimizukenta.property;

import java.awt.event.ActionListener;

public interface ChangeListener<T> extends ActionListener {
	
	public void changed(T v);
}
