package example;

import com.shimizukenta.property.IntegerProperty;
import com.shimizukenta.property.NumberCompution;

public class NumberComputionExample implements Runnable {

	public NumberComputionExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		System.out.println("run: " + this.getClass());
		System.out.println();
		
		/* build instance */
		final IntegerProperty a = IntegerProperty.newInstance(1);
		final IntegerProperty b = IntegerProperty.newInstance(2);
		final IntegerProperty c = IntegerProperty.newInstance(3);
		
		/* getter */
		System.out.println("get a: " + a.intValue());
		System.out.println("get b: " + b.intValue());
		System.out.println("get c: " + c.intValue());
		System.out.println();
		
		/* build NumberCompution */
		NumberCompution addA2 = a.add(2);
		NumberCompution addBC = b.add(c);
		NumberCompution mulBC = b.multiply(c);
		NumberCompution subBC = b.subtract(c);
		NumberCompution negateA = a.negate();
		
		System.out.println("a + 2 = " + addA2.intValue());
		System.out.println("b + c = " + addBC.intValue());
		System.out.println("b * c = " + mulBC.intValue());
		System.out.println("b - c = " + subBC.intValue());
		System.out.println("-a = " + negateA.intValue());
		System.out.println();
		
		/* detect value changed */
		System.out.println("add change listeners, 1st time notify present status.");
		
		NumberCompution sumABC = NumberCompution.sum(a, b, c);
		sumABC.addChangeListener(v -> {
			System.out.println("sum(a, b, c): " + v);
		});
//			
		NumberCompution maxABC = NumberCompution.max(a, b, c);
		maxABC.addChangeListener(v -> {
			System.out.println("max(a, b, c): " + v);
		});
		
		NumberCompution minABC = NumberCompution.min(a, b, c);
		minABC.addChangeListener(v -> {
			System.out.println("min(a, b, c): " + v);
		});
		
		System.out.println();
		System.out.println("set a: " + 4);
		a.set(4);
		
		System.out.println();
		System.out.println("set b: " + 5);
		b.set(5);;
		
		System.out.println();
		System.out.println("set c: " + 6);
		c.set(6);;
		
		System.out.println();
		System.out.println("reach end");
	}

	public static void main(String[] args) {
		try {
			new NumberComputionExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
