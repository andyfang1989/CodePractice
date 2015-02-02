import static org.junit.Assert.*;

public class TestArray implements TestUtilMethods {
	public void runTests() {
		System.out.println("TestArray starts");
		TestSeparateArrayByIndex();
		System.out.println("TestArray ends");
	}

	private void TestSeparateArrayByIndex() {
		System.out.println("TestSeparateArrayByIndex starts");
		int[] testSet = { 1, 6, 2, 5, 5, 4, 6, 2 };
		ArrayUtil.separateArrayByIndex(testSet, 4);
		for (int i = 0; i < 4; i++) {
			assertTrue(testSet[i] < 5);
		}
		for (int i = 4; i < 6; i++) {
			assertTrue(testSet[i] == 5);
		}
		for (int i = 6; i < 8; i++) {
			assertTrue(testSet[i] > 5);
		}
		System.out.println("TestSeparateArrayByIndex ends");
	}
}
