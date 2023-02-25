package example;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.BooleanProperty;

public class LogicalComputionExample implements Runnable {

	public LogicalComputionExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			final BooleanProperty a = BooleanProperty.newInstance(false);
			final BooleanProperty b = BooleanProperty.newInstance(false);
			
			/* getter */
			System.out.println("get a: " + a.booleanValue());
			System.out.println("get b: " + b.booleanValue());
			System.out.println();
			
			BooleanCompution and = a.and(b);
			BooleanCompution or = a.or(b);
			BooleanCompution not = a.not();
			BooleanCompution xor = a.xor(b);
			
			/* detect value changed */
			System.out.println("add change listeners, 1st time notify present status.");
			
			and.addChangeListener(v -> {
				System.out.println("a&&b : " + v);
			});
			
			or.addChangeListener(v -> {
				System.out.println("a||b : " + v);
			});
			
			not.addChangeListener(v -> {
				System.out.println("!a   : " + v);
			});
			
			xor.addChangeListener(v -> {
				System.out.println("a^b  : " + v);
			});
			
			System.out.println();
			System.out.println("set a: " + true);
			a.set(true);
			
			new Thread(() -> {
				
				try {
					System.out.println();
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					System.out.println("set b: " + true);
					b.set(true);
				}
				catch ( InterruptedException ignore ) {
				}
				
			}).start();
			
			System.out.println();
			System.out.println("waiting until a&&b is true...");
			and.waitUntilTrue();
			
			System.out.println();
			System.out.println("reach end");
		}
		catch ( InterruptedException ignore ) {
		}
	}

	public static void main(String[] args) {
		try {
			new LogicalComputionExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}
	
}
