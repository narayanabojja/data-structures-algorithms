package heap;

/**
 * Given an array of integers nums. Check whether the array represents a binary
 * min-heap or not. Return true if it does, otherwise return false. A binary
 * min-heap is a complete binary tree where the key at the root is the minimum
 * among all keys present in a binary min-heap and the same property is
 * recursively true for all nodes in a Binary Tree. Time Complexity:O(n) because
 * the loop iterates approximately n/2 times, which simplifies to O(n). Space
 * Complexity:O(1) because the algorithm uses a constant amount of extra space.
 */
public class IsMinHeap {

	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 21, 23 };

		System.out.print("Given Array: ");
		for (int x : nums) {
			System.out.print(x + " ");
		}

		// Creating an object of the Solution class
		IsMinHeap sol = new IsMinHeap();

		// Function call to check if the given array is a min-heap
		boolean ans = sol.isHeap(nums);

		if (ans)
			System.out.println("\nThe given array is a min-heap.");
		else
			System.out.println("\nThe given array is not a min-heap.");

	}

	// Function to check if the given array is a min-heap
	public boolean isHeap(int[] nums) {
		int n = nums.length; // Size of the array

		// Iterate on the non-leaf nodes from the back
		for (int i = n / 2 - 1; i >= 0; i--) {
			int leftChildInd = 2 * i + 1;
			int rightChildInd = 2 * i + 2;

			// If left child has a smaller value than the parent
			if (leftChildInd < n && nums[leftChildInd] < nums[i])
				return false;

			// If right child has a smaller value than parent
			if (rightChildInd < n && nums[rightChildInd] < nums[i])
				return false;
		}

		return true;
	}
}
