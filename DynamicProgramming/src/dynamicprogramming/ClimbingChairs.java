package dynamicprogramming;

import java.util.Arrays;

/**
 * Given an integer n, there is a staircase with n steps, starting from the 0th
 * step. Determine the number of unique ways to reach the nth step, given that
 * each move can be either 1 or 2 steps at a time.
 */
public class ClimbingChairs {
	public static void main(String[] args) {
		int n = 5;

		// Create an instance of Solution class
		ClimbingChairs sol = new ClimbingChairs();

		// Print the answer
		System.out.println("The total number of ways1: " + sol.climbStairsRecursion(n));
	}

	/**
	 * Complexity Analysis: Time Complexity: O(2N), where N is the given number of
	 * stairs. The number of recursive calls roughly follows a Fibonacci-like
	 * sequence, where climbStairs(n) is approximately 2N. This is because each call
	 * branches into two more calls, leading to an exponential growth in the number
	 * of calls.
	 * 
	 * Space Complexity:The space complexity of this recursive approach is O(n).
	 * This is because the maximum depth of the recursion stack can go up to n, due
	 * to the linear nature of the stack usage relative to the input size n
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairsRecursion(int n) {
		// Base case
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;

		// Taking 1 step at a time
		int oneStep = climbStairsRecursion(n - 1);

		// Taking 2 steps at a time
		int twoSteps = climbStairsRecursion(n - 2);

		// Return total ways
		return oneStep + twoSteps;
	}

	// Helper function to apply memoization
	private int func(int n, int dp[]) {
		// Base condition
		if (n <= 1) {
			return 1;
		}

		// Check if the subproblem is already solved
		if (dp[n] != -1) {
			return dp[n];
		}

		// Return the calculated value
		return dp[n] = func(n - 1, dp) + func(n - 2, dp);
	}

	/**
	 * Complexity Analysis: Time Complexity: O(N), where N is the given number of
	 * stairs. This is because we perform a linear number of operations relative to
	 * the input size n.
	 * 
	 * Space Complexity:O(N)+O(N), We are using a recursion stack space O(N) and an
	 * array (again O(N)). Therefore total space complexity will be O(N) + O(N) ≈
	 * O(N).
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairsMemoization(int n) {
		int[] dp = new int[n + 1];

		// Initialize dp array with -1
		Arrays.fill(dp, -1);

		// Return the calculated value
		return dp[n] = func(n, dp);
	}

	/**
	 * Complexity Analysis: Time Complexity: O(N), where N is the given number of
	 * stairs. This is because we perform a linear number of operations relative to
	 * the input size N.
	 * 
	 * Space Complexity:O(N), an additional array dp of size n + 1 is used to store
	 * intermediate results. Hence, the space complexity is O(N).
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairsTabulation(int n) {
		// Declare dp array of size n+1
		int[] dp = new int[n + 1];

		// Insert the values of base conditions
		dp[0] = 1;
		dp[1] = 1;

		// Iterate and update every index of dp array
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// Return the answer
		return dp[n];
	}

	/**
	 * Complexity Analysis: Time Complexity: O(N), where N is the given number of
	 * stairs. This is because we perform a linear number of operations relative to
	 * the input size n.
	 * 
	 * Space Complexity:O(1). As no extra space is being used here.
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairsSpaceOpt(int n) {
		/*
		 * Initialize two variables to store previous results
		 */
		int prev2 = 1;
		int prev = 1;

		// Iterate and update the variables
		for (int i = 2; i <= n; i++) {
			int cur_i = prev2 + prev;
			prev2 = prev;
			prev = cur_i;
		}
		// Return the answer as prev
		return prev;
	}
}
