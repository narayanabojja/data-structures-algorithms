package array;

/**
 * Given an array of integers nums, return the value of the largest element in
 * the array. Time Complexity:O(n) because the loop iterates through all
 * elements of the array once. Space Complexity:O(1) because no additional space
 * proportional to input size is used.
 * 
 */
public class LargestElement {

	public static void main(String[] args) {
		LargestElement le = new LargestElement();
		int[] nums = { 3, 3, 6, 1 };
		System.out.println(le.largestElement(nums));
	}

	public int largestElement(int[] nums) {
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			largest = Math.max(largest, nums[i]);
		}
		return largest;
	}
}
