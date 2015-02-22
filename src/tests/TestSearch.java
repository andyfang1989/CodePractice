package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import utils.SearchUtil;

public class TestSearch implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestSearch starts");
		TestGetFirstOccurrenceInSortedArray();
		TestGetIntegerSquareRoot();
		TestgetSquareRoot();
		TestGetKthLargestElementInUnsortedDistinctArray();
		System.out.println("TestSearch ends");
	}

	private void TestGetFirstOccurrenceInSortedArray() {
		System.out.println("TestGetFirstOccurrenceInSortedArray starts");
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(5);
		assertTrue(SearchUtil.getFirstOccurrenceInSortedArray(list, 2) == 1);
		assertTrue(SearchUtil.getFirstOccurrenceInSortedArray(list, 7) == -1);
		assertTrue(SearchUtil.getFirstOccurrenceInSortedArray(list, 3) == -1);
		list.add(6);
		assertTrue(SearchUtil.getFirstOccurrenceInSortedArray(list, 4) == 3);
		System.out.println("TestGetFirstOccurrenceInSortedArray ends");
	}

	private void TestGetIntegerSquareRoot() {
		System.out.println("TestGetIntegerSquareRoot starts");
		assertTrue(SearchUtil.getIntegerSquareRoot(4) == 2);
		assertTrue(SearchUtil.getIntegerSquareRoot(1) == 1);
		assertTrue(SearchUtil.getIntegerSquareRoot(0) == 0);
		assertTrue(SearchUtil.getIntegerSquareRoot(300) == 17);
		System.out.println("TestGetIntegerSquareRoot ends");
	}

	private void TestgetSquareRoot() {
		System.out.println("TestgetSquareRoot starts");
		assertTrue(Math.abs(SearchUtil.getSquareRoot(4.0, 0.001) - 2.0) < 0.001);
		assertTrue(Math.abs(SearchUtil.getSquareRoot(0.0001, 0.0000001) - 0.01) < 0.001);
		assertTrue(Math.abs(SearchUtil.getSquareRoot(1.0, 0.001) - 1.0) < 0.001);
		assertTrue(Math.abs(SearchUtil.getSquareRoot(2.0, 0.0000001) - 1.4142) < 0.001);
		System.out.println("TestgetSquareRoot ends");
	}

	private void TestGetKthLargestElementInUnsortedDistinctArray() {
		System.out
				.println("TestGetKthLargestElementInUnsortedDistinctArray starts");
		int[] list = { 5, 1, 2, 4, 8, 6, 7, 9, 12, 10 };
		assertTrue(SearchUtil.getKthLargestElementInUnsortedDistinctArray(list,
				4) == 8);
		assertTrue(SearchUtil.getKthLargestElementInUnsortedDistinctArray(list,
				5) == 7);
		assertTrue(SearchUtil.getKthLargestElementInUnsortedDistinctArray(list,
				1) == 12);
		assertTrue(SearchUtil.getKthLargestElementInUnsortedDistinctArray(list,
				10) == 1);
		System.out
				.println("TestGetKthLargestElementInUnsortedDistinctArray ends");
	}
}
