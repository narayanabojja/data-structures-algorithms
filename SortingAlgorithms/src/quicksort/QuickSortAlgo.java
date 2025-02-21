package quicksort;

/**
 * QuickSort is a sorting algorithm based on the Divide and Conquer algorithm
 * that picks an element as a pivot and partitions the given array around the
 * picked pivot by placing the pivot in its correct position in the sorted
 * array. Time Complexity: O(n2), O(nlogn) Space Complexity: O(logn)
 * 
 */
public class QuickSortAlgo {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			// Partition the array and get the pivot index
			int pi = partition(array, low, high);
			// Recursively sort the left and right subarrays
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		
		// Choose the last element as the pivot
		int pivot = array[high];
		// Index of smaller element
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				// Swap arr[i] and arr[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// Place the pivot in the correct position
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		
		// Return pivot index
		return i + 1;
	}
}
