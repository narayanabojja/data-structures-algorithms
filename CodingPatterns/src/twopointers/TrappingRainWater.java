package twopointers;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * https://leetcode.com/problems/trapping-rain-water/description/ Time
 * complexity: O(n) Space complexity: O(1)
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater trw = new TrappingRainWater();
		System.out.println(trw.trap(height));
	}

	/**
	 * You’re finding water trapped over every bar in the histogram. Water above
	 * each bar depends on the tallest bar to the left and tallest to the right.
	 * Calculate the total amount of water trapped between many bars after raining.
	 * Sum of water above each bar: water trapped at index i depends on max heights
	 * to its left and right.
	 * 
	 * We track the highest bar seen so far from both ends (leftMax, rightMax)
	 * 
	 * Move the pointer on the shorter side
	 * 
	 * Water trapped above current bar = (current max boundary - bar height)
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[left];
		int rightMax = height[right];
		int water = 0;

		while (left < right) {
			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, height[left]);
				water += leftMax - height[left];
			} else {
				right--;
				rightMax = Math.max(rightMax, height[right]);
				water += rightMax - height[right];
			}
		}

		return water;
	}
}
