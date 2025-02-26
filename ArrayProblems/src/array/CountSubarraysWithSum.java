package array;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k. Time Complexity:The time complexity is O(n)
 * because the code iterates through the input array nums once. Space
 * Complexity:The space complexity is O(n) because, in the worst case, the
 * HashMap map can store n distinct prefix sums.
 */
public class CountSubarraysWithSum {

	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 4};
		CountSubarraysWithSum cw = new CountSubarraysWithSum();
		System.out.println(cw.subarraySum(nums, 6));

	}

	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
		int currentPrefixSum = 0, subarrayCount = 0;

		// Setting 0 in the map.
		prefixSumMap.put(0, 1);
		for (int i = 0; i < n; i++) {
			// Add current element to the prefix sum:
			currentPrefixSum += nums[i];

			/*
			 * Calculate the value to remove (currentPrefixSum - k)
			 */
			int sumToRemove = currentPrefixSum - k;

			/*
			 * Add the number of subarrays with the sum to be removed
			 */
			subarrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);

			/*
			 * Update the count of current prefix sum in the map
			 */
			prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
		}
		return subarrayCount;
	}
}
