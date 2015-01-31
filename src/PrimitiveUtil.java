
public class PrimitiveUtil {
	/**
	 * check bits parity for an array of 64-bit positive long numbers in a naive way.
	 * @param nums
	 * @return true if parity is 1, otherwise return false.
	 * @throws Exception 
	 */
    public static boolean getBitsParityNaively(long[] nums) {
    	int result = 0;
    	for (long num : nums) {
    		if (num < 0)
    			throw new IllegalArgumentException("Please ensure that the array doesn't contain negative long numbers!");
    		
    		for (int i = 0; i < 64 ; i++) {
    			result ^= (num>>i) & 1;
    		}
    	}

    	return result != 0;
    }
    
    public static boolean getBitsParityBetter(long[] nums) {
    	int result = 0;
    	for (long num : nums) {
    		if (num < 0)
    			throw new IllegalArgumentException("Please ensure that the array doesn't contain negative long numbers!");
    		
    		while (num > 0) {
    			result ^= 1;
    			num &= (num - 1); //This drop the lowest 1 bit.
    		}
    	}

    	return result != 0;
    }
}
