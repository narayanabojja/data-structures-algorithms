package stack;

import java.util.Stack;

/**
 * Given an array arr of size n containing elements, find the next greater
 * element for each element in the array in the order of their appearance. The
 * next greater element of an element in the array is the nearest element on the
 * right that is greater than the current element. If there does not exist a
 * next greater element for the current element, then the next greater element
 * for that element is -1.
 * 
 * Time Complexity: O(N) (where N is the size of the array) Traversing on the
 * hypothetical array takes O(2N) time and traversing the stack will take
 * overall O(2N) time as all the elements are pushed in the stack once. Space
 * Complexity: O(N) The answer array takes O(N) space and the space used by
 * stack will be O(N) in the worst case.
 */
public class NextGreaterElement1 {

	public static void main(String[] args) {
		int[] nums = { 6, 8, 0, 1, 3 };
		int[] ans = nextLargerElement(nums);//8 -1 1 3 6 
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

	/*
	 * Function to find the next greater element for each element in the array
	 */
	public static int[] nextLargerElement(int[] arr) {

		int n = arr.length; // size of array

		// To store the next greater elements
		int[] ans = new int[n];

		// Stack to get elements in LIFO fashion
		Stack<Integer> st = new Stack<>();

		// Start traversing from the back
		for (int i = n - 1; i >= 0; i--) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * element is not the greater element
			 */
			while (!st.isEmpty() && st.peek() <= currEle) {
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

			/*
			 * Push the current element in the stack maintaining the decreasing order
			 */
			st.push(currEle);
		}

		// Return the result
		return ans;
	}

}
