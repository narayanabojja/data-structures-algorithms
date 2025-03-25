package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given string str containing just the characters '(', ')', '{', '}', '[' and
 * ']', check if the input string is valid and return true if the string is
 * balanced otherwise return false.
 * https://leetcode.com/problems/valid-parentheses/description/ Time complexity:
 * O(n) Space complexity: O(n)
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String source = "()[]{}";
		boolean valid = isValidParenThesis(source);
		System.out.println(valid);
	}

	private static boolean isValidParenThesis(String source) {
		Deque<Character> stack = new ArrayDeque<>();
		for (Character c : source.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character top = stack.pop();
				if (c == ')' && top != '(') {
					return false;
				}
				if (c == '}' && top != '{') {
					return false;
				}
				if (c == ']' && top != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
