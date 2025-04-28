package string;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * https://leetcode.com/problems/palindromic-substrings/description/
 * 
 * 
 */
public class PalindromicSubstringsCount {

	public static void main(String[] args) {
		PalindromicSubstringsCount psc = new PalindromicSubstringsCount();
		System.out.println(psc.countSubstrings("aaa"));
	}

	/**
	 * Time Complexity: O(n²) Space Complexity: O(1)
	 * 
	 * @param s
	 * @return
	 */
	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += countPalindrome(s, i, i);
			res += countPalindrome(s, i, i + 1);
		}
		return res;
	}

	int countPalindrome(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			count++;
		}
		return count;
	}
}
