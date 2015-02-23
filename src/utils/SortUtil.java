package utils;

public class SortUtil {
	/**
	 * call this when a.length is similar to b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] mergeSortedArrayWithCommonElements(int[] a, int[] b) {
		int i = 0;
		int curA = 0;
		int curB = 0;

		while (curA < a.length && curB < b.length) {
			if (a[curA] == b[curB] && (i == 0 || a[curA] != a[i-1])) {
				a[i++] = a[curA];
				curA++;
				curB++;
			} else if (a[curA] < b[curB]) {
				curA++;
			} else {
				curB++;
			}
		}

		while (i < a.length) {
			a[i++] = -1;
		}

		return a;
	}

	/**
	 * call this while a.length << b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] mergeSortedArrayWithCommonElementsII(int[] a, int[] b) {
		int i = 0;
		int left = 0;
		for (int key : a) {
			int index = binarySearch(b, left, b.length - 1, key);
			if (index >= 0 && (i == 0 || key != a[i-1])) {
				left = index + 1;
				a[i++] = key;
			}
		}

		while (i < a.length) {
			a[i++] = -1;
		}

		return a;
	}

	private static int binarySearch(int[] a, int left, int right, int key) {
		int start = left;
		int end = right;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
	
	/**
	 * a should have enough empty spots to contain elements in b.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] mergeSortedArrayInPlace(int[] a, int[] b) {
		int i = 0;
		while (i < a.length && a[i] != 0)
			i++;
		i--;
		int j = b.length - 1;
		int cur = a.length - 1;
		while (i >= 0 || j >= 0) {
			if (i >= 0 && j >= 0) {
				if (a[i] > b[j]) {
					a[cur--] = a[i];
					i--;
				} else {
					a[cur--] = b[j];
					j--;
				}
			} else if (j >= 0) {
				a[cur--] = b[j];
				j--;
			} else {
				break;
			}
		}
		
		return a;
	}
}
