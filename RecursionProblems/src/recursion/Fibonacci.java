package recursion;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1. Time Complexity:The
 * time complexity of the given code is O(2^n) because each call to the
 * recursive fib function results in two more recursive calls, leading to an
 * exponential growth in calls as n increases. Space Complexity:The space
 * complexity of the given code is O(n) due to the recursion stack, which grows
 * linearly with the depth of the recursion based on n.
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(NthFibonacci(6));
	}

	static int NthFibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return NthFibonacci(n - 1) + NthFibonacci(n - 2);
	}
}
