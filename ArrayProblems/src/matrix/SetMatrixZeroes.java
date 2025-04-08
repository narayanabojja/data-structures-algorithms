package matrix;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * https://leetcode.com/problems/set-matrix-zeroes/solutions/6121398/video-o-1-space-use-the-first-row-and-column-as-a-note/
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's. Time complexity: O(m∗n) Space complexity: O(1)
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		SetMatrixZeroes sz = new SetMatrixZeroes();
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		sz.setZeroes(matrix);
		for (int[] is : matrix) {
			for (int x : is) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void setZeroes(int[][] matrix) {
		boolean fr = false;
		boolean fc = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						fr = true;
					}
					if (j == 0) {
						fc = true;
					}
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (fr) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (fc) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	/**
	 * This code modifies a given matrix such that if any cell contains a `0`, its
	 * entire row and column are set to `0`. Let's break it down step by step:
	 * 
	 * ### **Step 1: Identify if the first row or first column contains zeros** -
	 * **`boolean fr = false; boolean fc = false;`** Two boolean flags `fr` (first
	 * row) and `fc` (first column) are used to track whether the first row or
	 * column needs to be set to zeros later.
	 * 
	 * - The first nested `for` loop checks all elements in the matrix. If a `0` is
	 * found: 1. If the `0` is in the first row, `fr` is set to `true`. 2. If the
	 * `0` is in the first column, `fc` is set to `true`. 3. For all other `0`s, the
	 * corresponding first row and first column cells (i.e., `matrix[0][j]` and
	 * `matrix[i][0]`) are set to `0`. These cells serve as markers indicating that
	 * the entire row or column will later be set to zeros.
	 * 
	 * ---
	 * 
	 * ### **Step 2: Use the markers to zero out rows and columns** - The second
	 * nested `for` loop iterates through all cells of the matrix **except the first
	 * row and first column** (starting from `i=1` and `j=1`). - If either the
	 * cell's row marker (`matrix[i][0]`) or column marker (`matrix[0][j]`) is `0`,
	 * the cell itself (`matrix[i][j]`) is set to `0`.
	 * 
	 * ---
	 * 
	 * ### **Step 3: Update the first row and column if necessary** - If `fr` (first
	 * row flag) is `true`, it means the entire first row needs to be set to zeros.
	 * The corresponding `for` loop sets all elements in the first row to `0`. -
	 * Similarly, if `fc` (first column flag) is `true`, the entire first column is
	 * set to zeros.
	 * 
	 * ---
	 * 
	 * ### **Key Insight:** By using the first row and column as markers, the
	 * algorithm avoids creating extra memory (like additional arrays). The `fr` and
	 * `fc` flags ensure the first row and column themselves are handled correctly.
	 * 
	 * ---
	 * 
	 * This approach has a time complexity of **O(m × n)** (where `m` is the number
	 * of rows and `n` is the number of columns) and space complexity of **O(1)**
	 * since it modifies the matrix in place without using additional data
	 * structures.
	 * 
	 * If you'd like a deeper dive into any step or similar examples, just let me
	 * know! 😊
	 */
}
