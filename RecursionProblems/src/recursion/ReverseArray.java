package recursion;

/**
 * Given an array nums of n integers, return reverse of the array. 
 * 
 * Time Complexity:The time complexity is O(n) due to a single traversal to
 * reverse the array elements. Space Complexity:The space complexity is O(n) due
 * to recursive call stack usage.
 */
public class ReverseArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		ReverseArray ra = new ReverseArray();
		System.out.println(ra.reverseArray(nums));
	}

	public int[] reverseArray(int[] nums) {
		return reverseArrayValues(nums, 0, nums.length - 1);
	}

	int[] reverseArrayValues(int[] nums, int left, int right) {
		if (left > right) {
			return nums;
		} else {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
		return reverseArrayValues(nums, left + 1, right - 1);
	}
}
