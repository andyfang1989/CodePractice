package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import utils.DPUtil;

public class TestDP implements TestUtilMethods {
	@Override
	public void runTests() {
		System.out.println("TestDP starts");
		TestGetPossibleCombination();
		TestGetNumberOfCombinations();
		TestGetNumberOfPermutations();
		TestGetMinStepsOfConvertingString();
		System.out.println("TestDP ends");
	}

	private void TestGetPossibleCombination() {
		System.out.println("TestGetPossibleCombination starts");
		int[] values = { 2, 3, 7 };
		List<ArrayList<Integer>> result = DPUtil.getPossibleCombination(values,
				12);
		for (ArrayList<Integer> list : result) {
			int total = 0;
			for (int i : list) {
				System.out.print(" " + i + " ");
				total += i;
			}
			System.out.println();
			assertTrue(total == 12);
		}
		System.out.println("TestGetPossibleCombination ends");
	}

	private void TestGetNumberOfCombinations() {
		System.out.println("TestGetNumberOfCombinations starts");
		int[] values = { 2, 3, 7 };
		assertTrue(DPUtil.getNumberOfCombinations(values, 12) == 4);
		System.out.println("TestGetNumberOfCombinations ends");
	}

	private void TestGetNumberOfPermutations() {
		System.out.println("TestGetNumberOfPermutations starts");
		int[] values = { 2, 3, 7 };
		assertTrue(DPUtil.getNumberOfPermutations(values, 12) == 18);
		System.out.println("TestGetNumberOfPermutations ends");
	}

	private void TestGetMinStepsOfConvertingString() {
		System.out.println("TestGetMinStepsOfConvertingString starts");
		assertTrue(DPUtil.getMinStepsOfConvertingString("abcd", "") == 4);
		assertTrue(DPUtil.getMinStepsOfConvertingString("", "abcd") == 4);
		assertTrue(DPUtil.getMinStepsOfConvertingString("abc", "abcd") == 1);
		assertTrue(DPUtil.getMinStepsOfConvertingString("ac", "abc") == 1);
		assertTrue(DPUtil.getMinStepsOfConvertingString("asf", "asvd") == 2);
		System.out.println("TestGetMinStepsOfConvertingString ends");
	}
}
