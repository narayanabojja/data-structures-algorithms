package heap;

import java.util.Arrays;

/**
 * Given an array of integers nums, convert it in-place into a min-heap. A
 * binary min-heap is a complete binary tree where the key at the root is the
 * minimum among all keys present in a binary min-heap and the same property is
 * recursively true for all nodes in a Binary Tree.
 */
public class BuildMinHeap {

	public static void main(String[] args) {

		int[] nums = { 6, 5, 2, 7, 1, 7 };

		// Input array
		System.out.println("Input array: " + Arrays.toString(nums));

		// Creating an object of the Solution class
		BuildMinHeap sol = new BuildMinHeap();

		// Function call to convert the given array into a min-heap
		sol.buildMinHeap(nums);

		// Output array
		System.out.println("Min-heap array: " + Arrays.toString(nums));

	}

	// Function to recursively heapify the array downwards
	private void heapifyDown(int[] arr, int ind) {
		int n = arr.length; // Size of the array

		// Index of largest element
		int largest_Ind = ind;

		// Indices of the left and right children
		int leftChild_Ind = 2 * ind + 1, rightChild_Ind = 2 * ind + 2;

		// If the left child holds a larger value, update the largest index
		if (leftChild_Ind < n && arr[leftChild_Ind] < arr[largest_Ind])
			largest_Ind = leftChild_Ind;

		// If the right child holds a larger value, update the largest index
		if (rightChild_Ind < n && arr[rightChild_Ind] < arr[largest_Ind])
			largest_Ind = rightChild_Ind;

		// If the largest element index is updated
		if (largest_Ind != ind) {
			// Swap the largest element with the current index
			int temp = arr[largest_Ind];
			arr[largest_Ind] = arr[ind];
			arr[ind] = temp;

			// Recursively heapify the lower subtree
			heapifyDown(arr, largest_Ind);
		}

		return;
	}

	/**
	 * Time Complexity: O(N) (where N is the number of elements in the array) Each
	 * heapify call has a time complexity of O(h), where h is the height of the
	 * subtree, h = log(N). The heapify operation is performed for approximately N/2
	 * non-leaf nodes. Due to the variable height for all the subtrees, summing the
	 * total work done for all the nodes results in an overall time complexity of
	 * O(N) for building a heap.
	 * 
	 * Space Complexity: O(log2N) The recursive calls during heapify require stack
	 * space proportional to the height of the heap, which will be of the order of
	 * log(N) in the worst case.
	 * 
	 * @param nums
	 */
	public void buildMinHeap(int[] nums) {
		int n = nums.length;

		// Iterate backwards on the non-leaf nodes
		for (int i = n / 2 - 1; i >= 0; i--) {
			// Heapify each node downwards
			heapifyDown(nums, i);
		}

		return;
	}
	/**
	 * Intuition: To build a min-heap from the given array, the goal must be to
	 * individually heapify each non-leaf node so that it starts following the
	 * min-heap property. Once, all the non-leaf nodes are heapified, the resultant
	 * array will be a min-heap. Heapify down is preferred in this case because the
	 * property violations occur between a node and its children when building a
	 * heap from an unsorted array. Fixing the violations downwards ensures that the
	 * entire subtree rooted at the node satisfies the min-heap property
	 * efficiently.
	 * 
	 * Note that the leaf nodes don't have any children i.e., they already follow
	 * the min-heap property. Thus, the heapifying down process is performed only
	 * for the leaf nodes.
	 * 
	 * Approach:
	 * 
	 * Start from the last non-leaf node in the array, as leaf nodes are already
	 * min-heaps. Perform a downward heapify operation on each node, ensuring the
	 * heap property (the parent is smaller than its children) is maintained. The
	 * heapify operation compares the current node with its children, swaps it with
	 * the smallest child if necessary, and recursively heapifies the affected
	 * subtree. Once the iterations are over, the array represents a min-heap.
	 */
}
