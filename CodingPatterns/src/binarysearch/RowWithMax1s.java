package binarysearch;

/**
 * Given a non-empty grid mat consisting of only 0s and 1s, where all the rows
 * are sorted in ascending order, find the index of the row with the maximum
 * number of ones.
 * 
 */
public class RowWithMax1s {

	/*
	 * Complexity Analysis: Time Complexity: O(N X M), where N is the number of rows
	 * in the matrix, M is the number of columns in each row. As, nested loops are
	 * being used to traverse the matrix.
	 * 
	 * Space Complexity: As no additional space is used, so the Space Complexity is
	 * O(1).
	 */
	public int rowWithMax1sBruteForce(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		/*
		 * Variable to store the maximum count of 1's found
		 */
		int cnt_max = 0;

		/*
		 * Variable to store the index of the row with max 1's
		 */
		int index = -1;

		// Traverse the matrix row by row
		for (int i = 0; i < n; i++) {

			/*
			 * Counter for 1's in the current row
			 */
			int cnt_ones = 0;

			/*
			 * Count the number of 1's in the current row
			 */
			for (int j = 0; j < m; j++) {
				cnt_ones += mat[i][j];
			}

			/*
			 * Update cnt_max and index if current row has more 1's than previously found
			 */
			if (cnt_ones > cnt_max) {
				cnt_max = cnt_ones;
				index = i;
			}
		}

		/*
		 * Return the index of the row with the maximum number of 1's
		 */
		return index;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };

		// Create an instance of the Solution class
		RowWithMax1s sol = new RowWithMax1s();

		// Print the answer
		System.out.println("The row with maximum number of 1's is: " + sol.rowWithMax1sBruteForce(matrix));
		System.out.println("Optimal The row with maximum number of 1's is: " + sol.rowWithMax1sOptimal(matrix));

	}

	// Helper function to find the lower bound of 1.
	private int lowerBound(int[] arr, int n, int x) {
		int low = 0, high = n - 1;
		int ans = n;

		while (low <= high) {
			int mid = (low + high) / 2;

			/*
			 * If element at mid is greater than or equal to x then it counld be a possible
			 * answer.
			 */
			if (arr[mid] >= x) {
				ans = mid;

				// Look for smaller index on the left
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// Return the answer
		return ans;
	}

	/*
	 * Complexity Analysis: Time Complexity:O(N * logM), where N is the number of rows in the matrix, M is the number of columns in each row. 
	 * As, each row is being traversed once and then binary search is being applied for M columns of every row
	 * 
	 * Space Complexity: As no additional space is used, so the Space Complexity is
	 * O(1).
	 */
	public int rowWithMax1sOptimal(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		/*
		 * Variable to store the maximum count of 1's found
		 */
		int cnt_max = 0;

		/*
		 * Variable to store the index of the row with max 1's
		 */
		int index = -1;

		// Traverse each row of the matrix
		for (int i = 0; i < n; i++) {
			// Get the number of 1's
			int cnt_ones = m - lowerBound(mat[i], m, 1);

			/*
			 * If the current count is greater than maximum, store the index of current row
			 * and update the maximum count.
			 */
			if (cnt_ones > cnt_max) {
				cnt_max = cnt_ones;
				index = i;
			}
		}

		/*
		 * Return the index of the row with the maximum number of 1's
		 */
		return index;
	}

}
