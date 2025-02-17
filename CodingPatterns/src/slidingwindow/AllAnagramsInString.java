package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.time complexity: o(n)
 * space complexity: o(1)
 */
public class AllAnagramsInString {

	public static void main(String[] args) {
		String s = "baa";
		String p = "aa";
		List<Integer> indices = new ArrayList<>();
		if (s.length() < p.length()) {
			System.out.println(indices);
		}
		int[] sFreq = new int[26];
		int[] pFreq = new int[26];

		for (int i = 0; i < p.length(); i++) {
			sFreq[s.charAt(i) - 'a']++;
			pFreq[p.charAt(i) - 'a']++;
		}
		if (Arrays.equals(sFreq, pFreq)) {
			indices.add(0);
		}
		int start = 0;
		int end = p.length();
		while (end < s.length()) {
			sFreq[s.charAt(start) - 'a']--;
			sFreq[s.charAt(end) - 'a']++;
			if (Arrays.equals(sFreq, pFreq)) {
				indices.add(start + 1);
			}
			start++;
			end++;
		}
		System.out.println(indices);
	}
}
