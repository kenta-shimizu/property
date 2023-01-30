package propertytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.BooleanProperty;
import com.shimizukenta.property.IntegerProperty;
import com.shimizukenta.property.ListProperty;
import com.shimizukenta.property.LogicalCompution;
import com.shimizukenta.property.MapProperty;
import com.shimizukenta.property.ObjectProperty;

public class PropertyTest {

	public PropertyTest() {
		/* Nothing */
	}
	
	public static void main(String[] args) {
		
		try {
			final BooleanProperty boolProp = BooleanProperty.newInstance(false);
			final IntegerProperty intProp = IntegerProperty.newInstance(0);
			final ObjectProperty<String> objProp = ObjectProperty.newInstance(null);
			final MapProperty<String, String> mapProp = MapProperty.newInstance();
			final ListProperty<String> listProp = ListProperty.newInstance();
			
			listProp.computeSize().addChangeListener(v -> {
				System.out.println("List size: " + v.toString());
			});
			
			new Thread(() -> {
				try {
					Thread.sleep(1500L);
					boolProp.set(true);
					
					Thread.sleep(1000L);
					intProp.set(10);
					
					Thread.sleep(1000L);
					objProp.set("STRING");
					
					Thread.sleep(1000L);
					objProp.set(null);
					
					Thread.sleep(1000L);
					mapProp.put("KEY", "VALUE");
					
					Thread.sleep(1000L);
					listProp.add("AAA");
					
					Thread.sleep(1000L);
					listProp.clear();
				}
				catch ( InterruptedException ignore ) {
				}
			}).start();
			
			
			System.out.println("Waiting until boolProp is true.");
			boolProp.waitUntilTrue();
			System.out.println("boolProp is true.");
			System.out.println();
			
			System.out.println("Waiting until intProp is >5.");
			intProp.waitUntilGreaterThan(5);
			System.out.println("inrProp is >5.");
			System.out.println();
			
			System.out.println("Waiting until objProp is not null.");
			String objv = objProp.waitUntilNotNull();
			System.out.println("objProp is " + objv);
			System.out.println();
			
			System.out.println("Waiting until objProp is null.");
			objProp.waitUntilNull();
			System.out.println("objProp is null");
			System.out.println();
			
			System.out.println("Waiting until mapProp containsKey(\"KEY\").");
			String mapv = mapProp.waitUntilContainsKeyAndGet("KEY");
			System.out.println("mapProp get(\"KEY\") is " + mapv);
			System.out.println();
			
			System.out.println("Waiting until listProp is not empty.");
			listProp.waitUntilIsNotEmpty();
			System.out.println("listProp size is not empty.");
			System.out.println();
			
			System.out.println("Waiting until listProp is empty.");
			listProp.waitUntilIsEmpty();
			System.out.println("listProp size is empty.");
			System.out.println();
			
		}
		catch ( InterruptedException ignore ) {
		}
		
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
	
	protected static void threadStart(InterruptableRunnable r) {
		new Thread(() -> {
			try {
				r.run();
			}
			catch ( InterruptedException ignore ) {
			}
		}).start();
	}
	
	protected static void test1() throws InterruptedException {
		
		IntegerProperty a = IntegerProperty.newInstance(3);
		IntegerProperty b = IntegerProperty.newInstance(5);
		
		BooleanCompution aGT3 = a.isGreaterThan(3);
		System.out.println(aGT3.booleanValue());
		
		BooleanCompution aEQ5 = a.isEqualTo(5);
		System.out.println(aEQ5.booleanValue());
		
		BooleanCompution aLTb = a.isLessThan(b);
		System.out.println(aLTb.booleanValue());
		
		a.set(5);
		
		System.out.println(aGT3.booleanValue());
		System.out.println(aEQ5.booleanValue());
		System.out.println(aLTb.booleanValue());
		
		
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
			echo("map-toString: " + m.toString());
		});
		
		echo("");
		echo("put A-A");
		mp.put("A", "A");
		
		echo("");
		echo("put B-B");
		mp.put("B", "B");
		
		echo("");
		echo("put A-A");
		mp.put("A", "A");
		
		echo("");
		echo("put ifAbsent C-C");
		mp.putIfAbsent("C", "C");
		
		echo("");
		echo("putIfAbsent A-A2");
		mp.putIfAbsent("A", "A2");
		
		echo("");
		echo("put A-A3");
		mp.put("A", "A3");
		
		echo("");
		echo("computeIfPresent D-D");
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
			
			threadStart(() -> {
				Thread.sleep(500L);
				echo("");
				echo("try-put: A-AX");
				echo("");
				mp.put("A", "AX");
			});
			
			echo("");
			echo("wait-until-contain A");
			echo("Throught get: " + mp.waitUntilContainsKeyAndGet("A", 3L, TimeUnit.SECONDS));
			echo("Throught get: " + mp.waitUntilContainsKeyAndGet("A"));
			
			echo("wait-until-containsKey B: " + mp.waitUntilContainsKeyAndGet("B", 1L, TimeUnit.SECONDS));
		}
		catch ( TimeoutException e ) {
			echo(e);
		}
		catch ( Throwable t ) {
			echo(t);
		}
		
		return rr;
	};
	
}
