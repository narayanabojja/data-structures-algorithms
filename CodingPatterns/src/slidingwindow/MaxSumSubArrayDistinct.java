package slidingwindow;

import java.util.HashSet;

public class MaxSumSubArrayDistinct {

	public static void main(String[] args) {
		MaxSumSubArrayDistinct msd = new MaxSumSubArrayDistinct();
		int[] nums = {1,5,4,2,9,9,9};
		System.out.println(msd.maximumSubarraySum(nums, 3));
	}

	public long maximumSubarraySum(int[] nums, int k) {
		long currentSum = 0;
		long maxSum = 0;
		if (!hasDuplicates(nums, 0, k)) {
			for (int i = 0; i < k; i++) {
				currentSum += nums[i];
			}
		}
		maxSum = currentSum;

		for (int i = 1; i < nums.length; i++) {
			if ((nums.length - i >= k) && !hasDuplicates(nums, i, i + k)) {
				currentSum += nums[i] - nums[i - k];
				maxSum = Math.max(maxSum, currentSum);
			}
		}
		return maxSum;
	}

	public boolean hasDuplicates(int[] nums, int low, int end) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = low; i < end; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
