package bitmanipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer. Complexity Analysis - Time
 * Complexity: O(32) = O(1) → Since we always loop 32 times, it's constant time.
 * - Space Complexity: O(1) → We use a few integer variables, so the space usage
 * is constant.
 */
public class ReverseBits {

	public static void main(String[] args) {
		int n = 35;
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1; // Shift result left to make space for the next bit
			result |= (n & 1); // Extract the last bit from n and add it to result
			n >>= 1; // Shift n right to process the next bit
		}
		System.out.println("reverse bits " + result);
	}
	/**
	 * Explanation 1. Initialize `result` as `0`. 2. Loop 32 times (since it's a
	 * 32-bit unsigned integer). 3. For each iteration: - Shift `result` left by 1
	 * to create space for the new bit. - Extract the rightmost bit of `n` using `n
	 * & 1`, then add it to `result`. - Shift `n` right by 1 to move to the next
	 * bit. 4. Once all bits are processed, return `result`.
	 * 
	 */
}
