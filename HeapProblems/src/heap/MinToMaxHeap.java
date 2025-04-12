package heap;

/**
 * Given a min-heap in array representation named nums, convert it into a
 * max-heap and return the resulting array.
 * 
 * Time Complexity: O(N) (where N is the number of elements in the array) Each
 * heapify call has a time complexity of O(h), where h is the height of the
 * subtree, h = log(N). The heapify operation is performed for approximately N/2
 * non-leaf nodes.
 * 
 * Due the variable height for all the subtrees, summing the total work done for
 * all the nodes results in an overall time complexity of O(N) for building a
 * heap.
 * 
 * Space Complexity: O(logN) The recursive calls during heapify require stack
 * space proportional to the height of the heap which will be of the order of
 * log(N) in the worst-case.
 */
public class MinToMaxHeap {

	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 21, 23 };

		System.out.print("Initial Min-heap Array: ");
		for (int x : nums) {
			System.out.print(x + " ");
		}

		// Creating an object of the Solution class
		MinToMaxHeap sol = new MinToMaxHeap();

		/*
		 * Function call to convert the given array from min-heap to max-heap
		 */
		nums = sol.minToMaxHeap(nums);

		System.out.print("\nMax-heap converted Array: ");
		for (int x : nums) {
			System.out.print(x + " ");
		}
	}

	// Function to recursively heapify the array downwards
	private void heapifyDown(int[] arr, int ind) {
		int n = arr.length; // Size of the array

		// To store the index of largest element
		int largestInd = ind;

		// Indices of the left and right children
		int leftChildInd = 2 * ind + 1;
		int rightChildInd = 2 * ind + 2;

		// If the left child holds larger value, update the largest index
		if (leftChildInd < n && arr[leftChildInd] > arr[largestInd]) {
			largestInd = leftChildInd;
		}

		// If the right child holds larger value, update the largest index
		if (rightChildInd < n && arr[rightChildInd] > arr[largestInd]) {
			largestInd = rightChildInd;
		}

		// If the largest element index is updated
		if (largestInd != ind) {
			// Swap the largest element with the current index
			int temp = arr[largestInd];
			arr[largestInd] = arr[ind];
			arr[ind] = temp;

			// Recursively heapify the lower subtree
			heapifyDown(arr, largestInd);
		}
	}

	// Function to convert a min-heap array to a max-heap array
	public int[] minToMaxHeap(int[] nums) {
		int n = nums.length;

		// Iterate backwards on the non-leaf nodes
		for (int i = n / 2 - 1; i >= 0; i--) {
			// Heapify each node downwards to ensure max-heap property
			heapifyDown(nums, i);
		}
		return nums;
	}
}
