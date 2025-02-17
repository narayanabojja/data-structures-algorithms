package array;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/ Given an
 * integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices
 * exists, return false. Time Complexity: O(n) Space Complexity: O(1)
 * 
 * 
 */
public class IncreasingTriplet {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 0, 4, 6 };
		IncreasingTriplet it = new IncreasingTriplet();
		System.out.println(it.increasingTriplet(nums));
	}

	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3) {
			return false;
		}

		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// Updating first (smallest number found so far):
			if (nums[i] <= first) {
				first = nums[i];
			} // Updating second (second smallest number found so far):
			else if (nums[i] <= second) {
				second = nums[i];
			} // Checking for the increasing triplet
//If nums[i] is greater than second, then we have found an increasing sequence (first < second < n).
			else {
				return true;
			}
		}

		return false;
	}
}
