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
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 1;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[j - 1]) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
