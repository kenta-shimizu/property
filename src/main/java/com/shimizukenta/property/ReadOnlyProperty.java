package com.shimizukenta.property;

public interface ReadOnlyProperty<T> {
	
	public T get();
	
	public boolean addChangeListener(ChangeListener<T> l);
	
	public boolean removeChangeListener(ChangeListener<T> l);
	
}
