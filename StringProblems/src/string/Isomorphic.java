package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself. Time Complexity: O(n) space
 * complexity: O(1)
 */
public class Isomorphic {

	public static void main(String[] args) {
		String s = "bbbaaaba";
		String t = "aaabbbba";
		System.out.println(isIsomorphic(s, t));
	}

	static boolean isIsomorphic(String s, String t) {

		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			int sCount = sMap.getOrDefault(s.charAt(i), 0);
			int tCount = tMap.getOrDefault(t.charAt(i), 0);
			if (sCount != tCount) {
				return false;
			}
			sMap.put(s.charAt(i), i + 1);
			tMap.put(t.charAt(i), i + 1);
		}
		return true;
	}

	/**
	 * Initialize two arrays of size 256 (to cover all ASCII characters) to store
	 * the last seen positions of characters in both strings. This helps in tracking
	 * the mapping between characters. Iterate through each character in the strings
	 * simultaneously. For each character, compare the last seen positions stored in
	 * the arrays. If the positions do not match, it indicates an inconsistent
	 * mapping, and the strings are not isomorphic. If the positions match, update
	 * the arrays with the current index (incremented by 1 to avoid the default
	 * value of 0). This ensures that the mapping is consistent throughout the
	 * strings. After completing the iteration, if no inconsistencies in the
	 * mappings are found, the strings are confirmed to be isomorphic. If any
	 * inconsistency is found during the iteration, return false immediately.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isomorphicString(String s, String t) {
		// Arrays to store the last seen positions of characters in s and t
		int[] freqS = new int[256];
		int[] freqT = new int[256];
		// Iterate through each character in the strings
		for (int i = 0; i < s.length(); i++) {
			// If the last seen positions of the current characters don't match, return
			// false
			if (freqS[s.charAt(i)] != freqT[t.charAt(i)]) {
				return false;
			}
			// Update the last seen positions
			freqS[s.charAt(i)] = i + 1;
			freqT[t.charAt(i)] = i + 1;
		}
		// If all characters match, return true
		return true;
	}
}
