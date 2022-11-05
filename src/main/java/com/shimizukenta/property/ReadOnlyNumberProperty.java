package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface ReadOnlyNumberProperty<T extends Number> extends ReadOnlyProperty<T> {
	
	public byte byteValue();
	
	public short shortValue();
	
	public int intValue();
	
	public long longValue();
	
	public float floatValue();
	
	public double doubleValue();
	
	public void waitUntilEqualTo(int value) throws InterruptedException;
	public void waitUntilEqualTo(long value) throws InterruptedException;
	public void waitUntilEqualTo(float value) throws InterruptedException;
	public void waitUntilEqualTo(double value) throws InterruptedException;
	public void waitUntilEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(int value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(long value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(float value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilEqualTo(double value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilNotEqualTo(int value) throws InterruptedException;
	public void waitUntilNotEqualTo(long value) throws InterruptedException;
	public void waitUntilNotEqualTo(float value) throws InterruptedException;
	public void waitUntilNotEqualTo(double value) throws InterruptedException;
	public void waitUntilNotEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(int value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(long value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(float value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualTo(double value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilLessThan(int value) throws InterruptedException;
	public void waitUntilLessThan(long value) throws InterruptedException;
	public void waitUntilLessThan(float value) throws InterruptedException;
	public void waitUntilLessThan(double value) throws InterruptedException;
	public void waitUntilLessThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(int value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(long value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(float value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilLessThan(double value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilLessThanOrEqualTo(int value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(long value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(float value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(double value) throws InterruptedException;
	public void waitUntilLessThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(int value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(long value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(float value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualTo(double value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilGreaterThan(int value) throws InterruptedException;
	public void waitUntilGreaterThan(long value) throws InterruptedException;
	public void waitUntilGreaterThan(float value) throws InterruptedException;
	public void waitUntilGreaterThan(double value) throws InterruptedException;
	public void waitUntilGreaterThan(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(int value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(long value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(float value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThan(double value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilGreaterThanOrEqualTo(int value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(long value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(float value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(double value) throws InterruptedException;
	public void waitUntilGreaterThanOrEqualTo(int value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(long value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(float value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(double value, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(int value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(long value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(float value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualTo(double value, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilEqualToZero() throws InterruptedException;
	public void waitUntilEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilEqualToZero(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilNotEqualToZero() throws InterruptedException;
	public void waitUntilNotEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilNotEqualToZero(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilLessThanZero() throws InterruptedException;
	public void waitUntilLessThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanZero(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilGreaterThanZero() throws InterruptedException;
	public void waitUntilGreaterThanZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanZero(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilLessThanOrEqualToZero() throws InterruptedException;
	public void waitUntilLessThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilLessThanOrEqualToZero(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilGreaterThanOrEqualToZero() throws InterruptedException;
	public void waitUntilGreaterThanOrEqualToZero(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	public void waitUntilGreaterThanOrEqualToZero(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;

}
