package matrix;

/**
 * You are given an m x n integer grid accounts where accounts[i][j] is the
 * amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​
 * bank. Return the wealth that the richest customer has.
 * 
 * A customer's wealth is the amount of money they have in all their bank
 * accounts. The richest customer is the customer that has the maximum wealth.
 * 
 * https://leetcode.com/problems/richest-customer-wealth/ 
 * 
 * Time Complexity: O(m × n)
 * 
 * Space Complexity: O(1) (optimal)
 * 
 * @param accounts
 * @return
 */
public class MaximumWealth {

	public static void main(String[] args) {
		int[][] accounts = { { 1, 2, 3 }, { 3, 2, 1 } };
		int res = maximumWealthBruteForce(accounts);
		System.out.println("MaximumWealth: " + res);
	}

	public static int maximumWealthBruteForce(int[][] accounts) {
		int maxWealth = 0;
		for (int[] customer : accounts) {
			int wealth = 0;
			for (int money : customer) {
				wealth += money;
			}
			maxWealth = Math.max(maxWealth, wealth);
		}

		return maxWealth;
	}
}
