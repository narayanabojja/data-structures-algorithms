package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/description/ Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets. Time
 * Complexity:O(n2) Space Complexity: O(n)
 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(ts.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && (nums[i] == nums[i - 1])) {
				continue;
			}
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> tri = Arrays.asList(nums[i], nums[j], nums[k]);
					ans.add(tri);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k + 1]) {
						k--;
					}
				}
			}
		}
		return ans;
	}
}
