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
	}
}
