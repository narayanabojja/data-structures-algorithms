package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums.Return all triplets such that: i != j, i != k,
 * and j != k nums[i] + nums[j] + nums[k] == 0. Time Complexity: O(NlogN)+O(N2),
 * where N is size of the array. As the pointer i, is running for approximately
 * N times. And both the pointers j and k combined can run for approximately N
 * times including the operation of skipping duplicates. So the total time
 * complexity will be O(N2).
 * 
 * Space Complexity: O(1), no extra space is used.
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { 2, -2, 0, 3, -3, 5 };
		System.out.println(threeSum(nums));
	}

	// Function to find triplets having sum equals to target
	public static List<List<Integer>> threeSum(int[] nums) {

		// List to store the triplets that sum up to target
		List<List<Integer>> ans = new ArrayList<>();

		int n = nums.length;

		// Sort the input array nums
		// The array is sorted to simplify duplicate handling and allow the two-pointer
		// technique
		Arrays.sort(nums);

		// Iterate through the array to find triplets
		for (int i = 0; i < n; i++) {
			// Skip duplicates
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			// Two pointers approach
			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					// Found a triplet that sums up to target
					List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
					ans.add(temp);

					// Skip duplicates
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				}
			}
		}

		return ans;
	}
}
