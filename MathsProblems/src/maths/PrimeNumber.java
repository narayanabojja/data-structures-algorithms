package maths;

/**
 * You are given an integer n. You need to check if the number is prime or not.
 * Return true if it is a prime number, otherwise return false. A prime number
 * is a number which has no divisors except 1 and itself. Time Complexity:The
 * time complexity is O(n) because the code iterates from 1 to n. Space
 * Complexity:The space complexity is O(1) because only a constant amount of
 * extra space is used.
 */
public class PrimeNumber {

	public static void main(String[] args) {
		int n = 5;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		System.out.println("Is Prime number" + (count == 2));

	}

}
