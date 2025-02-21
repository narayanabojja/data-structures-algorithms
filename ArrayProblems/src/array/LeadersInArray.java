package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an integer array nums, return a list of all the leaders in the array. A
 * leader in an array is an element whose value is strictly greater than all
 * elements to its right in the given array. The rightmost element is always a
 * leader. The elements in the leader array must appear in the order they appear
 * in the nums array.
 * 
 * Time Complexity:The time complexity of the code is O(n) where n is the number
 * of elements in the nums array. Space Complexity:The space complexity of the
 * code is O(n) to store the result list of leaders.
 */
public class LeadersInArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 5, 3, 1, 2 };
		LeadersInArray la = new LeadersInArray();
		System.out.println(la.leaders(nums));
	}

	public ArrayList<Integer> leaders(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		// Last element of the array is always a leader
		list.add(nums[nums.length - 1]);
		int max = nums[nums.length - 1];
		// Check elements from right to left
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > max) {
				list.add(nums[i]);
				max = nums[i];
			}
		}
		/*
		 * Reverse the list to match the required output order
		 */
		Collections.reverse(list);
		// Return the leaders
		return list;
	}
}
