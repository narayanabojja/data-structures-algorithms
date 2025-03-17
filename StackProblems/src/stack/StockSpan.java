package stack;

import java.util.Stack;

/**
 * Given an array arr of size n, where each element arr[i] represents the stock
 * price on day i. Calculate the span of stock prices for each day. The span Si
 * for a specific day i is defined as the maximum number of consecutive previous
 * days (including the current day) for which the stock price was less than or
 * equal to the price on day i
 */

//Leetcode version

class StockSpanner {
	Stack<int[]> st;

	public StockSpanner() {
		st = new Stack<>();
	}

	/**
	 * Complexity Analysis Time Complexity: O(1) on average, since each element is
	 * pushed and popped at most once. Space Complexity: O(n) in the worst case,
	 * where n is the number of stock prices processed.
	 * 
	 * @param price
	 * @return
	 */
	public int next(int price) {
		int days = 1;
		while (!st.isEmpty() && st.peek()[0] <= price) {
			days += st.pop()[1];
		}
		st.push(new int[] { price, days });
		return days;
	}
}

public class StockSpan {

	public static void main(String[] args) {
		StockSpan s = new StockSpan();
		int n = 7;
		int[] arr = { 120, 100, 60, 80, 90, 110, 115 };

		int[] ans = s.stockSpanBruteForce(arr, n);

		System.out.print("The span of stock prices is: ");
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
		ans = s.stockSpan(arr, n);

		System.out.print("The span of stock prices is: ");
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	/**
	 * Complexity Analysis: Time Complexity: O(N2) (where N is the length of given
	 * array) Using two nested loops.
	 * 
	 * Space Complexity: O(1) Using only a couple of variables.
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public int[] stockSpanBruteForce(int[] arr, int n) {

		// To store the answer
		int[] ans = new int[n];

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// To store the current span of stocks
			int currSpan = 0;

			// Traversing backwards to find stock span
			for (int j = i; j >= 0; j--) {

				// Update stock span
				if (arr[j] <= arr[i]) {
					currSpan++;
				}

				// Else break out from loop
				else
					break;
			}

			// Store the current span
			ans[i] = currSpan;
		}

		// Return the result
		return ans;
	}

	/*
	 * Function to find the indices of previous greater element for each element in
	 * the array
	 */
	private int[] findPGE(int[] arr) {

		int n = arr.length; // size of array

		// To store the previous greater elements
		int[] ans = new int[n];

		// Stack to get elements in LIFO fashion
		Stack<Integer> st = new Stack<>();

		// Start traversing from the front
		for (int i = 0; i < n; i++) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * element is not the greater element
			 */
			while (!st.isEmpty() && arr[st.peek()] <= currEle) {
				st.pop();
			}

			/*
			 * If the greater element is not found, stack will be empty
			 */
			if (st.isEmpty())
				ans[i] = -1;

			// Else store the answer
			else
				ans[i] = st.peek();

			// Push the current index in the stack
			st.push(i);
		}

		// Return the result
		return ans;
	}

	// Function to find the span of stock prices for each day
	public int[] stockSpan(int[] arr, int n) {

		// Get the indices of previous greater elements
		int[] PGE = findPGE(arr);

		// To store the answer
		int[] ans = new int[n];

		// Compute the result
		for (int i = 0; i < n; i++) {
			ans[i] = i - PGE[i];
		}

		// Return the result
		return ans;
	}

	/**
	 * Intuition: As stated in the problem, the stock span is the number of
	 * consecutive days for which the stock price was less than or equal to the
	 * price on current day. Hence, to get the stock span for current day, the aim
	 * is to find the position of its previous greater element. This will
	 * significantly improve the solution by eliminating multiple backwards
	 * traversals on the given array.
	 * 
	 * Understanding: Finding the previous greater element is similar to finding the
	 * next greater element, the only difference is that the direction of traversal
	 * will be reversed while maintaining the decreasing order of elements in the
	 * stack (monotonic stack). Approach: Determine the indices of previous greater
	 * elements using monotonic stack (maintaining elements in decreasing order in a
	 * stack) Once the indices are known, the stock span for each day will be
	 * difference between the current index and the index of its previous greater
	 * element. Traverse the array, updating the stock span for each day. After the
	 * traversal is over, return the result
	 */
}
