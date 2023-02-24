package example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanProperty;

public class BooleanPropertyExample implements Runnable {

	public BooleanPropertyExample() {
		/* Nothing */
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			System.out.println("build " + false + " instance.");
			final BooleanProperty p = BooleanProperty.newInstance(false);
			System.out.println();
			
			/* getter */
			System.out.println("get value is " + p.booleanValue());
			System.out.println();
			
			/* setter */
			System.out.println("set value: " + true);
			p.set(true);
			System.out.println("get value: " + p.booleanValue());
			System.out.println();
			
			System.out.println("set value: " + false);
			p.set(false);
			System.out.println("get value: " + p.booleanValue());
			System.out.println();
			
			/* detect changed */
			System.out.println("add change listener, 1st time notify present value.");
			p.addChangeListener(v -> {
				System.out.println("value changed: " + v.booleanValue());
				System.out.println();
			});
			
			System.out.println("set value: " + true);
			p.set(true);
			
			System.out.println("set value: " + true + ", no notify because no changed.");
			p.set(true);
			System.out.println();
			
			System.out.println("set value: " + false);
			p.set(false);
			
			/* thread set value */
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("set value: " + true);
					p.set(true);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			/* wait until */
			System.out.println("waiting until value is " + true);
			p.waitUntil(true);
			
			System.out.println("waiting until value is already " + true + ", pass through immediately.");
			p.waitUntil(true);
			System.out.println();
			
			try {
				System.out.println("waiting until value is " + false + " with timeout 2 sec...");
				p.waitUntil(false, 2L, TimeUnit.SECONDS);
			}
			catch ( TimeoutException e ) {
				System.out.println("timeout, waiting until value is " + false);
				System.out.println(e);
				System.out.println();
			}
			
			System.out.println("reach end.");
		}
		catch (InterruptedException ignore) {
		}
	}
	
	public static void main(String[] args) {
		
		try {
			new BooleanPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}
	
}
