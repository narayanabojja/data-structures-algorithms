package array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 */
public class BuyAndSellStock {

	// O(n) Time and O(1) Space
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maximumProfit = 0;
		int minimum = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minimum = Math.min(minimum, prices[i]);
			maximumProfit = Math.max(maximumProfit, prices[i] - minimum);
		}
		System.out.println("Maximum Profit " + maximumProfit);
	}

}
