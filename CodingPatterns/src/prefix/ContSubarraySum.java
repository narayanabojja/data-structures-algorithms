package prefix;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/description/ Given an
 * integer array nums and an integer k, return true if nums has a good subarray
 * or false otherwise.
 * 
 * A good subarray is a subarray where:
 * 
 * its length is at least two, and the sum of the elements of the subarray is a
 * multiple of k.
 */
public class ContSubarraySum {

	public static void main(String[] args) {
		ContSubarraySum cs = new ContSubarraySum();
		int[] nums = { 23, 2, 4, 6, 7 };
		System.out.println(cs.checkSubarraySum(nums, 6));
	}

	public boolean checkSubarraySum(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		//To cover the sub array starts from zero index
		map.put(0, -1);
		int prefixSum = 0;

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			int rem = prefixSum % k;
			if (map.containsKey(rem)) {
				int index = map.get(rem);
				if (i - index > 1) {
					return true;
				}
			} else {
				map.put(rem, i);
			}
		}
		return false;
	}
}
