package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * A subsequence is a sequence derived from an array by deleting some or no
 * elements without changing the order of the remaining elements. For example,
 * [3, 6, 2, 7] is a subsequence of [0, 3, 1, 6, 2, 2, 7]. The task is to find
 * the length of the longest subsequence in which every element is greater than
 * the previous one.
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLISArrayList(nums));
	}

	/**
	 * - dp[i] stores the length of the longest increasing subsequence ending at
	 * index i. - We iterate through the array and update dp[i] based on previous
	 * values. O(n²) time complexity.
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int maxLength = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}

		return maxLength;
	}

	/**
	 * Binary search ensures that elements follow an increasing order because it
	 * finds the correct position for each number in the subsequence while
	 * maintaining the smallest possible values
	 * 
	 * time complexity: O(nlogn) Space complexity: O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public static int lengthOfLISArrayList(int[] nums) {
		List<Integer> sub = new ArrayList<>();

		for (int num : nums) {
			int idx = Collections.binarySearch(sub, num);
			if (idx < 0)
				idx = -(idx + 1); // Convert to insertion index

			if (idx == sub.size()) {
				sub.add(num); // Extend the sequence
			} else {
				sub.set(idx, num); // Replace element to maintain order
			}
		}

		return sub.size();
	}

}
