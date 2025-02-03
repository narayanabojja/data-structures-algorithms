package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray
 * with an equal number of 0 and 1.
 * 
 * https://leetcode.com/problems/contiguous-array/description/
 */
public class ContiguousArrayLength {

	public static void main(String[] args) {
		ContiguousArrayLength ca = new ContiguousArrayLength();
		int[] nums = {0,1,0};
		System.out.println(ca.findMaxLength(nums));
	}

	public int findMaxLength(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> mp = new HashMap<>();
		int sum = 0;
		int subArrayLength = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i] == 0 ? -1 : 1;
			if (sum == 0) {
				subArrayLength = i + 1;
			} else if (mp.containsKey(sum)) {
				subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
			} else {
				mp.put(sum, i);
			}
		}
		return subArrayLength;
	}
}
