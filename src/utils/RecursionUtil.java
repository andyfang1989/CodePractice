package utils;

public class RecursionUtil {
	private static int step = 1;
	private static int inversionCount = 0;

	/**
	 * 
	 * @param n
	 */
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

	/**
	 * 
	 * @param A
	 * @return
	 */
	public static void mergeSort(int[] A) {
		int[] B = new int[A.length];
		mergeSort(A, B, 0, A.length - 1);
	}

	private static void mergeSort(int[] A, int[] B, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(A, B, start, mid);
			mergeSort(A, B, mid + 1, end);
			merge(A, B, start, mid, end);
		}
	}

	private static void merge(int[] A, int[] B, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int cur = start;
		for (int k = start; k <= end; k++)
			B[k] = A[k];

		while (i <= mid || j <= end) {
			if (i <= mid && j <= end) {
				if (B[i] < B[j]) {
					A[cur++] = B[i++];
				} else {
					A[cur++] = B[j++];
				}
			} else if (i <= mid) {
				A[cur++] = B[i++];
			} else {
				A[cur++] = B[j++];
			}
		}
	}

	/**
	 * 
	 * @param A
	 */
	public static void quickSort(int[] A) {
		if (A.length <= 1)
			return;
		quickSort(A, 0, A.length - 1);
	}

	private static void quickSort(int[] A, int start, int end) {
		int pivot = A[start];
		int i = start;
		int j = end;
		int cur = start;
		while (cur <= j) {
			if (A[cur] < pivot) {
				swap(A, i, cur);
				cur++;
				i++;
			} else if (A[cur] > pivot) {
				swap(A, cur, j);
				j--;
			} else {
				cur++;
			}
		}

		if (start < i)
			quickSort(A, start, cur - 1);

		if (j < end)
			quickSort(A, cur, end);
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	/**
	 * if i < j and A[i] > A[j] then (i, j) is a pair of inversion
	 * 
	 * @param A
	 * @return the number of inversion in an array.
	 */
	public static int countInversions(int[] A) {
		inversionCount = 0;
		if (A.length <= 1)
			return inversionCount;

		int[] helper = new int[A.length];
		countAndSort(A, helper, 0, A.length - 1);
		return inversionCount;
	}

	private static void countAndSort(int[] A, int[] helper, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			countAndSort(A, helper, start, mid);
			countAndSort(A, helper, mid + 1, end);
			countAndMerge(A, helper, start, mid, end);
		}
	}

	private static void countAndMerge(int[] A, int[] helper, int start,
			int mid, int end) {
		for (int i = start; i <= end; i++)
			helper[i] = A[i];

		int i = start;
		int j = mid + 1;
		int cur = start;
		while (i <= mid || j <= end) {
			if (i <= mid && j <= end) {
				if (helper[i] <= helper[j]) {
					A[cur++] = helper[i++];
				} else {
					inversionCount = inversionCount + (mid - i + 1);
					A[cur++] = helper[j++];
				}
			} else if (i <= mid) {
				A[cur++] = helper[i++];
			} else {
				A[cur++] = helper[j++];
			}
		}
	}
}
