package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n integers, find the second most frequent element in it. If
 * there are multiple elements that appear a maximum number of times, find the
 * smallest of them. If second most frequent element does not exist return -1.
 * 
 * Time Complexity:The time complexity is O(n) due to the single loop through
 * the array and then through the map. Space Complexity:The space complexity is
 * O(n) because we store elements in the map which can be up to the same size as
 * the input array.
 */
public class SecondMostFrequentElement {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 3 };
		int maxCount = 0;
		int secondMaxCount = 0;
		int element = -1;
		int secElement = -1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer count = entry.getValue();
			if (count > maxCount) {
				secondMaxCount = maxCount;
				maxCount = count;
				secElement = element;
				element = key;
			} else if (count == maxCount) {
				element = Math.min(element, key);
			} else if (count > secondMaxCount) {
				secondMaxCount = count;
				secElement = key;
			} else if (count == secondMaxCount) {
				secElement = Math.min(secElement, key);
			}
		}
		System.out.println(secElement);
	}

}
