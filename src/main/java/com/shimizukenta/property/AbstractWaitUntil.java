package com.shimizukenta.property;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author kenta-shimizu
 *
 */
public abstract class AbstractWaitUntil {

	protected AbstractWaitUntil() {
		/* Nothing */
	}
	
	protected abstract class AbstractInner {
		
		protected final Object sync = new Object();
		private final boolean condition;
		protected boolean last;
		
		public AbstractInner(boolean condition) {
			this.condition = condition;
			this.last = false;
		}
		
		protected void set(boolean f) {
			synchronized ( this.sync ) {
				if ( f != this.last ) {
					this.last = f;
					this.sync.notifyAll();
				}
			}
		}
		
		public void waitUntil() throws InterruptedException {
			synchronized ( this.sync ) {
				if ( this.last != this.condition ) {
					this.sync.wait();
				}
			}
		}
		
		public void waitUntil(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
			synchronized ( this.sync ) {
				if ( this.last != this.condition ) {
					unit.timedWait(this.sync, timeout);
					if ( this.last != this.condition ) {
						throw new TimeoutException();
					}
				}
			}
		}
		
		public void waitUntil(TimeGettable p) throws InterruptedException, TimeoutException {
			TimeoutAndUnit a = p.get();
			this.waitUntil(a.timeout(), a.unit());
		}
	}
	
}
