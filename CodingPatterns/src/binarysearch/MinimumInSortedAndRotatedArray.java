package binarysearch;

/**
 * A sorted array of distinct elements arr[] is rotated at some unknown point,
 * the task is to find the minimum element in it. Time O(logn) and O(1) Space
 */
public class MinimumInSortedAndRotatedArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 1, 2, 3, 4 };
		System.out.println("Minimum: " + findMin(arr));
	}

	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int ans = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < nums[high]) {
				ans = Math.min(ans, nums[mid]);
				high = mid - 1;
			} else {
				ans = Math.min(ans, nums[low]);
				low = mid + 1;
			}
		}
		return ans;
	}
}
