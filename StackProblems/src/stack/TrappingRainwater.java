package stack;

/**
 * Given an array of non-negative integers, height representing the elevation of
 * ground. Calculate the amount of water that can be trapped after rain.
 * 
 * Time Complexity: O(N) (where N is the size of given array) The left and right
 * pointers will traverse the whole array in total taking O(N) time.
 * 
 * Space Complexity: O(1) Using only a couple of variable
 * 
 */
public class TrappingRainwater {

	public int trap(int[] height) {

		int n = height.length; // Size of array

		// To store the total trapped rainwater
		int total = 0;

		// To store the maximums on both sides
		int leftMax = 0, rightMax = 0;

		// Left and Right pointers
		int left = 0, right = n - 1;

		// Traverse from both ends
		while (left < right) {

			// If left height is smaller or equal
			if (height[left] <= height[right]) {

				// If water can be stored
				if (leftMax > height[left]) {

					// Update total water
					total += leftMax - height[left];
				}

				// Else update maximum height on left
				else
					leftMax = height[left];

				// Shift left by 1
				left = left + 1;
			}

			// Else if right height is smaller
			else {

				// If water can be stored
				if (rightMax > height[right]) {

					// Update total water
					total += rightMax - height[right];
				}

				// Else update maximum height on right
				else
					rightMax = height[right];

				// Shift right by 1
				right = right - 1;
			}
		}

		// Return the result
		return total;
	}

	public static void main(String[] args) {
		int[] heights = { 4, 2, 0, 3, 2, 5 };

		TrappingRainwater sol = new TrappingRainwater();

		// Function call to get the trapped water
		int ans = sol.trap(heights);

		System.out.println("The trapped rainwater is: " + ans);
		ans = sol.trapBruteForce(heights);
		System.out.println("BruteForce: The trapped rainwater is: " + ans);
	}

	// Function to find the prefix maximum array
	private int[] findPrefixMax(int[] arr, int n) {
		// To store the prefix maximum
		int[] prefixMax = new int[n];

		// Initial configuration
		prefixMax[0] = arr[0];

		// Traverse the array
		for (int i = 1; i < n; i++) {
			// Store the maximum till ith index
			prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
		}

		// Return the prefix maximum array
		return prefixMax;
	}

	// Function to find the suffix maximum array
	private int[] findSuffixMax(int[] arr, int n) {
		// To store the suffix maximum
		int[] suffixMax = new int[n];

		// Initial configuration
		suffixMax[n - 1] = arr[n - 1];

		// Traverse the array
		for (int i = n - 2; i >= 0; i--) {
			// Store the maximum till ith index
			suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
		}

		// Return the suffix maximum array
		return suffixMax;
	}

	/**
	 * Traversing to the left and right side to get the maximum for every height of
	 * ground is inefficient. To solve this problem efficiently, two auxiliary
	 * arrays will be used to store the maximum heights to the left and right of
	 * each position: Prefix Maximum Array: Stores the maximum of all the elements
	 * to the left till the current index. Suffix Maximum Array: Stores the maximum
	 * of all the elements to the right from the current index. Approach: Store the
	 * maximum height from the start to each position in this array. This will help
	 * in determining the maximum height to the left of any position. Store the
	 * maximum height from each position to the end of the array in this array. This
	 * will help in determining the maximum height to the right of any position.
	 * Traverse the array and for each position, determine the water level using the
	 * minimum of the prefix and suffix maximum heights. Subtract the ground height
	 * at that position from this water level to calculate the trapped water at that
	 * position. Sum all these values to get the total trapped water. Complexity
	 * Analysis: Time Complexity: O(N) (where N is the size of given array)
	 * 
	 * Calculating the Prefix and Suffix Maximum Arrays take O(N) time each.
	 * Traversing on the given array once takes O(N) time. Space Complexity: O(N)
	 * Storing the Prefix and Suffix Maximum Arrays takes O(N) space each.
	 * 
	 * @param height
	 * @return
	 */
	public int trapBruteForce(int[] height) {

		int n = height.length; // Size of array

		// To store the total trapped rainwater
		int total = 0;

		// Calculate prefix maximum array
		int[] leftMax = findPrefixMax(height, n);

		// Calculate suffix maximum array
		int[] rightMax = findSuffixMax(height, n);

		// Traverse the array
		for (int i = 0; i < n; i++) {

			/*
			 * If there are higher grounds on both side to hold water
			 */
			if (height[i] < leftMax[i] && height[i] < rightMax[i]) {

				// Add up the water on top of current height
				total += (Math.min(leftMax[i], rightMax[i]) - height[i]);
			}
		}

		// Return the result
		return total;
	}

}
