package tests;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

import utils.StringUtil;

public class TestString implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestString starts");
		TestGetIntegerFromString();
		TestGetAllPossibleStringsFromPhoneKeypad();
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

	private void TestGetAllPossibleStringsFromPhoneKeypad() {
		System.out.println("TestGetAllPossibleStringsFromPhoneKeypad starts");
		StringUtil.getAllPossibleStringsFromPhoneKeypad("1");
		List<String> result = StringUtil.getAllPossibleStringsFromPhoneKeypad("24");
		HashSet<String> benchmark = new HashSet<String>();
		benchmark.add("AG");
		benchmark.add("AH");
		benchmark.add("AI");
		benchmark.add("BG");
		benchmark.add("BH");
		benchmark.add("BI");
		benchmark.add("CG");
		benchmark.add("CH");
		benchmark.add("CI");
		for (String s : result) {
			assertTrue(benchmark.remove(s));
		}
		assertEquals(0, benchmark.size());
		System.out.println("TestGetAllPossibleStringsFromPhoneKeypad ends");
	}
}
