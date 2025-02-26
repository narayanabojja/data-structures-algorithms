package binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, sorted in ascending order (may contain duplicate
 * values) and a target value k. Now the array is rotated at some pivot point
 * unknown to you. Return True if k is present and otherwise, return False.
 * 
 * Time Complexity:O(logN) for the best and average cases. As in the best and
 * average scenarios, the binary search algorithm is primarily used and hence
 * the time complexity is O(logN). However, in the worst-case scenario, it'll be
 * O(N/2) where all array elements are the same but not the target (e.g., given
 * array = {3, 3, 3, 3, 3, 3, 3}), we continue to reduce the search space by
 * adjusting the low and high pointers until they intersect, which will end up
 * taking O(N/2) time complexity.
 * 
 * Space Complexity:O(1), as we are not using any extra space to solve this
 * problem.
 */
public class SearchInARotatedSortedArrayII {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7, 8, 1, 2, 3, 3, 3, 4, 5, 6);
		System.out.println(searchInARotatedSortedArrayII(list, 3));
	}

	/*
	 * Function to search for the target element in a rotated sorted array with
	 * duplicates
	 */
	public static boolean searchInARotatedSortedArrayII(List<Integer> arr, int target) {
		int n = arr.size();
		int low = 0, high = n - 1;

		// Applying binary search algorithm
		while (low <= high) {
			int mid = (low + high) / 2;

			// Check if mid points to the target
			if (arr.get(mid) == target)
				return true;

			// Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
			if (arr.get(low).equals(arr.get(mid)) && arr.get(mid).equals(arr.get(high))) {
				low = low + 1;
				high = high - 1;
				continue;
			}

			// Check if the left part is sorted
			if (arr.get(low) <= arr.get(mid)) {
				/*
				 * Eliminate the right part if target exists in the left sorted part
				 */
				if (arr.get(low) <= target && target <= arr.get(mid)) {
					high = mid - 1;
				}
				// Otherwise eliminate the left part
				else {
					low = mid + 1;
				}
			} else {
				/*
				 * If the right part is sorted and target exists in the right sorted part,
				 * eliminate the left part
				 */
				if (arr.get(mid) <= target && target <= arr.get(high)) {
					low = mid + 1;
				}
				// Otherwise eliminate the right part
				else {
					high = mid - 1;
				}
			}
		}
		// If target is not found
		return false;
	}
}
