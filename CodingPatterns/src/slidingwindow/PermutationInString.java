package slidingwindow;

/**
 * https://leetcode.com/problems/permutation-in-string/description/ Given two
 * strings s1 and s2, return true if s2 contains a permutation of s1, or false
 * otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 */
public class PermutationInString {

	public static void main(String[] args) {
		PermutationInString ps = new PermutationInString();
		String s1 = "hello";
		String s2 = "ooolleoooleh";
		System.out.println(ps.checkInclusion(s1, s2));
	}

	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;

		int[] s1Count = new int[26];
		int[] s2Count = new int[26];

		// Count the frequency of characters in s1 and the first window of s2
		for (int i = 0; i < s1.length(); i++) {
			s1Count[s1.charAt(i) - 'a']++;
			s2Count[s2.charAt(i) - 'a']++;
		}

		// Slide the window over s2
		for (int i = 0; i < s2.length() - s1.length(); i++) {
			if (matches(s1Count, s2Count))
				return true;
			// Update the window
			s2Count[s2.charAt(i) - 'a']--;
			s2Count[s2.charAt(i + s1.length()) - 'a']++;
		}

		// Check the last window
		return matches(s1Count, s2Count);
	}

	private boolean matches(int[] s1Count, int[] s2Count) {
		for (int i = 0; i < 26; i++) {
			if (s1Count[i] != s2Count[i])
				return false;
		}
		return true;
	}
}
