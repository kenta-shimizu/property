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
			System.out.println("set: \"string\"");
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
			
			IntegerCompution length = p.computeLength();
			length.addChangeListener(v -> {
				System.out.println("length: " + v);
			});
			
			StringCompution toUpperCase = p.computeToUpperCase().computeTrim();
			toUpperCase.addChangeListener(v -> {
				System.out.println("toUpperCase: \"" + v + "\"");
			});
			
			StringCompution toLowerCase = p.computeToLowerCase().computeTrim();
			toLowerCase.addChangeListener(v -> {
				System.out.println("toLowerCase: \"" + v + "\"");
			});
			
			System.out.println();
			p.set("4tH ");
			
			Thread.sleep(1L);
			
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
