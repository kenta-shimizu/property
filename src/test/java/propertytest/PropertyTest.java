package propertytest;

import com.shimizukenta.property.*;

public class PropertyTest {

	public PropertyTest() {
		/* Nothing */
	}
	
	public static void main(String[] args) {
		
		try {
			test1();	//LogicalCompution
			test2();	//ComparativeCompution
			
		}
		catch ( Throwable t ) {
			echo(t);
		}
	}
	
	private static void echo(Object o) {
		if ( o instanceof Throwable ) {
			((Throwable) o).printStackTrace();
		} else {
			System.out.println(o);
		}
		
	}
	
	protected static void test1() {
		
		echo("");
		echo("Test-1 LogicalCompution");
		echo("");
		
		BooleanProperty b11 = BooleanProperty.newInstance(false);
		BooleanProperty b12 = BooleanProperty.newInstance(true);
		BooleanProperty b13 = BooleanProperty.newInstance(true);
		BooleanProperty b21 = BooleanProperty.newInstance(false);
		BooleanProperty b22 = BooleanProperty.newInstance(false);
		
		LogicalCompution lc1 = LogicalCompution.and(b11, b12, b13);
		lc1.addChangeListener(f -> {
			echo("and: " + f);
		});
		
		LogicalCompution lc2 = LogicalCompution.or(b21, b22);
		lc2.addChangeListener(f -> {
			echo(" or: " + f);
		});
		
		LogicalCompution lc3 = LogicalCompution.xor(lc1, lc2);
		lc3.addChangeListener(f -> {
			echo("xor: " + f);
		});
		
		LogicalCompution lc4 = LogicalCompution.not(lc3);
		lc4.addChangeListener(f -> {
			echo("not: " + f);
		});
		
		echo("");
		echo("b11: true");
		b11.set(true);
		
		echo("");
		echo("b21: true");
		b21.set(true);
		
		echo("");
		echo("b21: false");
		b21.set(false);
		
		echo("");
		echo("b13: false");
		b13.set(false);
	}
	
	protected static void test2() {
		
		echo("");
		echo("Test-2 ComparativeCompution");
		echo("");
		
		//TODO
	}
	
}
