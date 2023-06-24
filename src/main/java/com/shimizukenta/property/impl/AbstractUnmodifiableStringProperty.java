package com.shimizukenta.property.impl;

import com.shimizukenta.property.ChangeListener;
import com.shimizukenta.property.Observable;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class AbstractUnmodifiableStringProperty extends AbstractStringProperty {
	
	private static final long serialVersionUID = 7469480504868883522L;
	
	/**
	 * Constructor.
	 * 
	 * @param initial CharSequence
	 */
	public AbstractUnmodifiableStringProperty(CharSequence initial) {
		super(initial);
	}
	
	@Override
	public void set(CharSequence value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addChangeListener(ChangeListener<? super String> l) {
		l.changed(this._simpleGet());
		return true;
	}
	
	@Override
	public boolean removeChangeListener(ChangeListener<? super String> l) {
		return true;
	}
	
	@Override
	public boolean bind(Observable<? extends String> observer) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean unbind(Observable<? extends String> observer) {
		throw new UnsupportedOperationException();
	}
	
}
