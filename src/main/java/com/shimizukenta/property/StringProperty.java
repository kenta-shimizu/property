package com.shimizukenta.property;

/**
 * String value Property, includes Getter, Setter, Observer.
 * 
 * <ul>
 * <li>To build instance, {@link #newInstance()}.</br>
 * <li>To set value, {@link #set(CharSequence)}.<br />
 * <li>To toString(), {@link #toString()}.<br />
 * <li>To detect value changed, {@link #addChangeListener(ChangeListener)}<br />
 * 
 * </ul>
 * 
 * @author kenta-shimizu
 * @see StringGettable
 * @see StringSettable
 * @see StringObservable
 * @see Property
 *
 */
public interface StringProperty extends Property<String>, StringGettable, StringSettable, StringObservable {
	
	/**
	 * Empty String instance builder
	 * 
	 * @return new Empty String instance
	 */
	public static StringProperty newInstance() {
		return newInstance(null);
	}
	
	/**
	 * Instance builder.
	 * 
	 * @param initial Initial CharSequence
	 * @return new-instance
	 */
	public static StringProperty newInstance(CharSequence initial) {
		
		return new AbstractStringProperty(initial) {

			private static final long serialVersionUID = -3211169903612875617L;
		};
	}
}
