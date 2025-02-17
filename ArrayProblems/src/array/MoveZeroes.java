package array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements. Time Complexity: O(n), Space
 * Complexity: O(1)
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		MoveZeroes mz = new MoveZeroes();
		mz.moveZerosTwoPointersOptimized(nums);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}

	void moveZerosTwoPointers(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int nonZeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonZeroIndex] = nums[i];
				nonZeroIndex++;
			}
		}
		while (nonZeroIndex < nums.length) {
			nums[nonZeroIndex] = 0;
			nonZeroIndex++;
		}
	}

	void moveZerosTwoPointersOptimized(int[] nums) {
		if (nums.length == 0) {
			return;
		}

		int nonZeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[nonZeroIndex];
				nums[nonZeroIndex] = nums[i];
				nums[i] = temp;
				nonZeroIndex++;
			}
		}
	}
}
