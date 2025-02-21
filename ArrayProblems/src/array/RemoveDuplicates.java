package array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. Then return the
 * number of unique elements in nums.
 * 
 * 
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(rd.removeDuplicates(nums));
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	public int removeDuplicates(int[] nums) {
		// Edge case: if array is empty
		if (nums.length == 0) {
			return 0;
		}

		// Initialize pointer for unique elements
		int i = 0;

		// Iterate through the array
		for (int j = 1; j < nums.length; j++) {
			/*
			 * If current element is different from the previous unique element
			 */
			if (nums[i] != nums[j]) {
				/*
				 * Move to the next position in the array for the unique element
				 */
				i++;
				/*
				 * Update the current position with the unique element
				 */
				nums[i] = nums[j];
			}
		}

		// Return the number of unique elements
		return i + 1;
	}
}
