package propertytest;

public class TestResult {
	
	private final boolean success;
	private final String msg;
	
	public TestResult(boolean success, CharSequence msg) {
		this.success = success;
		this.msg = msg.toString();
	}
	
	public boolean success() {
		return this.success;
	}
	
	public String message() {
		return this.msg;
	}
}
