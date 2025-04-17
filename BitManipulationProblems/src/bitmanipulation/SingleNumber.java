package bitmanipulation;

/**
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * Time Complexity:O(n) because the code iterates through the input array nums
 * once. Space Complexity:O(1) because the code uses a constant amount of extra
 * space.
 * 
 */
public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1 };
		int targetValue = 0;
		for (int i = 0; i < nums.length; i++) {
			targetValue ^= nums[i];
		}
		System.out.println("Unique number: " + targetValue);
	}

}
