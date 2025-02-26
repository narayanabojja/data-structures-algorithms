package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose XOR equals to k. Time Complexity:The time complexity is O(n)
 * because the code iterates through the input array 'nums' once. Space
 * Complexity:The space complexity is O(n) because the HashMap 'map' can store
 * at most n distinct XOR prefix values.
 */
public class SubarraysWithXorK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int subarraysWithXorK(int[] nums, int k) {
		int n = nums.length;
		int xr = 0;
		Map<Integer, Integer> mpp = new HashMap<>();
		// setting the value of 0.
		mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			// prefix XOR till index i:
			xr = xr ^ nums[i];

			// By formula: x = xr ^ k:
			int x = xr ^ k;

			// add the occurrence of xr ^ k to the count:
			cnt += mpp.getOrDefault(x, 0);

			// Insert the prefix xor till index i into the map:
			mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
		}
		return cnt;
	}
}
