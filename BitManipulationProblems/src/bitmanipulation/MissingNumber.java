package bitmanipulation;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array Time
 * Complexity:O(n) Space Complexity:O(1)
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = { 3, 0, 1 };
		int n = nums.length;
		int xor = 0;
		for (int i = 0; i <= n; i++) {
			xor ^= i;
		}
		for (int num : nums) {
			xor ^= num;
		}
		System.out.println("Missing number " + xor);
	}
	/**
	 * Explanation: 1. XOR all numbers in the range `[0, n]` - This gives the XOR of
	 * all numbers that should be present in the range. 2.XOR all numbers in the
	 * input array: - This removes the effect of the numbers that are actually in
	 * the array from the XOR result. 3. Final XOR result: - Since XOR cancels out
	 * duplicates, the remaining value will be the missing number.
	 * 
	 */
}
