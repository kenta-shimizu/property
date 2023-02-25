package example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.IntegerProperty;

public class IntegerPropertyExample implements Runnable {

	public IntegerPropertyExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			System.out.println("build IntegerProperty 0 instance.");
			final IntegerProperty p = IntegerProperty.newInstance(0);
			System.out.println();
			
			/* getter */
			System.out.println("get value: " + p.intValue());
			System.out.println();
			
			/* setter */
			System.out.println("set value: " + 2);
			p.set(2);;
			System.out.println("get value: " + p.intValue());
			System.out.println();
			
			/* detect value changed */
			System.out.println("add change listener, 1st time notify present value.");
			p.addChangeListener(v -> {
				System.out.println("value changed: " + v);
				System.out.println();
			});
			
			System.out.println("set value: " + 3);
			p.set(3);;
			
			System.out.println("set value: " + 3 + ", no notify because no changed.");
			p.set(3);
			System.out.println();
			
			/* Threading */
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("set value: " + 10);
					p.set(10);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			/* wait until */
			System.out.println("waiting until >5");
			p.waitUntilGreaterThan(5);
			
			System.out.println("waiting until already <15, pass through immediately.");
			p.waitUntilLessThan(15);
			System.out.println();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					System.out.println("set value: " + -10);
					p.set(-10);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until <0");
			p.waitUntilLessThanZero();
			
			try {
				System.out.println("waiting until ==0 with timeout 2 sec...");
				p.waitUntilEqualToZero(2L, TimeUnit.SECONDS);
			}
			catch ( TimeoutException e ) {
				System.out.println("timeout, waiting until ==0");
				System.out.println(e);
				System.out.println();
			}
			
			/* compution */
			BooleanCompution eq = p.computeIsEqualTo(0);
			eq.addChangeListener(v -> {
				System.out.println("is ==0: " + v);
			});
			
			BooleanCompution lt = p.computeIsLessThan(0);
			lt.addChangeListener(v -> {
				System.out.println("is <0: " + v);
			});
			
			BooleanCompution ge = p.computeIsGreaterThanOrEqualTo(0);
			ge.addChangeListener(v -> {
				System.out.println("is >=0: " + v);
			});
			
			System.out.println();
			System.out.println("set value: " + 0);
			p.set(0);
			
			System.out.println();
			System.out.println("set value: " + 10 + ", no notify because no change.");
			p.set(10);
			
			System.out.println();
			System.out.println("reach end");
		}
		catch ( InterruptedException ignore ) {
		}
	}
	
	public static void main(String[] args) {
		try {
			new IntegerPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
