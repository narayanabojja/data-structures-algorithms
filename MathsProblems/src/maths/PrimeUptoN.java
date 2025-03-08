package maths;

/**
 * You are given an integer n. You need to find out the number of prime numbers
 * in the range [1, n] (inclusive). Return the number of prime numbers in the
 * range. A prime number is a number which has no divisors except, 1 and itself.
 * Time Complexity:The time complexity is O(n^2), as for every number up to n,
 * it checks for primality which takes O(n) time. Space Complexity:The space
 * complexity is O(1), as no additional space proportional to input size is
 * used.
 */
public class PrimeUptoN {

	public static void main(String[] args) {
		int n = 10;
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		System.out.println("Prime numbers up to " + n + " are " + count);
	}

	public static boolean isPrime(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		return count == 2;
	}
}
