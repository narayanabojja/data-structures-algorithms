package stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
 * Time Complexity: O(N) Auxiliary Space: O(N)
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };

		/*
		 * Creating an instance of Solution class
		 */
		LargestRectangleInHistogram sol = new LargestRectangleInHistogram();

		// Function call to find the largest rectangle area
		int ans = sol.largestRectangleAreaBruteForce(heights);

		System.out.println("The largest rectangle area is: " + ans);
		ans = sol.largestRectangleAreaOptimal(heights);

		System.out.println("Optiomal : The largest rectangle area is: " + ans);

	}

	/**
	 * Time Complexity: O(N) (where N is the size of the given array)
	 * 
	 * Traversing all the elements of array takes O(N) time. All the elements are
	 * pushed in and popped out from stack once taking O(N) time. Space Complexity:
	 * O(N) The stack space used to find the previous smaller element during
	 * traversal can go upto O(N).
	 * 
	 * @param heights
	 * @return
	 */
	public int largestRectangleAreaOptimal(int[] heights) {
		int n = heights.length; // Size of array

		// Stack
		Stack<Integer> st = new Stack<>();

		// To store largest area
		int largestArea = 0;

		// To store current area
		int area;

		/*
		 * To store the indices of next and previous smaller elements
		 */
		int nse, pse;

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * elements is not the smaller element
			 */
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {

				// Get the index of top of stack
				int ind = st.pop();

				/*
				 * Update the index of previous smaller element
				 */
				pse = st.isEmpty() ? -1 : st.peek();

				/*
				 * Next smaller element index for the popped element is current index
				 */
				nse = i;

				// Calculate the area of the popped element
				area = heights[ind] * (nse - pse - 1);

				// Update the maximum area
				largestArea = Math.max(largestArea, area);
			}

			// Push the current index in stack
			st.push(i);
		}

		// For elements that are not popped from stack
		while (!st.isEmpty()) {

			// NSE for such elements is size of array
			nse = n;

			// Get the index of top of stack
			int ind = st.pop();

			// Update the previous smaller element
			pse = st.isEmpty() ? -1 : st.peek();

			// Calculate the area of the popped element
			area = heights[ind] * (nse - pse - 1);

			// Update the maximum area
			largestArea = Math.max(largestArea, area);
		}

		// Return largest area found
		return largestArea;
	}

	/*
	 * Function to find the indices of next smaller elements
	 */
	private int[] findNSE(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the answer
		int[] ans = new int[n];

		// Stack
		Stack<Integer> st = new Stack<>();

		// Start traversing from the back
		for (int i = n - 1; i >= 0; i--) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * element is not the smaller element
			 */
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}

			// Update the answer
			ans[i] = !st.isEmpty() ? st.peek() : n;

			/*
			 * Push the index of current element in the stack
			 */
			st.push(i);
		}

		// Return the answer
		return ans;
	}

	/*
	 * Function to find the indices of previous smaller elements
	 */
	private int[] findPSE(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the answer
		int[] ans = new int[n];

		// Stack
		Stack<Integer> st = new Stack<>();

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * elements is not the smaller element
			 */
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {

				st.pop();
			}

			// Update the answer
			ans[i] = !st.isEmpty() ? st.peek() : -1;

			/*
			 * Push the index of current element in the stack
			 */
			st.push(i);
		}

		// Return the answer
		return ans;
	}

	/**
	 * Time Complexity: O(N) (where N is the size of the given array)
	 * 
	 * Precomputing PSE and NSE arrays take O(2N) time each. Traversing on the given
	 * histogram once to find the maximum area takes O(N) time. Space Complexity:
	 * O(N)
	 * 
	 * Finding the PSE and NSE arrays uses stack that takes O(N) space each. Storing
	 * the PSE and NSE arrays take O(N) space each.
	 * 
	 * @param heights
	 * @return
	 */
	// Function to find the largest rectangle area
	public int largestRectangleAreaBruteForce(int[] heights) {

		/*
		 * Determine the next and previous smaller elements
		 */
		int[] nse = findNSE(heights);
		int[] pse = findPSE(heights);

		// To store largest area
		int largestArea = 0;

		// To store current area
		int area;

		// Traverse on the array
		for (int i = 0; i < heights.length; i++) {

			// Calculate current area
			area = heights[i] * (nse[i] - pse[i] - 1);

			// Update largest area
			largestArea = Math.max(largestArea, area);
		}

		// Return largest area found
		return largestArea;
	}

}
