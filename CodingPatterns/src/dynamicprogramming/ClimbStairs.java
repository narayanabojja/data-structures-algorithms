package dynamicprogramming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Time Complexity - O(n) → We iterate once through n steps. Space Complexity -
 * O(1) → We use only two variables (prev1 and prev2)
 * 
 */
public class ClimbStairs {

	public static void main(String[] args) {
		ClimbStairs ch = new ClimbStairs();
		System.out.println(ch.climbStairs(3));
	}

	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int prev1 = 2, prev2 = 1;
		for (int i = 3; i <= n; i++) {
			int current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}
		return prev1;
	}

}
