package merge;

/**
 * Merge sort is a sorting algorithm that follows the divide-and-conquer
 * approach. It works by recursively dividing the input array into smaller
 * subarrays and sorting those subarrays then merging them back together to
 * obtain the sorted array. Time Complexity: O(nlogn) Space Complexity: O(n)
 * 
 */
public class MergeSortAlgo {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = left + (right - left) / 2;
			// Recursively sort the left and right halves
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	private static void merge(int[] array, int left, int mid, int right) {

		// Length of left sub-array
		int n1 = mid - left + 1;
		// Length of right sub-array
		int n2 = right - mid;
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		// Copy data to temporary arrays
		for (int i = 0; i < n1; i++) {
			leftArr[i] = array[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArr[j] = array[mid + 1 + j];
		}

		// Initial indices for left, right, and merged array
		int k = left;
		int i = 0;
		int j = 0;

		// Merge the left and right arrays
		while (i < n1 && j < n2) {
			if (leftArr[i] <= rightArr[j]) {
				array[k] = leftArr[i];
				i++;

			} else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}

		// Copy any remaining elements from left array
		while (i < n1) {
			array[k] = leftArr[i];
			i++;
			k++;
		}
		// Copy any remaining elements from right array
		while (j < n2) {
			array[k] = rightArr[j];
			j++;
			k++;
		}

	}
}
