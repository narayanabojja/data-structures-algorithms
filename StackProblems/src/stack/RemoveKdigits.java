package stack;

import java.util.Stack;

/**
 * Given a string nums representing a non-negative integer, and an integer k,
 * find the smallest possible integer after removing k digits from num.
 * 
 * Complexity Analysis: Time Complexity: O(N) (where N is the length of the
 * given number)
 * 
 * Traversing the given string takes O(N) time. Each element is pushed onto and
 * popped from the stack at most once in worst-case taking o(N) time. Removing
 * the remaining digits (if k > 0) takes O(k) time which can go upto O(N) in
 * worst-case. Forming the result, trimming the zeros and reversing the digits
 * takes O(N) time. Space Complexity: O(N)
 * 
 * The stack space can be O(N) in the worst-case. The space required to store
 * the result is O(N) in worst-case.
 */
public class RemoveKdigits {
	/**
	 * Intuition: To get the smallest possible integer, the smaller digits must be
	 * kept at the beginning. This can be achieved by getting rid of K larger digits
	 * using a simple greedy approach that works by processing each digit and
	 * keeping the smallest possible digit, aiming for the smallest resulting
	 * number. Prioritizing smaller digits for the leftmost positions ensures the
	 * resulting number is minimized.
	 * 
	 * To facilitate the greedy approach, a stack data structure can be used
	 * because:
	 * 
	 * LIFO (Last In, First Out): The stack allows access to the most recently added
	 * element, useful when comparing and potentially removing the last chosen
	 * element to eliminate a larger digit. Order Preservation: The stack maintains
	 * the relative order of elements, crucial when the sequence of digits must be
	 * preserved. Approach: Use a stack to keep track of the digits of the resulting
	 * number. Iterate through each digit of the input string. Remove the previous
	 * digits from the stack if they are larger than the current digit and the
	 * removal count (k) allows. This step ensures that the remaining digits form
	 * the smallest possible number. If there are still digits left to be removed
	 * after the iteration, continue removing the digits from the end of the stack.
	 * Collect the remaining digits from the stack and form the resulting number by
	 * reversing the digits. Edge Cases: When K is equal to the size of the string:
	 * In such cases, all the digits will be removed from the given numbers, thus
	 * "0" can be returned.
	 * 
	 * When the resulting number contains leading zeroes: In such cases, the leading
	 * zeroes must be removed before returning the resultant number.
	 * 
	 * When there are still removals left: Consider the example: nums = "1234" amd k
	 * = 2 Here, there will be no removals performed, however, two removals can be
	 * performed. Thus, to utilize all the given removals, the last digits of the
	 * number can be removed before returning the result.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public String removeKdigits(String nums, int k) {

		Stack<Character> st = new Stack<>(); // Stack

		// Traverse on the given string
		for (int i = 0; i < nums.length(); i++) {

			// Current digit
			char digit = nums.charAt(i);

			/*
			 * Pop last digits (when possible) if a smaller digit is found
			 */
			while (!st.isEmpty() && k > 0 && st.peek() > digit) {

				st.pop(); // Pop the last digit
				k--; // Decrement K by 1
			}

			// Push the current digit
			st.push(digit);
		}

		// If more digits can be removed
		while (!st.isEmpty() && k > 0) {

			st.pop(); // Pop the last added digits
			k--; // Decrement K by 1
		}

		// Handling edge case
		if (st.isEmpty())
			return "0";

		// To store the result
		StringBuilder res = new StringBuilder();

		// Adding digits in stack to result
		while (!st.isEmpty()) {
			res.append(st.pop());
		}

		// Trimming the zeroes at the back
		while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {

			res.deleteCharAt(res.length() - 1);
		}

		// Reverse to get the actual number
		res.reverse();

		// Edge case
		if (res.length() == 0)
			return "0";

		// Return the stored result
		return res.toString();
	}

	public static void main(String[] args) {
		String nums = "1432219";
		int k = 2;

		/*
		 * Creating an instance of Solution class
		 */
		RemoveKdigits sol = new RemoveKdigits();

		/*
		 * Function call to find the smallest possible integer after removing k digits
		 */
		String ans = sol.removeKdigits(nums, k);

		System.out.println("The smallest possible integer after removing k digits is: " + ans);
	}
}
