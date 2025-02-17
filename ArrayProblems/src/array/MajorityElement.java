package array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/description/ Given an array
 * nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElementWithCount(nums));
	}

	// Time complexity: O(n) Space complexity: O(n)
	public int majorityElementWithHashMap(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			Integer count = map.getOrDefault(nums[i], 0);
			if (count > nums.length / 2) {
				return nums[i];
			}
		}
		return 0;
	}

	// Time complexity: O(n) Space complexity: O(1)
	public int majorityElementWithCount(int[] nums) {

		int res = 0;
		int majority = 0;

		for (int n : nums) {
			if (majority == 0) {
				res = n;
			}

			majority += n == res ? 1 : -1;
		}

		return res;
	}
}
