package utils;

import java.util.ArrayList;
import java.util.List;

public class DPUtil {
	/**
	 * get combination in brute-force
	 * 
	 * @param values
	 * @param total
	 * @return
	 */
	public static List<ArrayList<Integer>> getPossibleCombination(int[] values,
			int total) {
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (values.length == 0)
			return result;
		int[] count = new int[values.length];
		getPossibleCombination(result, values, count, total, 0);
		return result;
	}

	private static void getPossibleCombination(List<ArrayList<Integer>> result,
			int[] values, int[] count, int total, int step) {
		if (step == count.length) {
			if (total == 0) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int i = 0; i < count.length; i++) {
					int num = count[i];
					while (num > 0) {
						temp.add(values[i]);
						num--;
					}
				}
				result.add(temp);
			}
			return;
		}

		int limit = total / values[step];
		for (int i = 0; i <= limit; i++) {
			count[step] = i;
			if (total - i * values[step] >= 0)
				getPossibleCombination(result, values, count, total - i
						* values[step], step + 1);
			else {
				break;
			}
		}
	}

	/**
	 * return the number of possible combinations
	 * 
	 * @param A
	 * @param total
	 * @return
	 */
	public static int getNumberOfCombinations(int[] A, int total) {
		int[] tracker = new int[total + 1];
		tracker[0] = 1;
		for (int i : A) {
			for (int k = i; k <= total; k++) {
				tracker[k] += tracker[k - i];
			}
		}
		return tracker[total];
	}

	/**
	 * 
	 * @param A
	 * @param total
	 * @return
	 */
	public static int getNumberOfPermutations(int[] A, int total) {
		int[] tracker = new int[total + 1];
		tracker[0] = 1;
		for (int i = 0; i <= total; i++) {
			for (int value : A) {
				if (i - value >= 0)
					tracker[i] += tracker[i - value];
			}
		}

		return tracker[total];
	}

	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static int getMinStepsOfConvertingString(String A, String B) {
		if (A.length() == 0)
			return B.length();

		if (B.length() == 0)
			return A.length();

		if (A.length() < B.length()) {
			String temp = B;
			B = A;
			A = temp;
		}

		int[] tracker = new int[B.length() + 1];
		for (int i = 1; i <= A.length(); i++) {
			int pre = tracker[0];
			tracker[0] = i;
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) != B.charAt(j - 1)) {
					int delete = tracker[j];
					int insert = tracker[j - 1];
					int replace = pre;
					pre = tracker[j];

					tracker[j] = Math.min(delete, Math.min(insert, replace)) + 1;
				} else {
					tracker[j] = pre;
				}
			}
		}

		return tracker[B.length()];
	}
}
