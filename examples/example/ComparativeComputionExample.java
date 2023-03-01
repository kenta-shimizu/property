package example;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.IntegerProperty;

public class ComparativeComputionExample implements Runnable {

	public ComparativeComputionExample() {
		/* Nothing */
	}

	@Override
	public void run() {
		
		System.out.println("run: " + this.getClass());
		System.out.println();
		
		/* build instance */
		IntegerProperty a = IntegerProperty.newInstance(3);
		IntegerProperty b = IntegerProperty.newInstance(4);
		
		/* getter */
		System.out.println("get a: " + a.intValue());
		System.out.println("get b: " + b.intValue());
		System.out.println();
		
		BooleanCompution aGT3 = a.computeIsGreaterThan(3);
		BooleanCompution aEQ5 = a.computeIsEqualTo(5);
		BooleanCompution aLTb = a.computeIsLessThan(b);
		
		System.out.println("a >  3 : " + aGT3);
		System.out.println("a == 5 : " + aEQ5);
		System.out.println("a <  b : " + aLTb);
		
		System.out.println();
		System.out.println("set a: " + 5);
		a.set(5);
		
		System.out.println("a >  3 : " + aGT3);
		System.out.println("a == 5 : " + aEQ5);
		System.out.println("a <  b : " + aLTb);
	}

	public static void main(String[] args) {
		try {
			new ComparativeComputionExample().run();
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
	}

}
