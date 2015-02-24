package tests;

import utils.RecursionUtil;

public class TestRecursion implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestRecursion starts");
		TestPrintSolutionsOfHanoiTowers();
		System.out.println("TestRecursion ends");
	}

	private void TestPrintSolutionsOfHanoiTowers() {
		System.out.println("TestPrintSolutionsOfHanoiTowers starts");
		RecursionUtil.printSolutionsOfHanoiTowers(5);
		RecursionUtil.printSolutionsOfHanoiTowers(6);
		System.out.println("TestPrintSolutionsOfHanoiTowers ends");
	}
}
