package tests;

import static org.junit.Assert.*;

import java.util.List;

import utils.GreedyUtil;

public class TestGreedy implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestGreedy starts");
		TestGetTappedWater();
		TestThreeSum();
		TestGetThreeSumSets();
		TestGasUp();
		System.out.println("TestGreedy ends");
	}

	private void TestGetTappedWater() {
		System.out.println("TestGetTappedWater starts");
		int[] h = { 1, 4, 2, 5, 1, 7, 2 };
		assertTrue(GreedyUtil.getTappedWater(h) == 6);
		System.out.println("TestGetTappedWater ends");
	}

	private void TestThreeSum() {
		System.out.println("TestThreeSum starts");
		int[] num = { 1, 4, 2, 5, 1, 7, 2 };
		assertTrue(GreedyUtil.threeSum(num, 7));
		assertTrue(GreedyUtil.threeSum(num, 16));
		assertFalse(GreedyUtil.threeSum(num, 17));
		System.out.println("TestThreeSum ends");
	}

	private void TestGetThreeSumSets() {
		System.out.println("TestGetThreeSumSet starts");
		int[] num = { -1, 0, 1, -1, 1, -1, -2, 0, 2, -4, 4, -2 };
		List<List<Integer>> result = GreedyUtil.getThreeSumSets(num, 0);
		for (List<Integer> list : result) {
			System.out.print("[");
			for (int i : list)
				System.out.print(" " + i + " ");
			System.out.print("]");
			System.out.println();
		}
		System.out.println("TestGetThreeSumSet ends");
	}

	private void TestGasUp() {
		System.out.println("TestGasUp starts");
		int[] gas = { 30, 20, 10, 5, 10 };
		int[] usage = { 20, 10, 30, 10, 5 };
		assertEquals(4, GreedyUtil.gasUp(gas, usage));
		int[] gas1 = { 30, 20, 10, 5, 10 };
		int[] usage1 = { 20, 10, 30, 10, 6 };
		assertEquals(-1, GreedyUtil.gasUp(gas1, usage1));
		System.out.println("TestGasUp ends");
	}
}
