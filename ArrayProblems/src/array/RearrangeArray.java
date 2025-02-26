package array;

/**
 * Given an integer array nums of even length consisting of an equal number of
 * positive and negative integers.Return the answer array in such a way that the
 * given conditions are met:
 * 
 * 
 * 
 * Every consecutive pair of integers have opposite signs. For all integers with
 * the same sign, the order in which they were present in nums is preserved. The
 * rearranged array begins with a positive integer. Time Complexity: O(N+N/2),
 * where N is the size of the array. O(N) for traversing the array once for
 * segregating positives and negatives and another O(N/2) for adding those
 * elements alternatively to the array.
 * 
 * Space Complexity: O(N/2 + N/2) = O(N), N/2 space required to store each of
 * the positive and negative elements in separate arrays.
 */

public class RearrangeArray {
	// Function to rearrange elements by their sign
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;

		// Initialize a result vector of size n
		int[] ans = new int[n];

		/*
		 * Initialize indices for positive and negative elements
		 */
		int posIndex = 0, negIndex = 1;

		// Traverse through each element in nums
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {

				/*
				 * If current element is negative, place it at the next odd index in ans
				 */
				ans[negIndex] = nums[i];
				// Move to the next odd index
				negIndex += 2;

			} else {
				ans[posIndex] = nums[i];

				// Move to the next even index
				posIndex += 2;

			}
		}

		// Return the rearranged array
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, -4, -5 };

		// Create an instance of the Solution class
		RearrangeArray sol = new RearrangeArray();

		int[] ans = sol.rearrangeArray(A);

		// Print the rearranged array
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
