package tests;
import static org.junit.Assert.*;
import utils.ArrayUtil;

public class TestArray implements TestUtilMethods {
	public void runTests() {
		System.out.println("TestArray starts");
		TestSeparateArrayByIndex();
		TestGetMaxProfitWithOneTrade();
		TestGetLongestLengthOfEqualEntries();
		TestGetKRandomNumberFromArray();
		TestPrint2DArrayAtSpiralOrder();
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
	
	private void TestGetMaxProfitWithOneTrade() {
		System.out.println("TestGetMaxProfitWithOneTrade starts");
		int[] testSet = { 1, 6, 2, 5, 5, 4, 6, 2 };
		int profit = ArrayUtil.getMaxProfitWithOneTrade(testSet);
		assertEquals(5, profit);
		System.out.println("TestGetMaxProfitWithOneTrade ends");
	}
	
	private void TestGetLongestLengthOfEqualEntries() {
		System.out.println("TestGetLongestLengthOfEqualEntries starts");
		int[] testSet = { 1, 6, 2, 2, 5, 5, 4, 6, 2, 2, 2, 7, 7, 7, 7 };
		int len = ArrayUtil.getLongestLengthOfEqualEntries(testSet);
		assertEquals(4, len);
		System.out.println("TestGetLongestLengthOfEqualEntries ends");
	}
	
	private void TestGetKRandomNumberFromArray() {
		System.out.println("TestGetKRandomNumberFromArray starts");
		int[] testSet = new int[10];
		for (int i = 0; i < 10; i++) {
			testSet[i] = i + 1;
		}
		ArrayUtil.getKRandomNumberFromArray(testSet, 1);
		System.out.println("k = 1");
		for (int i : testSet)
			System.out.println(i);
		ArrayUtil.getKRandomNumberFromArray(testSet, 4);
		System.out.println("k = 4");
		for (int i : testSet)
			System.out.println(i);
		ArrayUtil.getKRandomNumberFromArray(testSet, 10);
		System.out.println("k = 10");
		for (int i : testSet)
			System.out.println(i);
		System.out.println("TestGetKRandomNumberFromArray ends");
	}
	
	private void TestPrint2DArrayAtSpiralOrder() {
		System.out.println("TestPrint2DArrayAtSpiralOrder starts");
		int[][] testSet = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				System.out.print(testSet[i][j] + " ");
		System.out.println();
		ArrayUtil.print2DArrayAtSpiralOrder(testSet);
		System.out.println();
		System.out.println("TestPrint2DArrayAtSpiralOrder ends");
	}
}
