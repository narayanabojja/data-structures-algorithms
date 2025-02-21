package array;

/**
 * 
 * Given a binary array nums, return the maximum number of consecutive 1s in the
 * array. A binary array is an array that contains only 0s and 1s. Time
 * Complexity:The time complexity is O(n) as there is a single loop iterating
 * through the array once, where n is the length of the input array 'nums'.
 * Space Complexity:The space complexity is O(1) because only a constant amount
 * of extra space is used, regardless of the input size.
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0 };
		System.out.println(findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				count = 0;
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}
}
