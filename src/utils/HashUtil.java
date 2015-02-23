package utils;

import java.util.HashMap;

public class HashUtil {
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
    public static boolean checkAnagram(String s1, String s2) {
    	if (s1.length() != s2.length())
    		return false;
    	int len = s1.length();
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < len; i++) {
    		char c = s1.charAt(i);
    		if (map.containsKey(c)) {
    			map.put(c, map.get(c) + 1);
    		} else {
    			map.put(c, 1);
    		}
    	}
    	
    	for (int i = 0; i < len; i++) {
    		char c = s2.charAt(i);
    		if (map.containsKey(c)) {
    			map.put(c, map.get(c) - 1);
    			if (map.get(c) < 0)
    				return false;
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
