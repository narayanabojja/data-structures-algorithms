package bitmanipulation;

/**
 * Given a positive integer n, write a function that returns the number of set
 * bits in its binary representation (also known as the Hamming weight).
 * 
 * Time Complexity: O(32) = O(1) (constant time)
 * 
 * At most 32 iterations (since it's a 32-bit integer)
 * 
 * Space Complexity: O(1) (no extra space used)
 */
public class NumberOf1Bit {

	public static void main(String[] args) {
		int n = 25;
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >> 1;
		}
		System.out.println("Number of 1 Bits F" + count);

	}

}
