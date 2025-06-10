package dynamicprogramming;

import java.util.Arrays;

public class FibanocciDP {

	public static void main(String[] args) {
		int n = 5; // Fibonacci number to find
		int[] dp = new int[n + 1]; // Initialize dp array
		Arrays.fill(dp, -1); // Fill dp array with -1

		// Output the nth Fibonacci number
		System.out.println(fibonacciMemoization(n, dp));
		fibonacciTablulation(n);
	}

	/**
	 * Time Complexity: O(N) Overlapping subproblems return answers in constant time
	 * O(1). Therefore, only 'n' new subproblems are solved, resulting in O(N)
	 * complexity.
	 * 
	 * Space Complexity: O(N) Using recursion stack space and an array, the total
	 * space complexity is O(N) + O(N) ≈ O(N).
	 * 
	 * @param n
	 * @param dp
	 * @return
	 */
	// Function to calculate Fibonacci number using memoization
	public static int fibonacciMemoization(int n, int[] dp) {
		// Base case: return n if n is 0 or 1
		if (n <= 1)
			return n;

		// If the value is already calculated, return it
		if (dp[n] != -1)
			return dp[n];

		// Calculate the value and store it in dp array
		dp[n] = fibonacciMemoization(n - 1, dp) + fibonacciMemoization(n - 2, dp);
		return dp[n];
	}

	/**
	 * Time Complexity: O(N): Running a simple iterative loop results in O(N)
	 * complexity.
	 * 
	 * Space Complexity: O(N): Using an external array of size n+1, the space
	 * complexity is O(N).
	 * 
	 * @param n
	 */
	public static void fibonacciTablulation(int n) {
		int dp[] = new int[n + 1]; // Initialize dp array

		dp[0] = 0; // Base case for Fibonacci sequence
		dp[1] = 1; // Base case for Fibonacci sequence

		// Fill the dp array using the tabulation method
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// Output the nth Fibonacci number
		System.out.println(dp[n]);
	}

	/**
	 * Time Complexity O(N) : We are running a simple iterative loop
	 * 
	 * SpaceComplexity O(1) : We are not using any extra space
	 * 
	 * @param n
	 */
	public static void fibonacciTablulationSpaceOpt(int n) {
		// Edge case: if n is 0, the result is 0
		if (n == 0) {
			System.out.println(0);
			return;
		}

		// Edge case: if n is 1, the result is 1
		if (n == 1) {
			System.out.println(1);
			return;
		}

		int prev2 = 0; // Fibonacci number for n-2
		int prev = 1; // Fibonacci number for n-1

		// Iterate from 2 to n to find the nth Fibonacci number
		for (int i = 2; i <= n; i++) {
			int cur_i = prev2 + prev; // Current Fibonacci number
			prev2 = prev; // Update prev2 to the previous Fibonacci number
			prev = cur_i; // Update prev to the current Fibonacci number
		}

		// Print the nth Fibonacci number
		System.out.println(prev);
	}
}
