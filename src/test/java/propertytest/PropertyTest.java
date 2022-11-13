package propertytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.shimizukenta.property.BooleanProperty;
import com.shimizukenta.property.LogicalCompution;
import com.shimizukenta.property.MapProperty;

public class PropertyTest {

	public PropertyTest() {
		/* Nothing */
	}
	
	public static void main(String[] args) {
		
		final List<TestModule> tests = Arrays.asList(
				testMap
				);
		
		try {
			for ( TestModule m : tests ) {
				for ( TestResult r : m.test() ) {
					if ( r.success() ) {
						echo(r.message());
					}
				}
			}
		}
		catch ( InterruptedException ignore ) {
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
	
	protected static void test1() throws InterruptedException {
		
		echo("");
		echo("# Test-1 LogicalCompution");
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
		echo("# Test-2 ComparativeCompution");
		echo("");
		
		//TODO
	}
	
	private static TestModule testMap = () -> {
		
		final List<TestResult> rr = new ArrayList<>();
		
		echo("");
		echo("# Test-MAP");
		echo("");
		
		final MapProperty<String, String> mp = MapProperty.newInstance();
		
		mp.addChangeListener(m -> {
			echo("map-size: " + m.size());
		});
		
		echo("");
		echo("put A");
		mp.put("A", "A");
		
		echo("");
		echo("put B");
		mp.put("B", "B");
		
		echo("");
		echo("put A");
		mp.put("A", "A");
		
		echo("");
		echo("put ifAbsent C");
		mp.putIfAbsent("C", "C");
		
		echo("");
		echo("put ifAbsent A value A2");
		mp.putIfAbsent("A", "A2");
		
		echo("");
		echo("put A value C");
		mp.put("A", "A3");
		echo("A is " + mp.get("A"));
		
		echo("");
		echo("computeIfPresent D value D");
		mp.computeIfPresent("D", (key, v) -> "D");
		
		echo("");
		echo("remove A");
		mp.remove("A");
		
		echo("");
		echo("clear");
		mp.clear();
		
		try {
			echo("");
			echo("wait-until-NOT-contain A");
			mp.waitUntilNotContainsKey("A");
			echo("wait-until-NOT throught");
			mp.waitUntilNotContainsKey("A", 1L, TimeUnit.SECONDS);
			echo("wait-until-NOT throught");
			
			new Thread(() -> {
				try {
					Thread.sleep(500L);
					echo("");
					echo("try-put: A-AX");
					echo("");
					mp.put("A", "AX");
				}
				catch ( InterruptedException ignore ) {
				}
			}).start();
			
			echo("");
			echo("wait-until-contain A");
			echo("Throught get: " + mp.waitUntilContainsKey("A", 1L, TimeUnit.SECONDS));
			echo("Throught get: " + mp.waitUntilContainsKey("A"));
			
			echo("wait-until-containsKey B: " + mp.waitUntilContainsKey("B", 1L, TimeUnit.SECONDS));
		}
		catch ( Throwable t ) {
			t.printStackTrace();
		}
		
		return rr;
	};
	
}
