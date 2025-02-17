package twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/description/ You are
 * given an integer array height of length n. There are n vertical lines drawn
 * such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerWithMostWater cw = new ContainerWithMostWater();
		System.out.println(cw.maxArea(height));
	}

	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			int w = right - left;
			int h = Math.min(height[left], height[right]);
			int area = h * w;
			maxArea = Math.max(area, maxArea);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

}
