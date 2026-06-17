package twopointers;

/**
 * https://leetcode.com/problems/shuffle-the-array/ Given the array nums
 * consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * 
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * 
 * Time Complexity: O(n)
 * 
 * Space Complexity: O(n)
 * 
 */
public class Shuffle {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 1, 3, 4, 7 };
		int[] res = shuffle(nums, 3);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] result = new int[nums.length];
		for (int i = 0, j = 0; i < n; i++, j++) {
			result[j] = nums[i];
			result[++j] = nums[i + n];
		}
		return result;
	}
}
