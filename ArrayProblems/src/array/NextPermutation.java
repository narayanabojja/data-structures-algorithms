package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/
 * 
 * Time complexity: O(n) Space complexity: O(1)
 */
public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void nextPermutation(int[] arr) {
		int index = -1;
		int n = arr.length;
		// Find the first decreasing element from the right.
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				index = i;
				break;
			}
		}
		// If there is no decreasing element, just reverse the array to get next
		// permutation
		if (index == -1) {
			reverse(arr, 0, arr.length - 1);
			return;
		}
		// Find the element which is greater than breakpoint and swap it
		for (int i = n - 1; i > index; i--) {
			if (arr[i] > arr[index]) {
				swap(arr, i, index);
				break;
			}
		}
		// Finally reverse the subarray from index element
		reverse(arr, index + 1, arr.length - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
