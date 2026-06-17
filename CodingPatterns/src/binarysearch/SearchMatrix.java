package binarysearch;

/**
 * Given a 2-D array mat where the elements of each row are sorted in
 * non-decreasing order, and the first element of a row is greater than the last
 * element of the previous row (if it exists), and an integer target, determine
 * if the target exists in the given mat or not.
 */
public class SearchMatrix {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int target = 8;

		// Create an instance of Solution class
		SearchMatrix sol = new SearchMatrix();

		boolean result = sol.searchMatrixOptimal(matrix, target);

		// Output the result
		System.out.println(result ? "true" : "false");

	}

	/**
	 * Time Complexity: O(m * n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixBrute(int[][] matrix, int target) {
		boolean found = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target) {
					found = true;
				}
			}

		}
		return found;
	}

	// Function to perform binary search
	private boolean binarySearch(int[] nums, int target) {
		int n = nums.length;
		int low = 0, high = n - 1;

		// Perform binary search
		while (low <= high) {
			int mid = (low + high) / 2;

			// Return true if target is found
			if (nums[mid] == target)
				return true;
			else if (target > nums[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		// Return false if target not found
		return false;
	}

	/**
	 * Time Complexity: O(N + logM), where N is given row number, M is given column
	 * number. The rows are traversed in O(N) time complexity. Binary search is
	 * applied only once for a particular row, resulting in a time complexity of O(N
	 * + logM) instead of O(N*logM).
	 * 
	 * Space Complexity: As no additional space is used, so the Space Complexity is
	 * O(1).
	 * 
	 * @param mat
	 * @param target
	 * @return
	 */
	public boolean searchMatrixBetter(int[][] mat, int target) {
		int n = mat.length;
		int m = mat[0].length;

		for (int i = 0; i < n; i++) {

			/*
			 * Check if there is a possibility that the target can be found in current row
			 */
			if (mat[i][0] <= target && target <= mat[i][m - 1]) {

				/*
				 * Return result fetched from helper function
				 */
				return binarySearch(mat[i], target);
			}
		}
		// Return false if target is not found
		return false;
	}

	/**
	 * Time Complexity: O(log(N*M)), where N is the number of rows in the matrix, M
	 * is the number of columns in each row. As, binary search is being applied on
	 * the 1-D array of size N*M.
	 * 
	 * Space Complexity: As no additional space is used, so the Space Complexity is
	 * O(1).
	 * 
	 * @param mat
	 * @param target
	 * @return
	 */
	public boolean searchMatrixOptimal(int[][] mat, int target) {
		int n = mat.length;
		int m = mat[0].length;

		int low = 0, high = n * m - 1;

		// Perform binary search
		while (low <= high) {
			int mid = (low + high) / 2;

			// Calculate the row and column
			int row = mid / m;
			int col = mid % m;

			// If target is found return true
			if (mat[row][col] == target)
				return true;
			else if (mat[row][col] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		// Return false if target is not found
		return false;
	}
}
