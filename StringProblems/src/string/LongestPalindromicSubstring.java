package string;

/**
 * Given a string s, return the longest palindromic substring in s.
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * #Two Pointers
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("babad"));
	}

	/**
	 * Time Complexity: O(n²) Space Complexity: O(1)
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int odd = countPalindrome(s, i, i);
			int even = countPalindrome(s, i, i + 1);
			int maxLen = Math.max(odd, even);
			if (maxLen > (end - start)) {
				start = i - ((maxLen - 1) / 2);
				end = i + (maxLen / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	int countPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	/**
	 * The intuition behind this logic lies in the **center-expansion technique** to
	 * find palindromes efficiently. Let's break it down:
	 * 
	 * 1. **Definition of a Palindrome**: A palindrome reads the same forward and
	 * backward. To identify palindromes within a string, it's useful to expand
	 * outward from a potential center and check for symmetry.
	 * 
	 * 2. **Single Character as a Center**: Each character in the string can serve
	 * as the center of an odd-length palindrome. For example, for the string
	 * "racecar", the center is the letter "e".
	 * 
	 * 3. **Two Adjacent Characters as a Center**: Two consecutive characters can
	 * serve as the center of an even-length palindrome. For example, in the string
	 * "abba", the center lies between "b" and "b".
	 * 
	 * 4. **Expand Around the Center**: Starting from the center (whether a single
	 * character or two adjacent characters), expand outward while the characters on
	 * the left and right sides remain equal. The moment a mismatch occurs, the
	 * palindrome ends.
	 * 
	 * 5. **Optimal Tracking**: To find the longest palindrome, keep track of the
	 * indices (`start` and `end`) of the current maximum-length palindrome.
	 * 
	 * 6. **Iterative Exploration**: Since any character or pair of adjacent
	 * characters can be a potential center, the algorithm iterates over all
	 * characters in the string, performing the center-expansion for both odd-length
	 * and even-length palindromes.
	 * 
	 * The reason this approach works well is that it systematically explores all
	 * possible palindromes in **linear steps from the center outward**, avoiding
	 * redundant computations by skipping substring-based checks that require
	 * additional space or time.
	 * 
	 * 
	 */
	/**
	 * Great question! Considering both odd-length and even-length palindromes is
	 * essential because palindromes can be symmetric in different ways, and we want
	 * to ensure we find the longest one regardless of its type.
	 * 
	 * 1. **Odd-Length Palindromes**: These have a single center character, and
	 * symmetry is maintained on both sides. For example, in "racecar", the center
	 * is the letter "e", and the palindrome expands outward equally.
	 * 
	 * 2. **Even-Length Palindromes**: These lack a single central character and
	 * instead have two adjacent characters at their center. For instance, in
	 * "abba", the center lies between the two "b"s, and the symmetry is maintained
	 * around this midpoint.
	 * 
	 * By separately handling odd and even lengths: - We ensure that every possible
	 * palindrome in the string is considered, regardless of its structure. - If we
	 * only check one type (e.g., odd-length), we might miss valid palindromes, like
	 * "abba". - This dual check guarantees that the algorithm works for **any**
	 * string, capturing both symmetrical patterns.
	 * 
	 * Neglecting one type would lead to incomplete results, which is why the logic
	 * explicitly considers both. It's a robust approach to comprehensively identify
	 * the longest palindrome. Hope this makes sense! 😊
	 */
}
