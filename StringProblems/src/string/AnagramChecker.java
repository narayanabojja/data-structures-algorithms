package string;

import java.util.HashMap;
import java.util.Map;

/**
 * An anagram string is a new string that is formed by rearranging the
 * characters of another string time complexity: O(n) space complexity: O(n)
 */
public class AnagramChecker {

	public static boolean areAnagrams(String str1, String str2) {

		// Remove spaces and convert to lowercase to make comparison case-insensitive
		str1 = str1.replaceAll("\\s", "").toLowerCase();
		str2 = str2.replaceAll("\\s", "").toLowerCase();

		// If lengths are different, they can't be anagrams
		if (str1.length() != str2.length()) {
			return false;
		}

		// Map to store character frequencies
		Map<Character, Integer> charFrequency = new HashMap<>();

		// Count frequency of characters in str1
		for (char c : str1.toCharArray()) {
			charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
		}

		// Decrease frequency for characters in str2
		for (char c : str2.toCharArray()) {
			int frequency = charFrequency.getOrDefault(c, 0);
			if (frequency == 0) {
				// If a character in str2 doesn't exist in str1, they can't be anagrams
				return false;
			} else {
				charFrequency.put(c, frequency - 1);
			}
		}

		// If all frequencies are zero, the strings are anagrams
		return true;
	}

	public boolean anagramStrings(String s, String t) {
		// Edge Cases
		if (s.length() != t.length())
			return false;

		// To store the count of each character
		int[] count = new int[26];

		// Count occurrence of each character in first string
		for (char c : s.toCharArray())
			count[c - 'a']++;

		// Decrement the count for each character in the second string
		for (char c : t.toCharArray())
			count[c - 'a']--;

		// Check for count of every character
		for (int i : count) {
			// If the count is not zero
			if (i != 0)
				return false; // Return false
		}

		// Otherwise strings are anagram
		return true;
	}

	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";

		if (areAnagrams(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
	}
}
