package example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.IntegerCompution;
import com.shimizukenta.property.MapProperty;
import com.shimizukenta.property.SetCompution;

public class MapPropertyExample implements Runnable {

	public MapPropertyExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			System.out.println("build MapProperty<String, Integer> empty instance.");
			final MapProperty<String, Integer> p = MapProperty.newInstance();
			System.out.println();
			
			/* getter */
			System.out.println("get value is " + p);
			System.out.println();
			
			/* setter */
			System.out.println("put value: " + "{A, 1}");
			p.put("A", 1);
			System.out.println("get value: " + p);
			System.out.println();
			
			System.out.println("put value: " + "{B, 2}");
			p.put("B", 2);
			System.out.println("get value: " + p);
			System.out.println();
			
			/* detect changed */
			System.out.println("add change listener, 1st time notify present value.");
			p.addChangeListener(v -> {
				System.out.println("value changed: " + v);
				System.out.println();
			});
			
			System.out.println("put value: " + "{C, 3}");
			p.put("C", 3);
			
			System.out.println("put value: " + "{C, 3}" + ", no notify because no changed.");
			p.put("C", 3);
			System.out.println();
			
			System.out.println("remove key: " + "B");
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
			
			System.out.println("waiting until already empty, pass through immediately.");
			p.waitUntilIsEmpty();
			System.out.println();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("put value: " + "{D, 4}");
					p.put("D", 4);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until is not empty");
			p.waitUntilIsNotEmpty();
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					System.out.println("put value: " + "{E, 5}");
					p.put("E", 5);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println("waiting until containsKeyAndGet: " + "E");
			Integer r = p.waitUntilContainsKeyAndGet("E");
			System.out.println("value E: " + r);
			System.out.println();
			
			try {
				System.out.println("waiting until conatinsKeyAndGet " + "F" + " with timeout 2 sec...");
				p.waitUntilContainsKeyAndGet("F", 2L, TimeUnit.SECONDS);
			}
			catch ( TimeoutException e ) {
				System.out.println("timeout, waiting until containsKey " + "F");
				System.out.println(e);
				System.out.println();
			}
			
			/* compution */
			BooleanCompution isEmpty = p.computeIsEmpty();
			isEmpty.addChangeListener(v -> {
				System.out.println("isEmpty: " + v);
			});
			
			BooleanCompution isNotEmpty = p.computeIsNotEmpty();
			isNotEmpty.addChangeListener(v -> {
				System.out.println("isNotEmpty: " + v);
			});
			
			BooleanCompution containsKeyD = p.computeContainsKey("D");
			containsKeyD.addChangeListener(v -> {
				System.out.println("containsKeyD: " + v);
			});
			
			SetCompution<String> keySet = p.computeKeySet();
			keySet.addChangeListener(v -> {
				System.out.println("keySet: " + v);
			});
			
			IntegerCompution size = p.computeSize();
			size.addChangeListener(v -> {
				System.out.println("size: " + v);
			});
			
			System.out.println();
			System.out.println("remove D");
			p.remove("D");
			
			System.out.println();
			System.out.println("clear");
			p.clear();
			
			System.out.println();
			System.out.println("reach end");
		}
		catch ( InterruptedException ignore ) {
		}
	}

	public static void main(String[] args) {
		try {
			new MapPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
