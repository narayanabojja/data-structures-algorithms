package binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of size n, sorted in ascending order with
 * distinct values. The array has been right rotated an unknown number of times,
 * between 1 and n. Determine the number of rotations performed on the array.
 * 
 * Time Complexity:O(logN), where N is size of the array. As binary search
 * algorithm is being applied to solve the problem.
 * 
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
public class FindKRotation {

	public static void main(String[] args) {
		System.out.println(findKRotation(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3)));
	}

	public static int findKRotation(List<Integer> nums) {
		int low = 0, high = nums.size() - 1;
		int ans = Integer.MAX_VALUE;
		int index = -1;
		while (low <= high) {
			int mid = (low + high) / 2;

			/*
			 * Search space is already sorted then nums.get(low) will always be the minimum
			 * in that search space
			 */
			if (nums.get(low) <= nums.get(high)) {
				if (nums.get(low) < ans) {
					index = low;
					ans = nums.get(low);
				}
				break;
			}

			// If left part is sorted update the ans
			if (nums.get(low) <= nums.get(mid)) {
				if (nums.get(low) < ans) {
					index = low;
					ans = nums.get(low);
				}
				// Eliminate left half
				low = mid + 1;
			} else {
				/*
				 * update the ans if it is less than nums.get(mid)
				 */
				if (nums.get(mid) < ans) {
					index = mid;
					ans = nums.get(mid);
				}
				// Eliminate right half
				high = mid - 1;
			}
		}
		// Return the index as answer
		return index;
	}
}
