package stack;

import java.util.Stack;

/**
 * Given a circular integer array arr, return the next greater element for every
 * element in arr. The next greater element for an element x is the first
 * element greater than x that we come across while traversing the array in a
 * clockwise manner. If it doesn't exist, return -1 for that element element.
 * 
 * Time Complexity: O(N) (where N is the size of the array) Traversing on the
 * array takes O(N) time and traversing the stack will take overall O(N) time as
 * all the elements are pushed in the stack once.
 * 
 * Space Complexity: O(N) The answer array takes O(N) space and the space used
 * by stack will be O(N) in the worst case.
 */
public class NextGreaterElement2 {

	public static void main(String[] args) {
		int[] nums = { 6, 8, 0, 1, 3 };
		int[] ans = nextGreaterElements(nums);
		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

	public static int[] nextGreaterElements(int[] arr) {

		int n = arr.length; // size of array

		// To store the next greater elements
		int[] ans = new int[n];

		// Stack to get elements in LIFO fashion
		Stack<Integer> st = new Stack<>();

		// Start traversing from the back
		for (int i = 2 * n - 1; i >= 0; i--) {

			// Get the actual index
			int ind = i % n;

			// Get the current element
			int currEle = arr[ind];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * element is not the greater element
			 */
			while (!st.isEmpty() && st.peek() <= currEle) {
				st.pop();
			}

			// Store the answer for the second half
			if (i < n) {

				/*
				 * If the greater element is not found, stack will be empty
				 */
				if (st.isEmpty())
					ans[i] = -1;

				// Else store the answer
				else
					ans[i] = st.peek();
			}

			/*
			 * Push the current element in the stack maintaining the decreasing order
			 */
			st.push(currEle);
		}

		// Return the result
		return ans;
	}
}
