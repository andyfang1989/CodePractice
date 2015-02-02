public class ArrayUtil {
	/**
	 * @param nums
	 *            an integer array
	 * @param index
	 *            the index used to separate the array
	 */
	public static void separateArrayByIndex(int[] nums, int index) {
		if (nums.length == 0 || index < 0 || index > nums.length - 1)
			throw new IllegalArgumentException("invalid input parameters");
		int start = 0;
		int end = nums.length - 1;
		int i = 0;
		int separator = nums[index];
		while (i <= end) {
			if (nums[i] < separator) {
				swap(nums, i, start);
				i++;
				start++;
			} else if (nums[i] == separator) {
				i++;
			} else {
				swap(nums, i, end);
				end--;
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
