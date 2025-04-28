package string;

/**
 * An anagram string is a new string that is formed by rearranging the
 * characters of another string
 * https://leetcode.com/problems/valid-anagram/description/
 * 
 * # Hash Table
 */
public class AnagramChecker {

	/**
	 * Time Complexity: O(N), where N is the length of the string
	 * 
	 * Space Complexity: O(1) as no additional data structures are used
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean anagramStrings(String s, String t) {
		// Edge Cases
		if (s.length() != t.length())
			return false;

		// To store the count of each character
		int[] count = new int[26];

		// Count occurrence of each character in first string
		// Decrement the count for each character in the second string

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
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

		if (anagramStrings(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
	}
}
