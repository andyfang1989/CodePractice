package tests;

import static org.junit.Assert.*;
import utils.SortUtil;

public class TestSort implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestSort starts");
		TestMergeSortedArrayWithCommonElements();
		TestMergeSortedArrayWithCommonElementsII();
		TestMergeSortedArrayInPlace();
		System.out.println("TestSort ends");
	}

	private void TestMergeSortedArrayWithCommonElements() {
		System.out.println("TestMergeSortedArrayWithCommonElements starts");
		int[] a = { 4, 4, 5, 7, 9 };
		int[] b = { 4, 4, 7, 10 };
		int[] result = SortUtil.mergeSortedArrayWithCommonElements(a, b);
		assertEquals(result[0], 4);
		assertEquals(result[1], 7);
		assertEquals(result[4], -1);
		System.out.println("TestMergeSortedArrayWithCommonElements ends");
	}

	private void TestMergeSortedArrayWithCommonElementsII() {
		System.out.println("TestMergeSortedArrayWithCommonElementsII starts");
		int[] a = { 4, 4, 70 };
		int[] b = { 4, 4, 7, 8, 9, 10, 22, 25, 27, 29, 50, 70, 71, 79 };
		int[] result = SortUtil.mergeSortedArrayWithCommonElementsII(a, b);
		assertEquals(result[0], 4);
		assertEquals(result[1], 70);
		assertEquals(result[2], -1);
		System.out.println("TestMergeSortedArrayWithCommonElementsII ends");
	}
	
	private void TestMergeSortedArrayInPlace() {
		System.out.println("TestMergeSortedArrayInPlace starts");
		int[] a = { 4, 4, 7, 0, 0, 0, 0, 0};
		int[] b = { 4, 4, 7, 8, 9};
		int[] result = SortUtil.mergeSortedArrayInPlace(a, b);
		for (int i : result) {
			System.out.print(i + " , ");
		}
		System.out.println();
		int[] c = { 10, 11, 12, 0, 0, 0, 0, 0};
		int[] d = { 4, 4, 7, 8, 9};
		result = SortUtil.mergeSortedArrayInPlace(c, d);
		for (int i : result) {
			System.out.print(i + " , ");
		}
		System.out.println();
		int[] e = { 1, 2, 2, 0, 0, 0, 0, 0};
		int[] f = { 4, 4, 7, 8, 9};
		result = SortUtil.mergeSortedArrayInPlace(e, f);
		for (int i : result) {
			System.out.print(i + " , ");
		}
		System.out.println("TestMergeSortedArrayInPlace ends");
	}
}
