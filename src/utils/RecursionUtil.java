package utils;

public class RecursionUtil {
	private static int step = 1;
    
	public static void printSolutionsOfHanoiTowers(int n) {
		step = 1;
		printSolutionsOfHanoiTowers(n, 0);
	}
	
	private static void printSolutionsOfHanoiTowers(int n, int start) {
		if (n == 3) {
			printBasicSteps(start);
			return;
		}
		printSolutionsOfHanoiTowersReverse(n - 1, start);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 1) % 3);
		printSolutionsOfHanoiTowersReverse(n - 1, (start + 2) % 3);
	}

	private static void printSolutionsOfHanoiTowersReverse(int n, int start) {
		if (n == 3) {
			printBasicStepsReverse(start);
			return;
		}

		printSolutionsOfHanoiTowers(n - 1, start);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 2) % 3);
		printSolutionsOfHanoiTowers(n - 1, (start + 1) % 3);
	}

	private static void printBasicSteps(int start) {
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 1) % 3);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 2) % 3);
		System.out.println("Step " + step++ + ": From " + (start + 1) % 3
				+ " To " + (start + 2) % 3);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 1) % 3);
		System.out.println("Step " + step++ + ": From " + (start + 2) % 3
				+ " To " + start);
		System.out.println("Step " + step++ + ": From " + (start + 2) % 3
				+ " To " + (start + 1) % 3);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 1) % 3);
	}

	private static void printBasicStepsReverse(int start) {
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 2) % 3);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 1) % 3);
		System.out.println("Step " + step++ + ": From " + (start + 2) % 3
				+ " To " + (start + 1) % 3);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 2) % 3);
		System.out.println("Step " + step++ + ": From " + (start + 1) % 3
				+ " To " + start);
		System.out.println("Step " + step++ + ": From " + (start + 1) % 3
				+ " To " + (start + 2) % 3);
		System.out.println("Step " + step++ + ": From " + start + " To "
				+ (start + 2) % 3);
	}
}
