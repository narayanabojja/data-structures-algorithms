package matrix;

/**
 * Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
 * The rotation must be done in place, meaning the input 2D matrix must be
 * modified directly. Time Complexity:O(n^2) due to nested loops iterating over
 * the matrix elements. Space Complexity:O(1) as the algorithm operates in-place
 * with only a constant amount of extra space.
 */
public class RotateMatrix90 {

	public static void main(String[] args) {
		int[][] matrix = { { 8, 2, 13, 4 }, { 9, 16, 17, 8 }, { 1, 22, 3, 14 }, { 15, 6, 17, 8 } };
		rotateMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotateMatrix(int[][] matrix) {
		 // Transpose the array
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		 // Reverse each row
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}
}
