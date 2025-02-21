package array;

/**
 * Given an array of positive integers arr[], return the second largest element
 * from the array. If the second largest element doesn't exist then return -1.
 * Time complexity of O(n) Space complexity O(1)
 */
public class SecondLargest {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 2, 3, 13 };
		System.out.println(print2largest(arr));
		System.out.println("Minimum value: " + minValue(arr));
		System.out.println("Max value: " + maxValue(arr));
	}

	static int print2largest(int arr[]) {
		// Check if the array has less than 2 elements
		if (arr == null || arr.length < 2) {
			/*
			 * If true, return -1 indicating there is no second largest element
			 */
			return -1;
		}
		/*
		 * Initialize variables to store the largest and second largest elements
		 */
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		/*
		 * Single traversal to find the largest and second largest elements
		 */
		for (int i : arr) {
			if (i > largest) {
				secondLargest = largest;
				largest = i;
			} else if (i > secondLargest && i != largest) {
				secondLargest = i;
			}
		}
		// Return the second largest element
		if (secondLargest == Integer.MIN_VALUE) {
			return -1;
		}
		return secondLargest;
	}

	static int minValue(int arr[]) {
		int min = Integer.MAX_VALUE;
		for (int i : arr) {
			min = Math.min(i, min);
		}
		return min;
	}

	static int maxValue(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(i, max);
		}
		return max;
	}
}
