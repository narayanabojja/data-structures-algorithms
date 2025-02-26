package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * 
 * Check if current number is a start number of consecutive sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/solutions/6398280/video-check-n-1/
 * Time Complexity:O(n) on average, but can degrade to O(n^2) in worst case due
 * to the while loop. Space Complexity:O(n) due to the HashSet storing elements
 * of the input array.
 */
public class LongestConsecutive {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		LongestConsecutive lc = new LongestConsecutive();
		System.out.println(lc.longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {

		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}

		int longest = 0;

		for (int num : numSet) {
			if (!numSet.contains(num - 1)) {
				int length = 1;

				while (numSet.contains(num + length)) {
					length++;
				}

				longest = Math.max(longest, length);
			}
		}

		return longest;
	}
}
