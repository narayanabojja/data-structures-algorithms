package string;

/**
 * Given an input string s, reverse the order of the words.
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * 
 */
public class ReverseWords {

	public static void main(String[] args) {
		String s = "  Bob    Loves  Alice   ";
		System.out.println(reverseWords(s));
	}

	/**
	 * Time Complexity: O(n) Space Complexity: O(n)
	 */
	public static String reverseWords(String s) {
		s = s.trim();
		String[] words = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]);
			if (i != 0) {
				sb.append(" ");
			}
		}
		return sb. toString();
	}
}
