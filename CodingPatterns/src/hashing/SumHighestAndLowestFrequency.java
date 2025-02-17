package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n integers, find the sum of the frequencies of the highest
 * occurring number and lowest occurring number.
 * 
 * Time Complexity:O(n) - The code iterates through the list once to fill the
 * map and once more to find max and min frequencies. Space Complexity:O(n) -
 * The space used by the map depends on the number of unique elements in the
 * input array.
 */
public class SumHighestAndLowestFrequency {

	public static void main(String[] args) {
		SumHighestAndLowestFrequency sh = new SumHighestAndLowestFrequency();
		int[] nums = { 2, 2, 2, 2 };
		int sum = sh.sumHighestAndLowestFrequency(nums);
		System.out.println(sum);
	}

	public int sumHighestAndLowestFrequency(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int maxCount = 0;
		int minCount = nums.length;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			maxCount = Math.max(maxCount, count);
			minCount = Math.min(minCount, count);
		}
		return maxCount + minCount;
	}
}
