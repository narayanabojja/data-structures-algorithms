package binarysearch;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value. If the target is not
 * found in the array, return [-1, -1]. Time Complexity: O(log N), where N is
 * the size of the given array. Both the firstOccurrence and lastOccurrence
 * functions perform a binary search, which operates in logarithmic time. Thus,
 * the overall time complexity is O(log N).
 * 
 * Space Complexity: O(1), as we are using a constant amount of extra space
 * regardless of the input size. The space used by the variables low, high, mid,
 * first, and last does not depend on the size of the input array.
 * 
 */
public class FirstAndLastOccurrence {

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		FirstAndLastOccurrence fl = new FirstAndLastOccurrence();
		int[] result = fl.searchRange(nums, 8);
		for (int i : result) {
			System.out.println(i + " ");
		}
	}

	public int[] searchRange(int[] nums, int target) {
		int first = first(nums, target);
		int last = last(nums, target);
		return new int[] { first, last };
	}

	private int first(int[] nums, int target) {
		int pos = -1;
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				pos = mid;
				r = mid - 1;
			} else if (nums[mid] < target) {

				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return pos;
	}

	private int last(int[] nums, int target) {
		int pos = -1;
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				pos = mid;
				l = mid + 1;
			} else if (nums[mid] < target) {

				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return pos;
	}
}
