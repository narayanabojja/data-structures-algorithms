package stack;

import java.util.Stack;

/**
 * Given an integer array nums, determine the range of a subarray, defined as
 * the difference between the largest and smallest elements within the subarray.
 * Calculate and return the sum of all subarray ranges of nums. A subarray is
 * defined as a contiguous, non-empty sequence of elements within the array.
 * 
 * Complexity Analysis: Time Complexity: O(N) (where N is the size of given
 * array)
 * 
 * Calculating the sum of subarray maximums takes O(N) time. Calculating the sum
 * of subarray minimums takes O(N) time. Space Complexity: O(N)
 * 
 * Calculating the sum of subarray maximums requires O(N) space. Calculating the
 * sum of subarray minimums requires O(N) space.
 */
public class SubArrayRangesAndNGENSEPSEPGE {

	/*
	 * Function to find the indices of next smaller elements
	 */
	private int[] findNSE(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the answer
		int[] ans = new int[n];

		// Stack
		Stack<Integer> st = new Stack<>();

		// Start traversing from the back
		for (int i = n - 1; i >= 0; i--) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * element is not the smaller element
			 */
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}

			// Update the answer
			ans[i] = !st.isEmpty() ? st.peek() : n;

			/*
			 * Push the index of current element in the stack
			 */
			st.push(i);
		}

		// Return the answer
		return ans;
	}

	/*
	 * Function to find the indices of next greater elements
	 */
	private int[] findNGE(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the answer
		int[] ans = new int[n];

		// Stack
		Stack<Integer> st = new Stack<>();

		// Start traversing from the back
		for (int i = n - 1; i >= 0; i--) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * element is not the greater element
			 */
			while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}

			// Update the answer
			ans[i] = !st.isEmpty() ? st.peek() : n;

			/*
			 * Push the index of current element in the stack
			 */
			st.push(i);
		}

		// Return the answer
		return ans;
	}

	/*
	 * Function to find the indices of previous smaller or equal elements
	 */
	private int[] findPSEE(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the answer
		int[] ans = new int[n];

		// Stack
		Stack<Integer> st = new Stack<>();

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * elements are greater than the current element
			 */
			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
				st.pop();
			}

			// Update the answer
			ans[i] = !st.isEmpty() ? st.peek() : -1;

			/*
			 * Push the index of current element in the stack
			 */
			st.push(i);
		}

		// Return the answer
		return ans;
	}

	/*
	 * Function to find the indices of previous greater or equal elements
	 */
	private int[] findPGEE(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the answer
		int[] ans = new int[n];

		// Stack
		Stack<Integer> st = new Stack<>();

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Pop the elements in the stack until the stack is not empty and the top
			 * elements are smaller than the current element
			 */
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				st.pop();
			}

			// Update the answer
			ans[i] = !st.isEmpty() ? st.peek() : -1;

			/*
			 * Push the index of current element in the stack
			 */
			st.push(i);
		}

		// Return the answer
		return ans;
	}

	/*
	 * Function to find the sum of the minimum value in each subarray
	 */
	private long sumSubarrayMins(int[] arr) {

		int[] nse = findNSE(arr);

		int[] psee = findPSEE(arr);

		// Size of array
		int n = arr.length;

		// To store the sum
		long sum = 0;

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// Count of first type of subarrays
			int left = i - psee[i];

			// Count of second type of subarrays
			int right = nse[i] - i;

			/*
			 * Count of subarrays where current element is minimum
			 */
			long freq = left * right * 1L;

			// Contribution due to current element
			long val = (freq * arr[i] * 1L);

			// Updating the sum
			sum += val;
		}

		// Return the computed sum
		return sum;
	}

	/*
	 * Function to find the sum of the maximum value in each subarray
	 */
	private long sumSubarrayMaxs(int[] arr) {

		int[] nge = findNGE(arr);

		int[] pgee = findPGEE(arr);

		// Size of array
		int n = arr.length;

		// To store the sum
		long sum = 0;

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// Count of first type of subarrays
			int left = i - pgee[i];

			// Count of second type of subarrays
			int right = nge[i] - i;

			/*
			 * Count of subarrays where current element is maximum
			 */
			long freq = left * right * 1L;

			// Contribution due to current element
			long val = (freq * arr[i] * 1L);

			// Updating the sum
			sum += val;
		}

		// Return the computed sum
		return sum;
	}

	/*
	 * Function to find the sum of subarray ranges in each subarray Hence, instead
	 * of summing up the ranges for each subarray, the sum of largest elements in
	 * each subarray and sum of smallest elements in each subarray can be added to
	 * get the required sum of subarray ranges.
	 * 
	 * To optimally find the sum of largest and the smallest elements in the array,
	 * the concept of Next/Previous Smaller/Greater Elements come into picture as
	 * discussed in the Sum of Subarray minimums (Optimal Solution).
	 */
	public long subArrayRanges(int[] arr) {

		// Return the result
		return (sumSubarrayMaxs(arr) - sumSubarrayMins(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		/*
		 * Creating an instance of Solution class
		 */
		SubArrayRangesAndNGENSEPSEPGE sol = new SubArrayRangesAndNGENSEPSEPGE();

		/*
		 * Function call to find the sum of subarray ranges in each subarray
		 */
		long ans = sol.subArrayRanges(arr);

		System.out.println("The sum of subarray ranges is: " + ans);
		ans = sol.subArrayRangesBruteForce(arr);

		System.out.println("The sum of subarray ranges is: " + ans);
	}

	/**
	 * The brute force way to solve this problem is by generating all the subarrays
	 * and finding the minimum and maximum values in all of them. The range of a
	 * subarray can be found as the difference between the maximum and minimum value
	 * which can be summed up for all the subarrays to get the result.
	 * 
	 * 
	 * Time Complexity: O(N2) (where N is the size of the array) Using two nested
	 * loops.
	 * 
	 * Space Complexity: O(1) Using only a couple of variables.
	 * 
	 * @param arr
	 * @return
	 */
	public long subArrayRangesBruteForce(int[] arr) {

		// Size of array
		int n = arr.length;

		// To store the sum
		long sum = 0;

		// Traverse on the array
		for (int i = 0; i < n; i++) {

			// To store the smallest value of subarray
			int smallest = arr[i];

			// To store the largest value of subarray
			int largest = arr[i];

			/*
			 * Nested loop to get all subarrays starting from index i
			 */
			for (int j = i; j < n; j++) {

				// Update the smallest value
				smallest = Math.min(smallest, arr[j]);

				// Update the largest value
				largest = Math.max(largest, arr[j]);

				// Update the sum
				sum += (largest - smallest);
			}
		}

		// Return the computed sum
		return sum;
	}
}
