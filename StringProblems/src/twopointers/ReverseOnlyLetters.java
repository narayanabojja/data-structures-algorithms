package twopointers;

/**
 * Given a string s, reverse the string according to the following rules:
 * 
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed. Return s
 * after reversing it.
 */
public class ReverseOnlyLetters {

	public static void main(String[] args) {
		String s = "a-bC-dEf-ghIj";
		System.out.println(reverseOnlyLetters(s));

	}

	public static String reverseOnlyLetters(String s) {
		char[] charArray = s.toCharArray();
		int l = 0;
		int r = charArray.length - 1;
		while (l < r) {
			char charL = charArray[l];
			char charR = charArray[r];
			if (!Character.isAlphabetic(charL)) {
				l++;
			} else if (!Character.isAlphabetic(charR)) {
				r--;
			} else {
				char temp = charL;
				charArray[l] = charR;
				charArray[r] = temp;
				l++;
				r--;
			}
		}
		return String.valueOf(charArray);
	}
	/**
	 * Time Complexity: s.toCharArray(): This operation takes O(n) time, where n is
	 * the length of the input string.
	 * 
	 * The while loop runs as long as l < r. In the worst case, every character is a
	 * letter and we swap half of them: the loop runs in O(n) time.
	 * 
	 * The operations inside the loop (checks, swaps, increments) are O(1) per
	 * iteration.
	 * 
	 * String.valueOf(charArray): Converts a character array back to a string, which
	 * takes O(n) time.
	 * 
	 * ✅ Overall Time Complexity: O(n)
	 * 
	 * Space Complexity: A char array of size n is created: O(n) space.
	 * 
	 * No other data structures of significant size are used.
	 * 
	 * The function does not use recursion or auxiliary stacks/queues.
	 * 
	 * ✅ Overall Space Complexity: O(n)
	 */
}
