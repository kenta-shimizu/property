package example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanProperty;
import com.shimizukenta.property.TimeoutProperty;

public class TimeoutPropertyExample implements Runnable {

	public TimeoutPropertyExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			System.out.println("build instance: 1L, TimeUnit.MINUTES");
			TimeoutProperty p = TimeoutProperty.newInstance(1L, TimeUnit.MINUTES);
			
			System.out.println("get: " + p.get());
			System.out.println();
			
			System.out.println("set: 10(int)");
			p.set(10);
			System.out.println("get: " + p);
			System.out.println();
			
			System.out.println("set: 5.0F(float)");
			p.set(5.0F);
			System.out.println("get: " + p);
			System.out.println();
			
			System.out.println("set: 2.0D(double)");
			p.set(2.0D);
			System.out.println("get: " + p);
			System.out.println();
			
			/* TimeUnit#sleep */
			System.out.println("TimeUnit.sleep " + p + "...");
			p.sleep();
			System.out.println("wakeup");
			System.out.println();
			
			/* TimeUnit#wait */
			System.out.println("TimeUnit.wait(this) " + p + "...");
			synchronized ( this ) {
				p.wait(this);
				System.out.println("timeout");
			}
			System.out.println();
			
			/* BlockingQueue#poll */
			System.out.println("BlockingQueue.poll(timoeut, TimeUnit) " + p + "...");
			{
				BlockingQueue<String> queue = new LinkedBlockingQueue<>();
				String r = p.blockingQueuePoll(queue);
				if ( r == null ) {
					System.out.println("timeout, BlockingQueue#poll returns " + r);
				} else {
					System.out.println("poll is " + r);
				}
			}
			System.out.println();
			
			/* BooleanProperty#waitUntil */
			try {
				System.out.println("build false BooleanProperty");
				BooleanProperty bool = BooleanProperty.newInstance(false);
				System.out.println("get bool: " + bool.booleanValue());
				System.out.println("BooleanProperty#waitUntilTrue with TimeoutProperty...");
				bool.waitUntilTrue(p);
			}
			catch ( TimeoutException e ) {
				System.out.println("timeout, Boolean#waitUntilTrue " + p);
				System.out.println(e);
			}
			System.out.println();
			
			System.out.println("reach end");
		}
		catch ( InterruptedException ignore ) {
		}
	}

	public static void main(String[] args) {
		try {
			new TimeoutPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
