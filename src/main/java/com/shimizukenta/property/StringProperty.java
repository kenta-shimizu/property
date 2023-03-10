package com.shimizukenta.property;

/**
 * String value Property, includes Getter, Setter, Observer.
 * 
 * <ul>
 * <li>To build instance, {@link #newInstance()}.</li>
 * <li>To set value, {@link #set(CharSequence)}.</li>
 * <li>To toString(), {@link #toString()}.</li>
 * <li>To detect value changed, {@link #addChangeListener(ChangeListener)}</li>
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
