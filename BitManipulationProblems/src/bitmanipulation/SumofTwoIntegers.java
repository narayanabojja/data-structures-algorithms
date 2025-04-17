package bitmanipulation;

/**
 * Given two integers a and b, return the sum of the two integers without using
 * the operators + and -. time, space complexity : O(1)
 * 
 */
public class SumofTwoIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(7, 4));

	}

	public static int getSum(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1; // Calculate carry
			a = a ^ b; // Add without carry
			b = carry; // Shift carry to the left
		}
		return a;
	}
	/**
	 * Intuition The intuition behind the solution is based on bitwise operations.
	 * Since we cannot use the + and - operators, we need to simulate the addition
	 * process. A common way to achieve this is by using bitwise XOR and AND
	 * operations. The XOR operation can be used to simulate the addition without
	 * carrying, and the AND operation followed by a left shift can be used to
	 * determine the carry from the addition.
	 */
}
