package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an M * N matrix, print the elements in a clockwise spiral manner.
 * Return an array with the elements in the order of their appearance when
 * printed in a spiral manner. Time Complexity: O(MxN) since all the elements
 * are being traversed once and there are total N x M elements ( M elements in
 * each row and total N rows) so the time complexity will be O(N x M).
 * 
 * Space Complexity: O(1) as extra space to store answer is not considered.
 */
public class SpiralOrder {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> ans = new ArrayList<>();

		// Number of rows
		int n = matrix.length;

		// Number of columns
		int m = matrix[0].length;

		// Initialize pointers for traversal
		int top = 0;
		int left = 0;
		int bottom = n - 1;
		int right = m - 1;

		// Traverse the matrix in spiral order
		while (top <= bottom && left <= right) {
			// Traverse from left to right
			for (int i = left; i <= right; ++i) {
				ans.add(matrix[top][i]);
			}
			top++;

			// Traverse from top to bottom
			for (int i = top; i <= bottom; ++i) {
				ans.add(matrix[i][right]);
			}
			right--;

			// Traverse from right to left
			// if , ensuring that there's still a row to process from right to left.
			if (top <= bottom) {
				for (int i = right; i >= left; --i) {
					ans.add(matrix[bottom][i]);
				}
				bottom--;
				// Finally, after the loop finishes, the variable is decremented (). This
				// "shrinks" the bottom boundary, so the next loop doesn't process this row
				// again.
			}

			// Traverse from bottom to top
			// This loop runs if , ensuring that there's still a column to process from
			// bottom to top.
			if (left <= right) {
				for (int i = bottom; i >= top; --i) {
					ans.add(matrix[i][left]);
				}
				left++;
				// Finally, after the loop finishes, the variable is incremented (). This
				// "shrinks" the left boundary, so the next loop doesn't process this column
				// again.
			}
		}
		// The matrix "shrinks" after each step (via , , , ), reducing the boundaries
		// until all elements are added to .
		// Return the ans
		return ans;
	}
}
