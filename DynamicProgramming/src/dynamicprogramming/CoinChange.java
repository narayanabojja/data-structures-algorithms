package dynamicprogramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		System.out.println(coinChange(coins, 11));
	}

	/**
	 * Time and Space Complexity - Time Complexity: (O(n * m)), where n is the
	 * amount and m is the number of coin denominations. We iterate over amount, and
	 * for each amount, we iterate over coins. - Space Complexity: (O(n)), since we
	 * use an array of size amount + 1. Let me know if you need further
	 * clarification!
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
	/**
	 * What Each Part Represents - dp[i]: The minimum number of coins required to
	 * form amount i. - dp[i - coin]: The minimum number of coins needed for amount
	 * (i - coin). This represents the amount left after using one coin of value
	 * coin. - dp[i - coin] + 1: The +1 accounts for the fact that we are adding one
	 * more coin (of value coin) to form amount i. - Math.min(dp[i], dp[i - coin] +
	 * 1): We take the minimum because we want the fewest number of coins possible
	 * to form amount i.
	 * coins = [1, 2, 5]
		amount = 3
		dp[0] = 0   // Base case: 0 coins needed to form amount 0
		dp[1] = Math.min(dp[1], dp[1 - 1] + 1) = Math.min(INF, 0 + 1) = 1
		dp[2] = Math.min(dp[2], dp[2 - 1] + 1) = Math.min(INF, 1 + 1) = 2
         Math.min(dp[2], dp[2 - 2] + 1) = Math.min(2, 0 + 1) = 1
		dp[3] = Math.min(dp[3], dp[3 - 1] + 1) = Math.min(INF, 1 + 1) = 2
        Math.min(dp[3], dp[3 - 2] + 1) = Math.min(2, 1 + 1) = 2
        dp[3] = 2 (Using coins {1, 2})
	 */
}
