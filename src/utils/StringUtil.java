package utils;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 
	 * @param s a string contains number from 2 to 9
	 * @return a list of possible alphabet string based on phone keypad
	 */
	public static List<String> getAllPossibleStringsFromPhoneKeypad(String s) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		getAllPossibleStringsFromPhoneKeypad(s, s.length(), 0, result, sb);
		return result;
	}

	private static void getAllPossibleStringsFromPhoneKeypad(String s,
			int size, int step, List<String> result, StringBuilder sb) {
		if (step == size) {
			result.add(sb.toString());
			return;
		}

		char cur = s.charAt(step);
		char[] charDic = null;

		try {
			charDic = getCharDic(cur);
		} catch (IllegalArgumentException e) {
			System.out
					.println("Error: The character in the input string should be between 2 and 9!");
			return;
		}

		for (char c : charDic) {
			sb.append(c);
			getAllPossibleStringsFromPhoneKeypad(s, size, step + 1, result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static char[] getCharDic(char c) {
		switch (c) {
		case '2':
			return new char[] { 'A', 'B', 'C' };
		case '3':
			return new char[] { 'D', 'E', 'F' };
		case '4':
			return new char[] { 'G', 'H', 'I' };
		case '5':
			return new char[] { 'J', 'K', 'L' };
		case '6':
			return new char[] { 'M', 'N', 'O' };
		case '7':
			return new char[] { 'P', 'Q', 'R', 'S' };
		case '8':
			return new char[] { 'T', 'U', 'V' };
		case '9':
			return new char[] { 'W', 'X', 'Y', 'Z' };
		default:
			throw new IllegalArgumentException(
					"The input should be a number between 2 and 9!");
		}
	}
}
