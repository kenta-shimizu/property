package com.shimizukenta.property;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * String value compution, includes Getter, Observer.
 * 
 * <p>
 * <strong>NOT</strong> includes Setter.<br />
 * </p>
 * <p>
 * This instance is built from other Property or Compution.<br />
 * </p>
 * <ul>
 * <li>To build joined StringCompution, {@link #join(CharSequence, StringObservable...)}.</li>
 * </ul>
 * 
 * @author kenta-shimizu
 * @see StringGettable
 * @see StringObservable
 * @see Compution
 *
 */
public interface StringCompution extends Compution<String>, StringGettable, StringObservable {
	
	/**
	 * Returns joined StringCompution.
	 * 
	 * @param delimiter CharSequence
	 * @param observers StringObservers
	 * @return joined StringCompution
	 * @see StringJoiner
	 */
	public static StringCompution join(CharSequence delimiter, StringObservable... observers) {
		return join(delimiter, Arrays.asList(observers));
	}
	
	/**
	 * Returns joined StringCompution.
	 * 
	 * @param delimiter CharSequence
	 * @param observers StringObservers
	 * @return joined StringCompution
	 * @see StringJoiner
	 */
	public static StringCompution join(CharSequence delimiter, Iterable<StringObservable> observers) {
		return StringUtils.computeJoin(delimiter, observers);
	}
	
}
