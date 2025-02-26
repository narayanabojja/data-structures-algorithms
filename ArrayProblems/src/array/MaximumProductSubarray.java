package array;

/**
 * Given an integer array nums. Find the subarray with the largest product, and
 * return the product of the elements present in that subarray. A subarray is a
 * contiguous non-empty sequence of elements within an array. Time Complexity:
 * O(N), where N is the size of the array Traversing the given array using
 * single for loop takes linear time.
 * 
 * Space Complexity: O(1), as only couple of variables are used.
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 3, 7, 1, 2 };

		MaximumProductSubarray sol = new MaximumProductSubarray();

		/*
		 * Function call to find the product of elements in maximum product subarray
		 */
		int ans = sol.maxProduct(nums);

		System.out.println("The product of elements in maximum product subarray is: " + ans);

	}

	public int maxProduct(int[] nums) {
		int n = nums.length;

		int ans = Integer.MIN_VALUE; // to store the answer

		// Indices to store the prefix and suffix multiplication
		int prefix = 1, suffix = 1;

		// Iterate on the elements of the given array
		for (int i = 0; i < n; i++) {

			/*
			 * Resetting the prefix and suffix multiplication if they turn out to be zero
			 */
			if (prefix == 0)
				prefix = 1;
			if (suffix == 0)
				suffix = 1;

			// update the prefix and suffix multiplication
			prefix *= nums[i];
			suffix *= nums[n - i - 1];

			// store the maximum as the answer
			ans = Math.max(ans, Math.max(prefix, suffix));
		}

		// return the result
		return ans;
	}
}
