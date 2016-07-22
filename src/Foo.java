import java.io.IOException;

//Other fields and methods, all fields are final }
final class Foo {
	private Helper helper = null;
	public Helper getHelper() { 
		if (helper == null) {
			synchronized (this) { 
				if (helper == null) {
					helper = new Helper(5); 
					}
			} 
		}
		return helper; 
	}
	
	public void testCase(){
		Thread test = new Thread(new Runnable() {
			public void run() {
				Foo testF = new Foo();
				testF.getHelper();
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		
		testCase(); // starts thread 1 
		testCase(); // starts thread 2
	}
}