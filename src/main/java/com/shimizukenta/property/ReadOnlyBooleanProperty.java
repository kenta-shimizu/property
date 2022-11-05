/**
 * 
 */
package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public interface ReadOnlyBooleanProperty extends ReadOnlyProperty<Boolean> {
	
	/**
	 * Getter.
	 * 
	 * @return value
	 */
	public boolean booleanValue();
	
	public void waitUntil(boolean f) throws InterruptedException;
	
	public void waitUntil(boolean f, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public void waitUntil(boolean f, ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilTrue() throws InterruptedException;
	
	public void waitUntilTrue(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public void waitUntilTrue(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
	public void waitUntilFalse() throws InterruptedException;
	
	public void waitUntilFalse(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException;
	
	public void waitUntilFalse(ReadOnlyTimeProperty p) throws InterruptedException, TimeoutException;
	
}
