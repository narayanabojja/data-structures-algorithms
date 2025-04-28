package slidingwindow;

import java.util.HashMap;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * - Complexity:- Time Complexity: O(n), where n is the length of string s
 * (sliding window traverses s once). - Space Complexity: O(t + s) due to the
 * hashmaps (tMap and windowMap).
 * 
 * https://leetcode.com/problems/minimum-window-substring/description/
 * 
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}

		// Frequency map for characters in t
		HashMap<Character, Integer> tMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int minLength = Integer.MAX_VALUE;
		int matchCount = 0;
		int start = 0; // Start index of the minimum window substring

		// Frequency map for characters in the current window
		HashMap<Character, Integer> windowMap = new HashMap<>();

		while (right < s.length()) {
			char cRight = s.charAt(right);
			windowMap.put(cRight, windowMap.getOrDefault(cRight, 0) + 1);

			if (tMap.containsKey(cRight) && windowMap.get(cRight).intValue() == tMap.get(cRight).intValue()) {
				matchCount++;
			}

			while (matchCount == tMap.size()) {
				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					start = left;
				}

				char cLeft = s.charAt(left);
				windowMap.put(cLeft, windowMap.get(cLeft) - 1);

				if (tMap.containsKey(cLeft) && windowMap.get(cLeft).intValue() < tMap.get(cLeft).intValue()) {
					matchCount--;
				}

				left++;
			}

			right++;
		}

		return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring solution = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println("Minimum Window Substring: " + solution.minWindow(s, t));
	}
}