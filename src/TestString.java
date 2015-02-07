import static org.junit.Assert.*;

public class TestString implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestString starts");
		TestGetIntegerFromString();
		System.out.println("TestString ends");
	}

	private void TestGetIntegerFromString() {
		System.out.println("TestGetIntegerFromString starts");
		assertEquals(124, StringUtil.getIntegerFromString("124"));
		assertEquals(-124, StringUtil.getIntegerFromString("-124"));
		assertEquals(124, StringUtil.getIntegerFromString("+124"));
		assertEquals(1, StringUtil.getIntegerFromString("1"));
		System.out.println("TestGetIntegerFromString ends");
	}

}
