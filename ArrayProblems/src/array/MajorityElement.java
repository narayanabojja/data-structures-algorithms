package array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/description/ Given an array
 * nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array. Time
 * Complexity:O(n) because the code iterates through the input array 'nums'
 * twice, once to find the potential majority element and again to verify its
 * count. Each iteration takes O(n) time, so the overall time complexity is O(n)
 * + O(n) which simplifies to O(n). Space Complexity:O(1) as the code uses a
 * constant amount of extra space, regardless of the input size. It only uses a
 * few integer variables (n, count, el, count1), whose memory consumption does
 * not depend on the size of the input array.
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
