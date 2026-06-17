package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-good-pairs/description/
 * 
 * Given an array of integers nums, return the number of good pairs.
 * 
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Time O(n) Space O(n)
 */
public class NumberOfGoodPairs {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 1, 3 };
		int count = numIdenticalPairs(nums);
		System.out.println(" Count: " + count);
	}

	public static int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int count = map.getOrDefault(num, 0);
			map.put(num, ++count);
		}
		int count = 0;
		for (Integer val : map.values()) {
			count += (val * (val - 1)) / 2;
		}
		return count;
	}

	//O(1) Space Solution (Using Frequency Array)
	public static int numIdenticalPairsFreqArray(int[] nums) {
		int[] freq = new int[101];
		int count = 0;

		for (int num : nums) {
			count += freq[num];
			freq[num]++;
		}

		return count;
	}
}
