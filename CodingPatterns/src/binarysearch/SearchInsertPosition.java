package binarysearch;

/**
 * Given a sorted array of nums consisting of distinct integers and a target
 * value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 * 
 * Time Complexity: O(logN), where N is the size of the given array. We are
 * using the Binary Search algorithm, which divides the search space in half
 * each time, resulting in a logarithmic time complexity.
 *
 * Space Complexity: O(1), as we are not using any extra space to solve this
 * problem.
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 4));
	}

	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int ans = n;

		// Applying Binary Search Algorithm
		while (low <= high) {
			int mid = (low + high) / 2;

			/*
			 * If mid element is greater than or equal to target, update ans and search the
			 * left half
			 */
			if (nums[mid] >= target) {
				ans = mid;
				high = mid - 1;
			}
			// Otherwise, search the right half
			else {
				low = mid + 1;
			}
		}
		return ans;
	}
}
