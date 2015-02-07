public class StringUtil {
	/**
	 * 
	 * @param s
	 *            a string number
	 * @return a integer type of the corresponding number
	 */
	public static int getIntegerFromString(String s) {
		if (s.length() == 0)
			throw new IllegalArgumentException();

		boolean positive = true;
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			if (s.charAt(0) == '-')
				positive = false;
			s = s.substring(1);
		}
		int len = s.length();
		int div = 1;
		int result = 0;
		for (int i = len - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c < '0' || c > '9')
				throw new IllegalArgumentException();
			result += (c - '0') * div;
			div *= 10;
		}

		return positive ? result : -1 * result;
	}
}
