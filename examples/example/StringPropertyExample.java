package example;

import com.shimizukenta.property.IntegerCompution;
import com.shimizukenta.property.StringCompution;
import com.shimizukenta.property.StringProperty;

public class StringPropertyExample implements Runnable {

	public StringPropertyExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		try {
			
			System.out.println("run: " + this.getClass());
			System.out.println();
			
			/* build instance */
			StringProperty p = StringProperty.newInstance();
			
			/* getter */
			System.out.println("toString: \"" + p.toString() + "\"");
			System.out.println();
			
			/* setter */
			System.out.println("set: \"1st\"");
			p.set("1st");;
			System.out.println("toString: \"" + p.toString() + "\"");
			System.out.println();
			
			/* detect value changed */
			System.out.println("add change listener, 1st time notify present value.");
			p.addChangeListener(v -> {
				System.out.println("toString: \"" + v + "\"");
				System.out.println();
			});
			
			/* set value */
			System.out.println("set: \"2nd\"");
			p.set("2nd");
			
			new Thread(() -> {
				
				try {
					System.out.println("sleep 2000 msec...");
					Thread.sleep(2000L);
					
					p.set("3rd");
				}
				catch ( InterruptedException ignore ) {
				}
			}).start();
			
			System.out.println("Waiting until value is \"3rd\"");
			p.waitUntilEqualTo("3rd");
			System.out.println();
			
			
			IntegerCompution length = p.computeLength();
			length.addChangeListener(v -> {
				System.out.println("length: " + v);
				System.out.println();
			});
			
			StringCompution toUpperCase = p.computeToUpperCase();
			toUpperCase.addChangeListener(v -> {
				System.out.println("toUpperCase: \"" + v + "\"");
			});
			
			p.set("4th");
			
			System.out.println();
			System.out.println("reach end");
			
			StringProperty x = StringProperty.newInstance("AAA");
			StringProperty y = StringProperty.newInstance("BBB");
			StringProperty z = StringProperty.newInstance("CCC");
			
			StringCompution join = StringCompution.join(",", x, y, z);
			join.addChangeListener(v -> {
				System.out.println("join: " + v);
			});
			
			x.set("111");
			y.set("222");
			z.set("333");
			
		}
		catch ( InterruptedException ignore ) {
		}
	}
	
	public static void main(String[] args) {
		try {
			new StringPropertyExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
