package array;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum. https://leetcode.com/problems/maximum-subarray/description/
 * Time Complexity: O(N),Space Complexity: O(1)
 */
//Kadane's Algorithm
public class MaxSubArrayKadane {

	public static void main(String[] args) {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			// Add current element to the sum
			if (sum >= 0) {
				sum += array[i];
			} else {
				// Reset sum to 0 if it becomes negative
				sum = array[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		System.out.println("Sub array Max sum " + maxSum);
	}

}
