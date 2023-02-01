package com.shimizukenta.property;

/**
 * Integer value Compution, includes Getter, Observer.
 * 
 * <p>
 * <strong>NOT</strong> includes Setter.<br />
 * </p>
 * <ul>
 * <li>To get value, {@link #byteValue()}, {@link #shortValue()}, {@link #intValue()}, {@link #longValue()}, {@link #floatValue()}, {@link #doubleValue()}.</li>
 * <li>To detect value changed, {@link #addChangeListener(ChangeListener)}.</li>
 * </ul>
 * 
 * @author kenta-shimizu
 * @see NumberCompution
 * @see Integer
 *
 */
public interface IntegerCompution extends NumberCompution {

}
