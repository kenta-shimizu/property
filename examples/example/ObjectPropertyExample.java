package example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.ObjectProperty;

public class ObjectPropertyExample implements Runnable {

	public ObjectPropertyExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			System.out.println("build ObjectProperty<String> null instance.");
			final ObjectProperty<String> p = ObjectProperty.newInstance(null);
			System.out.println();
			
			/* getter */
			System.out.println("get value is " + p);
			System.out.println();
			
			/* setter */
			System.out.println("set value: " + "A");
			p.set("A");
			System.out.println("get value: " + p);
			System.out.println();
			
			System.out.println("set value: " + "B");
			p.set("B");
			System.out.println("get value: " + p);
			System.out.println();
			
			/* detect changed */
			System.out.println("add change listener, 1st time notify present value.");
			p.addChangeListener(v -> {
				System.out.println("value changed: " + v);
				System.out.println();
			});
			
			System.out.println("set value: " + "C");
			p.set("C");
			
			System.out.println("set value: " + "C" + ", no notify because no changed.");
			p.set("C");
			System.out.println();
			
			/* thread set value */
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("set: " + null);
					p.set(null);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			/* wait until */
			System.out.println("waiting until is null.");
			p.waitUntilNull();
			
			System.out.println("waiting until is already null, pass through immediately.");
			p.waitUntilNull();
			System.out.println();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("set value: " + "D");
					p.set("D");
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until is not null and get value.");
			String r = p.waitUntilNotNullAndGet();
			System.out.println("return value: " + r);
			System.out.println();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("set value: " + "E");
					p.set("E");
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until is equal to " + "E");
			p.waitUntilEqualTo("E");
			
			try {
				System.out.println("waiting until is equal to " + "F" + " with timeout 2 sec...");
				p.waitUntilEqualTo("F", 2L, TimeUnit.SECONDS);
			}
			catch ( TimeoutException e ) {
				System.out.println("timeout, waiting until is equal to " + "F");
				System.out.println(e);
				System.out.println();
			}
			
			/* compution */
			BooleanCompution isNull = p.computeIsNull();
			isNull.addChangeListener(v -> {
				System.out.println("isNull(): " + v);
			});
			
			BooleanCompution isNotNull = p.computeIsNotNull();
			isNotNull.addChangeListener(v -> {
				System.out.println("isNotNull(): " + v);
			});
			
			BooleanCompution isEqualToE = p.computeIsEqualTo("E");
			isEqualToE.addChangeListener(v -> {
				System.out.println("isEqualTo(E): " + v);
			});
			
			System.out.println();
			System.out.println("set: " + null);
			p.set(null);
			
			System.out.println();
			System.out.println("reach end.");
		}
		catch (InterruptedException ignore) {
		}
	}

	public static void main(String[] args) {
		try {
			new ObjectPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
