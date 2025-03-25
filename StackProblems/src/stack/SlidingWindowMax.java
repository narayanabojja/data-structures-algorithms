package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given an array of integers arr, there is a sliding window of size k which is
 * moving from the very left of the array to the very right. You can only see
 * the k numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 * 
 * Time Complexity: O(N) (where N is the size of given array)
 * 
 * The array is traversed once taking O(N) time. In the worst-case, each element
 * is pushed in and popped out from deque only once taking O(N) time. Space
 * Complexity: O(N-K) + O(K)
 * 
 * The deque will store K elements at maximum, taking O(K) time. The result list
 * stores N-K+1 maximums taking O(N-K) space.
 */
public class SlidingWindowMax {

	// Function to get the maximum sliding window
	public int[] maxSlidingWindow(int[] arr, int k) {

		int n = arr.length; // Size of array

		// To store the answer
		int[] ans = new int[n - k + 1];
		int ansIndex = 0;

		// Deque data structure
		Deque<Integer> dq = new LinkedList<>();

		// Traverse the array
		for (int i = 0; i < n; i++) {

			// Update deque to maintain current window
			if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
				dq.pollFirst();
			}

			/*
			 * Maintain the monotonic (decreasing) order of elements in deque
			 */
			while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
				dq.pollLast();
			}

			// Add current element's index to the deque
			dq.offerLast(i);

			/*
			 * Store the maximum element from the first window possible
			 */
			if (i >= (k - 1)) {
				ans[ansIndex++] = arr[dq.peekFirst()];
			}
		}

		// Return the stored result
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 0, -1, 3, 5, 3, 6, 8 };
		int k = 3;

		/*
		 * Creating an instance of Solution class
		 */
		SlidingWindowMax sol = new SlidingWindowMax();

		/*
		 * Function call to get the maximum sliding window
		 */
		int[] ans = sol.maxSlidingWindow(arr, k);

		System.out.print("The maximum elements in the sliding window are: ");
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		List<Integer> res = sol.maxSlidingWindowBruteForce(arr, k);

		System.out.println("\nBruteforce: The maximum elements in the sliding window are: ");
		for (Integer integer : res) {
			System.out.print(integer + " ");
		}
	}

	/**
	 * Time Complexity: O((N-K)*K) (where N is the size of given array) Using two
	 * nested loops.
	 * 
	 * Space Complexity: O(N-K) Due to the size taken to return the answer.
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public List<Integer> maxSlidingWindowBruteForce(int[] arr, int k) {

		int n = arr.length; // Size of array

		// To store the answer
		List<Integer> ans = new ArrayList<>();

		/*
		 * Traverse on the arrary for valid window
		 */
		for (int i = 0; i <= n - k; i++) {

			// To store the maximum of the window
			int maxi = arr[i];

			// Traverse the window
			for (int j = i; j < i + k; j++) {
				// Update the maximum
				maxi = Math.max(maxi, arr[j]);
			}

			// Add the maximum to the result
			ans.add(maxi);
		}

		// Return the stored result
		return ans;
	}
	/**
	 * Intuition: In the earlier approach, scanning every element of the window
	 * repeatedly was resulting in increased time complexity. Instead, if there can
	 * be a way where the maximum element for a window can be found in constant
	 * time, the overall time complexity will improve significantly.
	 * 
	 * What is the best suitable data structure? Every time the sliding window moves
	 * by one step, an element is added to the window and an previously added
	 * element is removed from the window. A data-structure that can push elements
	 * from one end and remove elements from the other end is queue. Every time the
	 * window moves by one step, the queue is updated to manage the current window
	 * elements.
	 * 
	 * Understanding: The maximum element in a particular window can be found
	 * directly using the concept of monotonic queue, which includes storing the
	 * elements in a decreasing order. This way the maximum element will always be
	 * the front element in the queue which can be retrieved from the queue in
	 * constant time. In order to maintain the decreasing order of elements in
	 * queue, before adding the new element to the queue, all the smaller elements
	 * already present in front of the queue can be popped out.
	 * 
	 * But, a queue data structure does not provide pop operation from the front. To
	 * overcome this, a Deque (Double Ended Queue) can be used, which enables
	 * efficient insertion and retrieval from both ends. Approach: Determine the
	 * size of the input array. Prepare a vector to store the results. Utilize a
	 * deque to maintain the indices of array elements within the current window.
	 * For each element in the array, update the deque to maintain only the indices
	 * of elements within the current window by popping the elements from the front.
	 * Ensure the deque maintains a monotonic decreasing order by removing indices
	 * of elements from the back that are less than or equal to the current element.
	 * Add the current element's index to the back of the deque. Once the first
	 * window(of required size) is fully traversed, store the maximum element
	 * (located at the front of the deque) for each window position by adding the
	 * corresponding array value to the result. Return the result that contains the
	 * maximum values for each sliding window position and is returned as the
	 * output.
	 */
}
