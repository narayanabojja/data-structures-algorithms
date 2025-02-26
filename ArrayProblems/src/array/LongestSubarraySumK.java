package array;

import java.util.HashMap;

/**
 * Given an array and a sum k, we need to print the length of the longest
 * subarray that sums to k Time Complexity: O(N) or O(N*logN) Space Complexity:
 * O(N) as we are using a map data structure
 */
public class LongestSubarraySumK {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int k = 15;
		System.out.println(lenOfLongSubarr(arr, k));

	}

	// Function to find the length of the longest subarray having sum k
	static int lenOfLongSubarr(int[] arr, int k) {
		
		HashMap<Integer, Integer> mp = new HashMap<>();
		int res = 0, prefixSum = 0;

		for (int i = 0; i < arr.length; ++i) {
			prefixSum += arr[i];

			// If prefix sum is same as k, we have a prefix subarray from 0 to i
			if (prefixSum == k) {
				res = i + 1;
			}

			// Check if prefixSum - k exists in the map
			if (mp.containsKey(prefixSum - k)) {
				res = Math.max(res, i - mp.get(prefixSum - k));
			}

			// Insert prefixSum in the map if not already present
			mp.putIfAbsent(prefixSum, i);
		}

		return res;
	}
}
