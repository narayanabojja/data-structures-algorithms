package maths;

/**
 * Time Complexity:The time complexity of the given code is O(n) because the
 * function is called recursively n times. Space Complexity:The space complexity
 * of the given code is O(n) due to the additional space required for the call
 * stack in the recursion.
 */
public class Factorial {

	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorial(5));

	}

	public int factorial(int n) {
		if (n < 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
