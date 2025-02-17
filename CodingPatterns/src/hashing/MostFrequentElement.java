package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n integers, find the most frequent element in it i.e., the
 * element that occurs the maximum number of times. If there are multiple
 * elements that appear a maximum number of times, find the smallest of them.
 * 
 * 
 * Time Complexity:O(n) - Traverse the array once to build the frequency map and
 * then once over the map to find the most frequent element. Space
 * Complexity:O(n) - Space used by the HashMap to store frequency of each
 * element, which in the worst case can be as large as the input array size n.
 */
public class MostFrequentElement {

	public static void main(String[] args) {

		MostFrequentElement mf = new MostFrequentElement();

		int[] nums = { 1, 2, 2, 3, 3, 3 };

		System.out.println(mf.mostFrequentElement(nums));
	}

	/**
	 * Take a HashMap to store the int key-value pairs. Start iterating on the
	 * array. If the current element is not present in the HashMap, insert it with a
	 * frequency of 1. Else, increment the frequency of current element in the
	 * HashMap. Once the iterations are over, all the elements with their
	 * frequencies will be stored in the HashMap. Iterate on the HashMap to find the
	 * element with the highest frequency.
	 * 
	 * @param nums
	 * @return
	 */
	public int mostFrequentElement(int[] nums) {
		int maxCount = 0;
		int element = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer count = entry.getValue();
			if (count > maxCount) {
				maxCount = count;
				element = key;
			} else if (count == maxCount) {
				maxCount = count;
				element = Math.min(element, key);
			}
		}
		return element;
	}
}
