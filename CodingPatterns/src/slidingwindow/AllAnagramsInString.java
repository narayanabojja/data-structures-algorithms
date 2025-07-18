package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order. - Time Complexity: O(n
 * + m) - Space Complexity: O(n) in the worst case (due to the output list),
 * O(1) auxiliary
 * 
 */
public class AllAnagramsInString {

	public static void main(String[] args) {
		String s = "baa";
		String p = "aa";
		List<Integer> indices = new ArrayList<>();
		if (s.length() < p.length()) {
			System.out.println(indices);
		}
		int[] sFreq = new int[26];// Frequency of characters in s
		int[] pFreq = new int[26];// Frequency of characters in p

		// Initialize counts for p and the first window of s
		for (int i = 0; i < p.length(); i++) {
			sFreq[s.charAt(i) - 'a']++;
			pFreq[p.charAt(i) - 'a']++;
		}

		// Compare initial window
		if (Arrays.equals(sFreq, pFreq)) {
			indices.add(0);
		}
		int start = 0;
		int end = p.length();
		// Slide the window

		while (end < s.length()) {

			// Remove old character from the left
			sFreq[s.charAt(start) - 'a']--;
			// Add new character in the window
			sFreq[s.charAt(end) - 'a']++;
			// Compare window with pattern
			if (Arrays.equals(sFreq, pFreq)) {
				indices.add(start + 1);
			}
			start++;
			end++;
		}
		System.out.println(indices);
	}
}
