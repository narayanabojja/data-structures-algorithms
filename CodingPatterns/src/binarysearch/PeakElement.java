package binarysearch;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Time complexity: O(log n) Space complexity: O(1)
 */
public class PeakElement {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(findPeakElement(nums));
	}

	public static int findPeakElement(int[] arr) {

		// Edge cases:
		if (arr.length == 1 || arr[0] > arr[1]) {
			return 0;
		}
		int n = arr.length;
		if (arr[n - 1] > arr[n - 2]) {
			return n - 1;
		}
		int lo = 1;
		int hi = arr.length - 2;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			// If arr[mid] is the peak:
			if ((arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1])) {
				return mid;
			}
			// If we are in the left:
			if (arr[mid] > arr[mid - 1]) {
				lo = mid + 1;
			} else {// If we are in the right:
				// Or, arr[mid] is a common point:
				hi = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Time Complexity:O( N), where N is size of the array. As the for loop is
	 * running for N times only.
	 * 
	 * Space Complexity: As no additional space is used, so the Space Complexity is
	 * O(1).
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public int findPeakElementLinearSearch(int[] arr) {
		// Size of array
		int n = arr.length;

		/*
		 * Iterate through the array to find the peak element
		 */
		for (int i = 0; i < n; i++) {

			// Check if arr[i] is a peak
			if ((i == 0 || arr[i - 1] < arr[i]) && (i == n - 1 || arr[i] > arr[i + 1])) {

				// Return the index of peak element
				return i;
			}
		}
		/*
		 * Return -1 if no peak element found (dummy return)
		 */
		return -1;
	}
}
