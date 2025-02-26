package binarysearch;

/**
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k Given the array nums after the possible rotation and an
 * integer target, return the index of target if it is in nums, or -1 if it is
 * not in nums
 * 
 * Time Complexity:O(log n) because the search space is halved in each
 * iteration. Space Complexity:O(1) because only a constant amount of extra
 * space is used.
 */
public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 5, 6, 1, 2, 3, 4 };
		System.out.println(search(nums, 4));
	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			// If key found, return the index
			if (nums[mid] == target) {
				return mid;
			}
			// If Left half is sorted
			if (nums[low] <= nums[mid]) {
				// If the key lies within this sorted half,
				// move the hi pointer to mid - 1
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else { // Otherwise, move the lo pointer to mid + 1

					low = mid + 1;
				}
			} else { // If Right half is sorted
				// If the key lies within this sorted half,
				// move the lo pointer to mid + 1
				if (nums[mid] < target && target <= nums[high]) {
					low = mid + 1;
				} else {// Otherwise, move the hi pointer to mid - 1
					high = mid - 1;
				}
			}
		}
		// Key not found
		return -1;
	}
}
