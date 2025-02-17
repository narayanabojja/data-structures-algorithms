package array;

/**
 * https://leetcode.com/problems/rotate-array/description/ Given an integer
 * array nums, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * 
 * Time complexity O(n) Space complexity O(1)
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 2;
		leftRotate(arr, k);
		System.out.println("Left rotate");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
		rightRotate(arr2, k);
		System.out.println("\nRight rotate");
		for (int i : arr2) {
			System.out.print(i + " ");
		}
	}

	// Function to left rotate array elements by d positions
	public static void leftRotate(int arr[], int d) {
		int n = arr.length;
		// To handle case when d >= n
		d = d % n;

		// Reverse the first d elements
		reverse(arr, 0, d - 1);
		// Reverse the remaining elements
		reverse(arr, d, n - 1);
		// Reverse the whole array
		reverse(arr, 0, n - 1);
	}

	// Function to right rotate array elements by d positions
	public static void rightRotate(int arr[], int d) {
		int n = arr.length;
		// To handle case when d >= n
		d = d % n;

		// Reverse the first n-d elements
		reverse(arr, 0, n - d - 1);
		// Reverse the remaining elements
		reverse(arr, n - d, n - 1);
		// Reverse the whole array
		reverse(arr, 0, n - 1);
	}

	public static void reverse(int arr[], int start, int end) {
		while (start < end) {
			// swapping of two numbers
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
