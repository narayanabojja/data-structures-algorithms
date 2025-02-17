package array;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
 * Given an integer array nums, return the number of subarrays filled with 0.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class ZeroFilledSubarray {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
		long zeroCount = 0;
		long totalCount = 0;
		for (int x : nums) {
			zeroCount = (x != 0) ? 0 : zeroCount + 1;
			totalCount += zeroCount;
		}
		System.out.println(totalCount);

	}

}
