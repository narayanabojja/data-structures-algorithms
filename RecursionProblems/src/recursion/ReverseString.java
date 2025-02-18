package recursion;

import java.util.Arrays;
import java.util.List;

/**
 * Given an input string as an array of characters, write a function that
 * reverses the string.
 * 
 * Time Complexity: O(N) - Each character in the string is processed exactly
 * once, resulting in a linear time complexity relative to the length of the
 * string.
 * 
 * Space Complexity: O(N) - This is due to the recursion stack used in the
 * process. In the worst case, the depth of the recursion is equal to the length
 * of the string, leading to linear space complexity.
 * 
 */
public class ReverseString {

	public static void main(String[] args) {
		List<Character> list = Arrays.asList('h', 'l', 'l', '0');
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseString(list));
	}

	public List<Character> reverseString(List<Character> s) {
		return reverseStr(s, 0, s.size() - 1);
	}

	List<Character> reverseStr(List<Character> s, int left, int right) {
		if (left > right) {
			return s;
		} else {
			Character temp = s.get(left);
			s.set(left, s.get(right));
			s.set(right, temp);
		}
		return reverseStr(s, left + 1, right - 1);
	}
}
