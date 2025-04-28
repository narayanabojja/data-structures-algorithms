package slidingwindow;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/ Given a binary array
 * nums and an integer k, return the maximum number of consecutive 1's in the
 * array if you can flip at most k 0's. - Time Complexity: O(n) - Space
 * Complexity: O(1)
 */
public class MaxConsecutiveOnes3 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		MaxConsecutiveOnes3 mc = new MaxConsecutiveOnes3();
		System.out.println(mc.longestOnes(nums, 2));
	}

	public int longestOnes(int[] nums, int k) {
		int maxLength = 0;
		int start = 0;
		int zerosCount = 0;
		for (int end = 0; end < nums.length; end++) {
			if (nums[end] == 0) {
				zerosCount++;
			}
			if (zerosCount > k) {
				if (nums[start] == 0) {
					zerosCount--;
				}
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
