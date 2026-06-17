package array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/ Given an array of
 * integers nums containing n + 1 integers where each integer is in the range
 * [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and using only
 * constant extra space.
 * 
 */
public class FindDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				System.out.println(num);
			}
			set.add(num);
		}
	}

	// Without using Built in classes
	// Time Complexity : O(N) Space Complexity: O(1)

	public int findDuplicate(int[] nums) {

		int[] freq = new int[nums.length + 1];

		for (int x : nums) {
			freq[x]++;
			if (freq[x] > 1) {
				return x;
			}
		}
		return 0;
	}
}
