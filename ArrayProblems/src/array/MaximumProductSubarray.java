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
		int[] nums = { -2, 3, -4 };

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

	/**
	 * Time complexity: O(n) Space complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProductAnother(int[] nums) {
		int maxProduct = nums[0];
		int currentMax = nums[0];
		int currentMin = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];

			if (num < 0) {
				// Swap currentMax and currentMin when encountering a negative number
				int temp = currentMax;
				currentMax = currentMin;
				currentMin = temp;
			}

			currentMax = Math.max(num, currentMax * num);
			currentMin = Math.min(num, currentMin * num);

			maxProduct = Math.max(maxProduct, currentMax);
		}

		return maxProduct;
	}
	/**
	 * Let’s walk through an example to understand why `currentMin` is crucial:
	 * 
	 * ### Example: Consider the array: `[-2, 3, -4]`
	 * 
	 * Here’s how the algorithm works step-by-step:
	 * 
	 * #### **Step 1:** Start with the first element: - `currentMax = -2`,
	 * `currentMin = -2`, `maxProduct = -2`
	 * 
	 * #### **Step 2:** Move to the next element `3`: - `currentMax = max(3, -2 * 3)
	 * = 3` - `currentMin = min(3, -2 * 3) = -6` - `maxProduct = max(-2, currentMax)
	 * = 3`
	 * 
	 * #### **Step 3:** Move to the next element `-4`: - Since `-4` is negative,
	 * swap `currentMax` and `currentMin`: - `currentMax` becomes `-6`, and
	 * `currentMin` becomes `3` - Now, update: - `currentMax = max(-4, -6 * -4) =
	 * 24` - `currentMin = min(-4, 3 * -4) = -12` - `maxProduct = max(3, currentMax)
	 * = 24`
	 * 
	 * #### Final Result: - The maximum product subarray is `[-2, 3, -4]` with a
	 * product of **24**.
	 * 
	 * ### Why `currentMin` is essential: Without `currentMin`, you wouldn’t be able
	 * to capture the transition from negative to positive product at step 3 (when
	 * `-4` flips `currentMin` into `currentMax`). This phenomenon often happens
	 * with arrays containing negative numbers, and `currentMin` ensures we don’t
	 * miss the opportunity to find a higher product.
	 * 
	 * Does this example clarify things? 😊
	 */
}
