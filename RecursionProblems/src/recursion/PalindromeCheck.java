package recursion;

/**
 * Given a string s, return true if the string is palindrome, otherwise false. A
 * string is called palindrome if it reads the same forward and backward. Time
 * Complexity:The time complexity of the code is O(n) because it checks each
 * character from the start and end moving towards the center, which requires
 * n/2 recursive calls for a string of length n. Space Complexity:The space
 * complexity of the code is O(n) due to the recursion stack, which can go as
 * deep as n/2 calls in the worst case scenario.
 */
public class PalindromeCheck {

	public static void main(String[] args) {
		String s = "hannah";
		PalindromeCheck pc = new PalindromeCheck();
		System.out.println(pc.palindromeCheck(s));
	}

	public boolean palindromeCheck(String s) {
		return palindromeCheckString(s, 0, s.length() - 1);
	}

	boolean palindromeCheckString(String s, int left, int right) {
		if (left > right) {
			return true;
		} else {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
		}
		return palindromeCheckString(s, left + 1, right - 1);
	}
}
