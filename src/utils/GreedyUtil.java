package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyUtil {
	/**
	 * 
	 * @param h
	 *            an array of height
	 * @return water get tapped
	 */
	public static int getTappedWater(int[] h) {
		if (h.length <= 2)
			return 0;
		int len = h.length;
		int[] max = new int[len];

		for (int i = 1; i < len; i++) {
			max[i] = Math.max(max[i - 1], h[i]);
		}

		max[len - 1] = h[len - 1];
		int result = 0;
		for (int i = len - 2; i >= 1; i--) {
			result += Math.max(0, Math.min(max[i], max[i + 1]) - h[i]);
			max[i] = Math.max(max[i + 1], h[i]);
		}

		return result;
	}

	public static boolean threeSum(int[] num, int k) {
		if (num.length < 3)
			return false;

		Arrays.sort(num);
		for (int first = 0; first < num.length - 2; first++) {
			if (twoSum(num, k - first, first + 1)) {
				return true;
			}

			while (first + 1 < num.length - 2 && num[first + 1] == num[first])
				first++;
		}

		return false;
	}

	private static boolean twoSum(int[] num, int k, int start) {
		if (start >= num.length - 1)
			return false;

		int end = num.length - 1;
		while (start < end) {
			if (num[start] + num[end] == k) {
				return true;
			} else if (num[start] + num[end] < k) {
				start++;
			} else {
				end--;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param num
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> getThreeSumSets(int[] num, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return result;

		Arrays.sort(num);
		List<Integer> sample = new ArrayList<Integer>();
		for (int first = 0; first < num.length - 2; first++) {
			sample.add(num[first]);
			twoSum(num, k - num[first], first + 1, sample, result);
			sample.clear();
			while (first + 1 < num.length - 2 && num[first + 1] == num[first])
				first++;
		}

		return result;
	}

	private static void twoSum(int[] num, int k, int start,
			List<Integer> sample, List<List<Integer>> result) {
		if (start >= num.length - 1)
			return;

		int end = num.length - 1;
		while (start < end) {
			if (num[start] + num[end] == k) {
				sample.add(num[start]);
				sample.add(num[end]);
				result.add(new ArrayList<Integer>(sample));
				sample.remove(2);
				sample.remove(1);
				while (start + 1 < num.length && num[start + 1] == num[start])
					start++;
				while (end - 1 >= 0 && num[end - 1] == num[end])
					end--;

				start++;
				end--;
			} else if (num[start] + num[end] < k) {
				start++;
			} else {
				end--;
			}
		}
	}

	/**
	 * 
	 * @param gas
	 * @param usage
	 * @return
	 */
	public static int gasUp(int[] gas, int[] usage) {
		if (gas.length != usage.length)
			return -1;

		int total = 0;
		int cur = 0;
		int city = 0;
		for (int i = 0; i < gas.length; i++) {
			cur += gas[i] - usage[i];
			total += gas[i] - usage[i];
			if (cur < 0) {
				cur = 0;
				city = i + 1;
			}
		}

		if (total >= 0)
			return city;
		else
			return -1;
	}
}
