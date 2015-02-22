package utils;

import java.util.List;
import java.util.Random;

public class SearchUtil {
	/**
	 * 
	 * @param list
	 *            a list of comparable items
	 * @param k
	 *            a key
	 * @return the index of first occurrence of k, return -1 if k is not found.
	 */
	public static <T extends Comparable<T>> int getFirstOccurrenceInSortedArray(
			List<T> list, T k) {
		if (list.size() == 0)
			return -1;

		int len = list.size();
		int start = 0;
		int end = len - 1;
		int result = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (list.get(mid).compareTo(k) > 0) {
				end = mid - 1;
			} else if (list.get(mid).compareTo(k) < 0) {
				start = mid + 1;
			} else {
				result = mid;
				end = mid - 1;
			}
		}

		return result;
	}

	/**
	 * 
	 * @param n
	 * @return largest int having square value smaller or equals to n
	 */
	public static int getIntegerSquareRoot(int n) {
		if (n < 0)
			throw new IllegalArgumentException(
					"n should be a nonpositive integer");

		long start = 0;
		long end = n;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			long square = mid * mid;
			if (square < (long) n) {
				start = mid + 1;
			} else if (square > n) {
				end = mid - 1;
			} else {
				return (int) mid;
			}
		}

		return (int) (start - 1);
	}

	/**
	 * 
	 * @param n
	 * @param precision
	 * @return
	 */
	public static double getSquareRoot(double n, double precision) {
		if (n < 0)
			throw new IllegalArgumentException(
					"n should be a nonpositive double");

		double start = 1.0;
		double end = n;
		if (n < 1.0) {
			start = n;
			end = 1.0;
		}

		while (compareDouble(start, end, precision) <= 0) {
			double mid = start + (end - start) / 2;
			double square = mid * mid;
			if (compareDouble(square, n, precision) < 0) {
				start = mid;
			} else if (compareDouble(square, n, precision) > 0) {
				end = mid;
			} else {
				return mid;
			}
		}

		return start;
	}

	private static int compareDouble(double a, double b, double precision) {
		if (Math.abs(a - b) <= precision)
			return 0;
		else
			return a > b ? 1 : -1;
	}

	public static int getKthLargestElementInUnsortedDistinctArray(int[] ar,
			int k) {
		int start = 0;
		int end = ar.length - 1;
		int result = 0;
		Random ran = new Random();

		while (start <= end) {
			int splitter = ar[start + ran.nextInt(end - start + 1)];
			int p = reorderArray(ar, splitter, start, end);
			if (p == k - 1) {
				result = p;
				break;
			} else if (p > k - 1) {
				end = p - 1;
			} else {
				start = p + 1;
			}
		}

		return ar[result];
	}

	private static int reorderArray(int[] ar, int s, int left, int right) {
		int start = left;
		int end = right;
		int cur = left;
		while (cur <= end) {
			if (ar[cur] < s) {
				swap(ar, cur, end);
				end--;
			} else if (ar[cur] > s) {
				swap(ar, start, cur);
				cur++;
				start++;
			} else {
				cur++;
			}
		}

		return cur - 1;
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
}
