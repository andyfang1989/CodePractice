import java.util.Random;

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

	/**
	 * 
	 * @param prices
	 *            prices record of consecutive trading days
	 * @return max profit with just one trade
	 */
	public static int getMaxProfitWithOneTrade(int[] prices) {
		if (prices.length <= 1)
			return 0;

		int result = 0;
		int min = prices[0];
		int len = prices.length;
		for (int i = 1; i < len; i++) {
			min = Math.min(min, prices[i]);
			result = Math.max(result, prices[i] - min);
		}

		return result;
	}

	/**
	 * 
	 * @param nums
	 * @return longest length of equal entries in an integer array
	 */
	public static int getLongestLengthOfEqualEntries(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;

		int startIndex = 0;
		int startValue = nums[0];
		int result = 1;
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			if (nums[i] == startValue) {
				result = Math.max(result, i - startIndex + 1);
			} else {
				startIndex = i;
				startValue = nums[i];
			}
		}

		return result;
	}
	
	/**
	 * the same array with k random subset placed at the end after this execution
	 * @param nums an array of integer numbers
	 * @param k number of subset 
	 */
	public static void getKRandomNumberFromArray(int[] nums, int k) {
		int len = nums.length;
		if (k > len) 
			throw new IllegalArgumentException("k should be equal or less than the length of the array input!");
		Random ran = new Random();
		int count = 0;
		while (count < k) {
			int ranNum = ran.nextInt(Integer.MAX_VALUE);
			swap(nums, ranNum % (len - count), len - count - 1);
			count++;
		}
	}
	
	/**
	 * 
	 * @param n the 2D array size, here we assume that it's a square array
	 */
	public static void print2DArrayAtSpiralOrder(int[][] input) {
		if (input.length <= 0 || input[0].length <= 0 || input.length != input[0].length)
			throw new IllegalArgumentException("the input should be a n*n array!");
		
		int size = input.length;
		int row = 0;
		int col = 0;
		while (size > 0) {
			if (size == 1){
				System.out.print(input[row][col] + " ");
				size = 0;
			} else {
				for (int i = 0; i < size - 1; i++)
					System.out.print(input[row][col++] + " ");
				for (int i = 0; i < size - 1; i++)
					System.out.print(input[row++][col] + " ");
				for (int i = 0; i < size - 1; i++)
					System.out.print(input[row][col--] + " ");
				for (int i = 0; i < size - 1; i++)
					System.out.print(input[row--][col] + " ");
				row++;
				col++;
				size-=2;
			}
		}
	}
}
