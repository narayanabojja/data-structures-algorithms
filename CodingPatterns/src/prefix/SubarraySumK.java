package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumK {

	public static void main(String[] args) {
		SubarraySumK sk = new SubarraySumK();
		int[] nums = { 1, 1, 1 };

		System.out.println(sk.subarraySum(nums, 2));
	}

	public int subarraySum(int[] nums, int k) {
		int count = 0;
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			preSum += nums[i];
			// Now, for a subarray ending at index i with the prefix sum x,
			// if we remove the part with the prefix sum x-k, we will be left with the part
			// whose sum is equal to k. And that is what we want.
			int remove = preSum - k;
			count += map.getOrDefault(remove, 0);
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}
		return count;
	}
}
