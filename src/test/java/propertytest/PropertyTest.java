package propertytest;

import java.util.concurrent.TimeUnit;

import com.shimizukenta.property.BooleanCompution;
import com.shimizukenta.property.BooleanProperty;
import com.shimizukenta.property.IntegerProperty;
import com.shimizukenta.property.TimeProperty;

public class PropertyTest {

	public PropertyTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		try {
			
			echo("Property-Test start.");
			
			final TimeProperty tp = TimeProperty.newInstance(0.5F);
			final BooleanProperty bp = BooleanProperty.newInstance(false);
			final IntegerProperty ip = IntegerProperty.newInstance(1);
			
			final BooleanCompution bc = BooleanCompution.not(bp);
			
			bp.addChangeListener(f -> {
				echo("bp changed: " + f);
			});
			
			ip.addChangeListener(n -> {
				echo("ip changed: " + n);
			});
			
			bc.addChangeListener(f -> {
				echo("bool-compution: " + f);
			});
			
			echo("try set false.");
			bp.set(false);
			echo("try set true.");
			bp.set(true);
			
			new Thread(() -> {
				try {
					tp.sleep();
					echo("try set false.");
					bp.set(false);
					tp.sleep();
					ip.set(3);
					tp.sleep();
					bp.set(true);
				}
				catch ( InterruptedException ignore ) {
				}
			}).start();
			
			echo("wait-until false.");
			bp.waitUntilFalse();
			
			echo("try set number-1");
			ip.set(1);
			echo("try set number-2");
			ip.set(2);
			
			echo("wait-until > 2.5");
			ip.waitUntilGreaterThan(2.5f, 3L, TimeUnit.SECONDS);
			
			echo("wait-until compute false.");
			bc.waitUntilFalse();
			
			echo("Property-Test end.");
			
		}
		catch ( Throwable t ) {
			echo(t);
		}
		
		/*
		 * Gettable
		 * Settable
		 * 
		 */
		
	}
	
	private static void echo(Object o) {
		if ( o instanceof Throwable ) {
			((Throwable) o).printStackTrace();
		} else {
			System.out.println(o);
		}
		
	}

}
