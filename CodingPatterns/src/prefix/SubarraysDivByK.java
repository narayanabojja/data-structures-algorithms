package prefix;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return the number of non-empty
 * subarrays that have a sum divisible by k.
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 */
public class SubarraysDivByK {

	public static void main(String[] args) {
		SubarraysDivByK sd = new SubarraysDivByK();
		int[] nums = { 4, 5, 0, -2, -3, 1 };
		System.out.println(sd.subarraysDivByK(nums, 5));
	}

	public int subarraysDivByK(int[] nums, int k) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int prefixSum = 0;

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			int mod = prefixSum % k;
			if (mod < 0) {
				mod += k;
			}

			count += map.getOrDefault(mod, 0);
			map.put(mod, map.getOrDefault(mod, 0) + 1);
		}
		return count;
	}
}
