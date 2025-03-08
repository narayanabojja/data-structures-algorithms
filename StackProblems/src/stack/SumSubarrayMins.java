package stack;

import java.util.Stack;

/**
 * 
 * Given an array of integers arr of size n, calculate the sum of the minimum
 * value in each (contiguous) subarray of arr. Since the result may be large,
 * return the answer modulo 109 +7.
 * 
 * Complexity Analysis: Time Complexity: O(N) (where N is the size of given
 * array)
 * 
 * Finding the indices of next smaller elements and previous smaller elements
 * take O(2*N) time each. Calculating the sum of subarrays minimum takes O(N)
 * time. Space Complexity: O(N)
 * 
 * Finding the indices of the next smaller elements and previous smaller
 * elements takes O(N) space each due to stack space. Storing the indices of the
 * next smaller elements and previous smaller elements takes O(N) space each.
 */
public class SumSubarrayMins {

	public static void main(String[] args) {

		int[] arr = { 3, 1, 2, 5 };

		// Creating an instance of Solution class
		SumSubarrayMins sol = new SumSubarrayMins();

		// Function call to find the sum of the minimum value in each subarray
		int ans = sol.sumSubarrayMins(arr);

		System.out.println("The sum of minimum value in each subarray is: " + ans);

	}

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
	 * Function to find the sum of the minimum value in each subarray
	 */
	public int sumSubarrayMins(int[] arr) {

		int[] nse = findNSE(arr);
		int[] psee = findPSEE(arr);

		// Size of array
		int n = arr.length;

		int mod = (int) 1e9 + 7; // Mod value

		// To store the sum
		int sum = 0;

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
			int val = (int) ((freq * arr[i]) % mod);

			// Updating the sum
			sum = (sum + val) % mod;
		}

		// Return the computed sum
		return sum;
	}

}
