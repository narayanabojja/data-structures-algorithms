package prefix;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Given an integer array nums, handle multiple queries of the following type:
 * 
 * Calculate the sum of the elements of nums between indices left and right
 * inclusive where left <= right. Implement the NumArray class:
 * 
 * NumArray(int[] nums) Initializes the object with the integer array nums. int
 * sumRange(int left, int right) Returns the sum of the elements of nums between
 * indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
 * nums[right]).
 */
public class RangeSumQuery {

	private int[] prefixArray;

	public RangeSumQuery(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
		this.prefixArray = nums;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		RangeSumQuery rs = new RangeSumQuery(nums);
		int sum = rs.sumRange(2, 5);
		System.out.println(sum);

	}

	public int sumRange(int left, int right) {
		if (left == 0) {
			return prefixArray[right];
		}
		return prefixArray[right] - prefixArray[left - 1];
	}
}
