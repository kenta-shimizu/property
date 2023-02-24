package example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.IntegerCompution;
import com.shimizukenta.property.SetProperty;

public class SetPropertyExample implements Runnable {

	public SetPropertyExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			System.out.println("build SetProperty<String> empty instance.");
			final SetProperty<String> p = SetProperty.newInstance();
			System.out.println();
			
			/* getter */
			System.out.println("get value is " + p);
			System.out.println();
			
			/* setter */
			System.out.println("add value: " + "A");
			p.add("A");
			System.out.println("get value: " + p);
			System.out.println();
			
			System.out.println("add value: " + "B");
			p.add("B");
			System.out.println("get value: " + p);
			System.out.println();
			
			System.out.println("add value: " + "B" + ", set failed.");
			p.add("B");
			System.out.println("get value: " + p);
			System.out.println();
			
			/* detect changed */
			System.out.println("add change listener, 1st time notify present value.");
			p.addChangeListener(v -> {
				System.out.println("value changed: " + v);
				System.out.println();
			});
			
			System.out.println("add value: " + "C");
			p.add("C");
			
			System.out.println("add value: " + "C" + ", no notify because no changed.");
			p.add("C");
			System.out.println();
			
			System.out.println("remove value: " + "B");
			p.remove("B");
			
			/* thread set value */
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("clear");
					p.clear();
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			/* wait until */
			System.out.println("waiting until empty");
			p.waitUntilIsEmpty();
			
			System.out.println("waiting until is already empty, pass through immediately.");
			p.waitUntilIsEmpty();
			System.out.println();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("add value: " + "D");
					p.add("D");
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until is not empty.");
			p.waitUntilIsNotEmpty();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("add value: " + "E");
					p.add("E");
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until value is contains: " + "E");
			p.waitUntilContains("E");
			
			try {
				System.out.println("waiting until conatins " + "F" + " with timeout 2 sec...");
				p.waitUntilContains("F", 2L, TimeUnit.SECONDS);
			}
			catch ( TimeoutException e ) {
				System.out.println("timeout, waiting until contains " + "F");
				System.out.println(e);
				System.out.println();
			}
			
			/* compution */
			BooleanCompution isEmpty = p.computeIsEmpty();
			isEmpty.addChangeListener(v -> {
				System.out.println("isEmpty(): " + v);
			});
			
			BooleanCompution isNotEmpty = p.computeIsNotEmpty();
			isNotEmpty.addChangeListener(v -> {
				System.out.println("isNotEmpty(): " + v);
			});
			
			BooleanCompution containsE = p.computeContains("E");
			containsE.addChangeListener(v -> {
				System.out.println("contains(E): " + v);
			});
			
			IntegerCompution size = p.computeSize();
			size.addChangeListener(v -> {
				System.out.println("size(): " + v);
			});
			
			System.out.println();
			System.out.println("clear");
			p.clear();
			
			System.out.println();
			System.out.println("reach end.");
		}
		catch (InterruptedException ignore) {
		}
	}
	
	public static void main(String[] args) {
		
		try {
			new SetPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}
	
}
