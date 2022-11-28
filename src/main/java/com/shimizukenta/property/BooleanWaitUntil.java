package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class BooleanWaitUntil extends AbstractWaitUntil {

	private BooleanWaitUntil() {
		super();
	}
	
	private static final class SingletonHolder {
		private static final BooleanWaitUntil inst = new BooleanWaitUntil();
	}
	
	public static BooleanWaitUntil getInstance() {
		return SingletonHolder.inst;
	}
	
	protected class Inner extends AbstractInner implements ChangeListener<Boolean> {
		
		private Inner(boolean condition) {
			super(condition);
		}
		
		@Override
		public void changed(Boolean f) {
			this.set(f.booleanValue());
		}
	}
	
	public void waitUntil(BooleanObservable observable, boolean condition) throws InterruptedException {
		final Inner i = new Inner(condition);
		try {
			observable.addChangeListener(i);
			i.waitUntil();
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public void waitUntil(BooleanObservable observable, boolean condition, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final Inner i = new Inner(condition);
		try {
			observable.addChangeListener(i);
			i.waitUntil(timeout, unit);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
	public void waitUntil(BooleanObservable observable, boolean condition, TimeGettable p) throws InterruptedException, TimeoutException {
		final Inner i = new Inner(condition);
		try {
			observable.addChangeListener(i);
			i.waitUntil(p);
		}
		finally {
			observable.removeChangeListener(i);
		}
	}
	
}
