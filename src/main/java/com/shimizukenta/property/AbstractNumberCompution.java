package com.shimizukenta.property;

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
	public byte byteValue() {
		synchronized ( this._sync ) {
			return this._simpleGet().byteValue();
		}
	}
	
	@Override
	public short shortValue() {
		synchronized ( this._sync ) {
			return this._simpleGet().shortValue();
		}
	}
	
	@Override
	public int intValue() {
		synchronized ( this._sync ) {
			return this._simpleGet().intValue();
		}
	}
	
	@Override
	public long longValue() {
		synchronized ( this._sync ) {
			return this._simpleGet().longValue();
		}
	}
	
	@Override
	public float floatValue() {
		synchronized ( this._sync ) {
			return this._simpleGet().floatValue();
		}
	}
	
	@Override
	public double doubleValue() {
		synchronized ( this._sync ) {
			return this._simpleGet().doubleValue();
		}
	}
	
	private final ChangeListener<Number> bindLstnr = this::_syncSetAndNotifyChanged;
	
	public boolean bind(NumberObservable<? extends Number> observer) {
		return observer.addChangeListener(this.bindLstnr);
	}
	
	public boolean unbind(NumberObservable<? extends Number> observer) {
		return observer.removeChangeListener(this.bindLstnr);
	}
	
}
