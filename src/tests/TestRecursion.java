package tests;

import utils.RecursionUtil;
import static org.junit.Assert.*;

public class TestRecursion implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestRecursion starts");
		TestPrintSolutionsOfHanoiTowers();
		TestMergeSort();
		TestQuickSort();
		TestCountInversions();
		System.out.println("TestRecursion ends");
	}

	private void TestPrintSolutionsOfHanoiTowers() {
		System.out.println("TestPrintSolutionsOfHanoiTowers starts");
		RecursionUtil.printSolutionsOfHanoiTowers(5);
		RecursionUtil.printSolutionsOfHanoiTowers(6);
		System.out.println("TestPrintSolutionsOfHanoiTowers ends");
	}

	private void TestMergeSort() {
		System.out.println("TestMergeSort starts");
		int[] test1 = {};
		RecursionUtil.mergeSort(test1);
		assertTrue(test1.length == 0);
		int[] test2 = { 5, 4, 6, 7 };
		RecursionUtil.mergeSort(test2);
		int j = 4;
		for (int i : test2) {
			assertTrue(i == j++);
		}
		int[] test4 = { 8, 5, 4, 6, 7 };
		RecursionUtil.mergeSort(test4);
		j = 4;
		for (int i : test2) {
			assertTrue(i == j++);
		}
		int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		RecursionUtil.mergeSort(test);
		int pre = test[0];
		for (int i : test) {
			assertTrue(i >= pre);
			pre = i;
		}
		System.out.println("TestMergeSort ends");

	}

	private void TestQuickSort() {
		System.out.println("TestQuickSort starts");
		int[] test1 = {};
		RecursionUtil.quickSort(test1);
		assertTrue(test1.length == 0);
		int[] test2 = { 5, 4, 6, 7 };
		RecursionUtil.quickSort(test2);
		int j = 4;
		for (int i : test2) {
			assertTrue(i == j++);
		}
		int[] test4 = { 8, 5, 4, 6, 7 };
		RecursionUtil.quickSort(test4);
		j = 4;
		for (int i : test2) {
			assertTrue(i == j++);
		}
		int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		RecursionUtil.quickSort(test);
		int pre = test[0];
		for (int i : test) {
			assertTrue(i >= pre);
			pre = i;
		}
		System.out.println("TestQuickSort ends");
	}

	private void TestCountInversions() {
		System.out.println("TestCountInversions starts");
		int[] test = { 4, 1, 2, 0 };
		assertEquals(5, RecursionUtil.countInversions(test));
		for (int i : test)
			System.out.print(" " + i + " ");
		System.out.println();
		int[] test1 = { 4, 1, 2, 0, -1 };
		assertEquals(9, RecursionUtil.countInversions(test1));
		for (int i : test1)
			System.out.print(" " + i + " ");
		System.out.println();
		System.out.println("TestCountInversions ends");
	}
}
