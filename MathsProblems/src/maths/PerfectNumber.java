package maths;

/**
 * You are given an integer n. You need to check if the number is a perfect
 * number or not. Return true if it is a perfect number, otherwise, return
 * false.A perfect number is a number whose proper divisors add up to the number
 * itself.
 * 
 * Time Complexity: O(N) – Looping N times to find the count of all divisors of
 * N. Space Complexity: O(1) – Using a couple of variables i.e., constant space.
 */
public class PerfectNumber {

	public static void main(String[] args) {
		int n = 12;
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		System.out.println("Is Perfect : " + (sum == n));
	}

}
