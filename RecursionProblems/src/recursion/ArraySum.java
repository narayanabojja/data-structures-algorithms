package recursion;

/**
 * Given an array nums, find the sum of elements of array using recursion.
 * 
 * 
 * Time Complexity:The time complexity of the code is O(n) because the recursion
 * iterates through each element of the array exactly once. Space Complexity:The
 * space complexity of the code is O(n) due to the recursive call stack that
 * grows in proportion to the number of elements in the array.
 */
public class ArraySum {

	public static void main(String[] args) {
		ArraySum as = new ArraySum();
		int[] nums = { 12, 9, 17 };
		System.out.println(as.arraySum(nums));
	}

	public int arraySum(int[] nums) {
		return arraySumUsingRecursion(nums, 0);
	}

	public int arraySumUsingRecursion(int[] nums, int i) {
		if (i == nums.length) {
			return 0;
		}
		return nums[i] + arraySumUsingRecursion(nums, i + 1);
	}
}
