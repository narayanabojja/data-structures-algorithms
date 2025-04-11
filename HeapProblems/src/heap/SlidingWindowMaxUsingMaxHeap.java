package heap;

import java.util.PriorityQueue;

/**
 * * Given an array of integers arr, there is a sliding window of size k which
 * is moving from the very left of the array to the very right. You can only see
 * the k numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window. Time Complexity: - Heap operations
 * (insert and remove) take (O(\log k)), where (k) is the size of the window. -
 * For each of the (n) elements, we perform heap operations. - Total time
 * complexity: (O(n \log k)).
 * 
 * Space Complexity: - The heap can contain up to (k) elements at any time. -
 * Space complexity: (O(k)).
 * 
 */
public class SlidingWindowMaxUsingMaxHeap {

	public static void main(String[] args) {
		int[] arr = { 4, 0, -1, 3, 5, 3, 6, 8 };
		int k = 3;

		/*
		 * Creating an instance of Solution class
		 */
		SlidingWindowMaxUsingMaxHeap sol = new SlidingWindowMaxUsingMaxHeap();

		/*
		 * Function call to get the maximum sliding window
		 */
		int[] ans = sol.maxSlidingWindow(arr, k);

		System.out.print("The maximum elements in the sliding window are: ");
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		// Max-Heap: Stores values as negative to simulate a Max-Heap (Java
		// PriorityQueue is a Min-Heap by default)
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		int n = nums.length;
		int[] result = new int[n - k + 1]; // Result array to store max elements in each window
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			// Add the current element to the heap (store value and its index)
			maxHeap.add(new int[] { nums[i], i });
			// Remove elements that are out of the current window
			while (maxHeap.peek()[1] <= i - k) {
				maxHeap.poll();
			}
			// Add the maximum element to the result array once the window has at least k
			// elements
			if (i >= k - 1) {
				result[index++] = maxHeap.peek()[0];
			}
		}
		return result;
	}
}
