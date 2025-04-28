package string;

/**
 * A palindrome string is a string that is symmetrical when read forwards and
 * backwards Time complexity: O(n) Auxiliary Space: O(1)
 * https://www.geeksforgeeks.org/c-program-check-given-string-palindrome/
 * 
 * #Two Pointers
 */
public class PalindromeCheck {

	public static void main(String[] args) {

		System.out.println(palinDromeCheck("aba"));
	}

	static boolean palinDromeCheck(String str) {
		int low = 0;
		int high = str.length() - 1;
		while (low < high) {
			if (str.charAt(low) != str.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}
}
