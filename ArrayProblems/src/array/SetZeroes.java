package array;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * https://leetcode.com/problems/set-matrix-zeroes/solutions/6121398/video-o-1-space-use-the-first-row-and-column-as-a-note/
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's. Time complexity: O(m∗n) Space complexity: O(1)
 */
public class SetZeroes {

	public static void main(String[] args) {
		SetZeroes sz = new SetZeroes();
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
}
