package stack;

import java.util.Stack;

/**
 * Given a m x n binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area. Time Complexity: O(N*M)
 * (where N and M are the dimensions of the given matrix)
 * 
 * Filling the prefix sum matrix takes O(N*M) time. Every row (of length M) is
 * treated as a histogram for which the largest histogram is found in
 * linear(O(2*M)) time taking overall O(N*M) time. Space Complexity: O(N*M)
 * 
 * The prefix sum array takes up O(N*M) space. Finding the largest rectangle in
 * each histogram (of length M) takes O(M) space due to stack.
 */
public class MaximumRectangles {

	// Function to find the largest rectangle area
	private int largestRectangleArea(int[] heights) {

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
	 * Function to find the largest rectangle area containing all 1s
	 */
	public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {

		// Determine the size of matrix
		int n = matrix.length;
		int m = matrix[0].length;

		/*
		 * Prefix sum matrix to store heights for different ground levels
		 */
		int[][] prefixSum = new int[n][m];

		// Fill up the prefix sum matrix column wise
		for (int j = 0; j < m; j++) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				sum += matrix[i][j];

				// If there is no base present
				if (matrix[i][j] == 0) {
					prefixSum[i][j] = 0;
					sum = 0;
				} else {
					// Store the height
					prefixSum[i][j] = sum;
				}
			}
		}

		// To store the maximum area
		int maxArea = 0;

		// Traverse for different levels of ground
		for (int i = 0; i < n; i++) {

			// Get the largest area for current level
			int area = largestRectangleArea(prefixSum[i]);

			// Update the maximum area
			maxArea = Math.max(area, maxArea);
		}

		// Return the maximum area
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };

		/*
		 * Creating an instance of Solution class
		 */
		MaximumRectangles sol = new MaximumRectangles();

		/*
		 * Function call to find the largest rectangle area containing all 1s
		 */
		int ans = sol.maximalAreaOfSubMatrixOfAll1(matrix);

		System.out.println("The largest rectangle area containing all 1s is: " + ans);
	}

}
/**
 * 
 * Intuition: A clever way to approach this problem is by breaking the problem
 * into smaller subproblems using the concept discussed in the problem Largest
 * rectangle in a histogram. The given matrix can be seen from different ground
 * levels. Each ground can be treated as a histogram, and the columns of 1s
 * attached from the ground represent the heights of the bars for the current
 * histogram. This way the problem boils down to finding the largest rectangle
 * in all the histograms.
 * 
 * Now, to find the height of bars for a particular ground level (histogram),
 * traversing the matrix again and again will be inefficient. Instead, the
 * heights of bars can be determined by traversing the matrix only once by using
 * the concept of Prefix Sum.
 * 
 * Understanding: Since the heights of the bars are the main concern, the prefix
 * sum must be calculated column-wise. This will make sure that while traversing
 * in a column-order fashion, the heights are added up. But if in any place, a
 * zero is found, the height of 1s above it will not be considered as there is
 * no contact of continuous 1s with the ground for that particular histogram.
 * Approach: Convert the binary matrix into a matrix of histogram heights using
 * the prefix sum technique. Each cell in the histogram matrix represents the
 * height of consecutive 1s ending at that cell. For each column, compute the
 * height of consecutive 1's for each row. If a cell contains a 0, reset the
 * height to 0. For each row in the histogram matrix, treat it as a histogram
 * and compute the largest rectangle area that can be formed using that row.
 * This is achieved using a stack-based approach to find the largest rectangle
 * in a histogram. Track the maximum rectangle area found across all rows and
 * return it as the result.
 * 
 */
