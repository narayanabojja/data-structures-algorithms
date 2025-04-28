package string;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * https://leetcode.com/problems/valid-palindrome/description/
 * 
 * #Two Pointers
 * 
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}

	/**
	 * Time Complexity: O(n) Space Complexity: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {

		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			char chf = s.charAt(start);
			char chl = s.charAt(end);
			if (!Character.isLetterOrDigit(chf)) {
				start++;
			} else if (!Character.isLetterOrDigit(chl)) {
				end--;
			} else if (chf != chl) {
				return false;
			} else {
				start++;
				end--;
			}
		}
		return true;
	}
}
