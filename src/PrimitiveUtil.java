
public class PrimitiveUtil {
	/**
	 * check bits parity for an array of 64-bit positive long numbers in a naive way.
	 * @param nums
	 * @return true if parity is 1, otherwise return false.
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
    
    /**
	 * check bits parity for an array of 64-bit positive long numbers in a more effective way.
	 * @param nums
	 * @return true if parity is 1, otherwise return false.
	 */
    public static boolean getBitsParityBetter(long[] nums) {
    	int result = 0;
    	for (long num : nums) {
    		if (num < 0)
    			throw new IllegalArgumentException("Please ensure that the array doesn't contain negative long numbers!");
    		
    		while (num > 0) {
    			result ^= 1;
    			num &= (num - 1); //num &= (num - 1) will drop the lowest set, while num &= ~(num - 1) will retain the lowest set only.
    		}
    	}

    	return result != 0;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return x^y without considering overflow.
     */
    public static double pow(double x, int y) {
    	if (y < 0)
    		return 1/powPositive(x, -1*y);
    	else
    		return powPositive(x, y);
    }
    
    private static double powPositive(double x, int y) {
    	if (y == 0)
    		return 1.0;
    	
    	double half = powPositive(x, y/2);
    	if (y%2 == 0)
    		return half*half;
    	else
    		return half*half*x;
    }
    
    /**
     * 
     * @param b1 b1 should be between 2 and 16
     * @param b2 b2 should be between 2 and 16
     * @param num the number to be converted, it should be an integer
     * @return the number converted from base b1 to base b2, time complexity is n + logb2(b1^n) = n(1+logb2(b1))
     */
    public static String convertBase(int b1, int b2, String num) {
    	if (b1 <2 || b1 > 16 || b2 < 2 || b2 > 16 || num.length() == 0)
    		throw new IllegalArgumentException("b1 or b2 should be between 2 and 16!");
    	
    	if (b1 == b2)
    		return num;
    	
    	boolean positive = true;
        if (num.charAt(0) == '-') {
        	positive = false;
        	num = num.substring(1);
        }
        
        //convert to base 10
        int x = 0;
        int div = 1;
        if (b1 != 10) {
        	for (int i = num.length() - 1; i >= 0; i--) {
        		x += getRealNumber(num.charAt(i)) * div;
        		div *= b1;
        	}
        } else {
        	x = Integer.parseInt(num);
        }
        
        if (b2 == 10)
        	return positive ? String.valueOf(x) : "-" + String.valueOf(x);
        	
        //convert to base b2
        StringBuilder result = new StringBuilder();
        while (x > 0) {
        	result.append(getFakeNumber(x % b2));
        	x /= b2;
        }
        
        return positive ? result.reverse().toString() : "-" + result.reverse().toString();
    }
    
    private static int getRealNumber(char c) {
    	if (c == 'A')
    		return 10;
    	else if (c == 'B')
    		return 11;
    	else if (c == 'C')
    		return 12;
    	else if (c == 'D')
    		return 13;
    	else if (c == 'E')
    		return 14;
    	else if (c == 'F')
    		return 15;
    	
    	return Character.getNumericValue(c);
    }
    
    private static char getFakeNumber(int n) {
    	if (n == 10)
    		return 'A';
    	else if (n == 11)
    		return 'B';
    	else if (n == 12)
    		return 'C';
    	else if (n == 13)
    		return 'D';
    	else if (n == 14)
    		return 'E';
    	else if (n == 15)
    		return 'F';
    	
    	return (char)((int)('0') + n);
    }
}
