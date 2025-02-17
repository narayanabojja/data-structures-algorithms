package array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 */
public class BuyAndSellStock2 {

	public static void main(String[] args) {
		int[] prices = { 7, 6, 4, 3, 1 };

		int maximumProfit = 0;
		int minimum = prices[0];

		for (int i = 1; i < prices.length; i++) {
			minimum = Math.min(minimum, prices[i]);
			int profit = prices[i] - minimum;
			if (profit > 0) {
				minimum = prices[i];
				maximumProfit += profit;
			}
		}
		System.out.println("Maximum Profit " + maximumProfit);

	}

	// Second approach
	public int maxProfit(int[] prices) {
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
	}
}
