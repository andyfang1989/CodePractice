public class TestMain {
	public static void main(String[] args) {
		TestPrimitive testPrimitive = new TestPrimitive();
		testPrimitive.runTests();
		TestArray testArray = new TestArray();
		testArray.runTests();
		TestString testString = new TestString();
		testString.runTests();
	}
}
