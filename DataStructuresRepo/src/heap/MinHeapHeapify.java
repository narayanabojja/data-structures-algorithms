package heap;

/**
 * Given an array nums representing a min-heap and two integers ind and val, set
 * the value at index ind (0-based) to val and perform the heapify algorithm
 * such that the resulting array follows the min-heap property.
 * 
 * Complexity: O(log2N) (where N is the number of elements of the array) The
 * heapify function calls either heapifyUp or heapifyDown, both of which in the
 * worst case will make number of recursive calls equal to the height of the
 * heap which is log2N.
 * 
 * Space Complexity: O(log2N) The recursive stack space will contribute to log2N
 * in the worst-case. There is no extra space used other than this as the array
 * is modified in-place.
 */
public class MinHeapHeapify {
	
	// Function to recursively heapify the array downwards
	private void heapifyDown(int[] arr, int ind) {
		int n = arr.length; // Size of the array

		// Index of smallest element
		int smallest_Ind = ind;

		// Indices of the left and right children
		int leftChild_Ind = 2 * ind + 1;
		int rightChild_Ind = 2 * ind + 2;

		// If the left child holds a smaller value, update the smallest index
		if (leftChild_Ind < n && arr[leftChild_Ind] < arr[smallest_Ind]) {
			smallest_Ind = leftChild_Ind;
		}

		// If the right child holds a smaller value, update the smallest index
		if (rightChild_Ind < n && arr[rightChild_Ind] < arr[smallest_Ind]) {
			smallest_Ind = rightChild_Ind;
		}

		// If the smallest element index is updated
		if (smallest_Ind != ind) {
			// Swap the smallest element with the current index
			int temp = arr[smallest_Ind];
			arr[smallest_Ind] = arr[ind];
			arr[ind] = temp;

			// Recursively heapify the lower subtree
			heapifyDown(arr, smallest_Ind);
		}
	}

	// Function to recursively heapify the array upwards
	private void heapifyUp(int[] arr, int ind) {
		int parent_Ind = (ind - 1) / 2;

		// If current index holds a smaller value than its parent
		if (ind > 0 && arr[ind] < arr[parent_Ind]) {
			// Swap the values at the two indices
			int temp = arr[ind];
			arr[ind] = arr[parent_Ind];
			arr[parent_Ind] = temp;

			// Recursively heapify the upper nodes
			heapifyUp(arr, parent_Ind);
		}
	}

	// Function to implement the heapify algorithm for a min-heap
	public void heapify(int[] nums, int ind, int val) {
		// If the current value is replaced with a smaller value
		if (nums[ind] > val) {
			nums[ind] = val;
			heapifyUp(nums, ind);
		}
		// Else if the current value is replaced with a larger value
		else {
			nums[ind] = val;
			heapifyDown(nums, ind);
		}
	}

	public static void main(String[] args) {
		// Example array representing a min-heap
		int[] nums = { 1, 4, 5, 5, 7, 6 };
		int ind = 5, val = 2;

		// Print input array
		System.out.print("Input array: ");
		for (int it : nums) {
			System.out.print(it + " ");
		}

		// Create an object of the Solution class
		MinHeapHeapify sol = new MinHeapHeapify();

		// Function call to heapify the array
		sol.heapify(nums, ind, val);

		// Print modified array
		System.out.print("\nModified array after heapifying: ");
		for (int it : nums) {
			System.out.print(it + " ");
		}
		System.out.println();
	}
}
