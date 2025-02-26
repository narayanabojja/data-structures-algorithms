package array;

import java.util.*;

/**
 * Given an integer array nums. Return the number of reverse pairs in the array.
 * An index pair (i, j) is called a reverse pair if:
 * 
 * 0 <= i < j < nums.length nums[i] > 2 * nums[j]. Time Complexity: O(2N *
 * logN), where N is size of the given array. Inside the mergeSort() we call
 * merge() and countPairs() except mergeSort() itself. Now, inside the function
 * countPairs(), though we are running a nested loop, we are actually iterating
 * the left half once and the right half once in total. That is why, the time
 * complexity is O(N). And the merge() function also takes O(N). The mergeSort()
 * takes O(logN) time complexity. Therefore, the overall time complexity will be
 * O(logN x (N+N)) = O(2NxlogN)
 * 
 * Space Complexity: O(N), as in the merge sort, a temporary array to store
 * elements in sorted order is used.
 */
public class ReversePairs {
	/*
	 * Function to count reverse pairs where a[i] > 2 * a[j]
	 */
	public int reversePairs(int[] nums) {
		int n = nums.length;
		return mergeSort(nums, 0, n - 1);
	}

	/*
	 * Merge function to merge two sorted halves and count reverse pairs
	 */
	private void merge(int[] arr, int low, int mid, int high) {
		// temporary array
		List<Integer> temp = new ArrayList<>();

		// starting index of left half of arr
		int left = low;

		// starting index of right half of arr
		int right = mid + 1;

		// Merge and count reverse pairs
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		// Copy remaining elements from left half
		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		// Copy remaining elements from right half
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		// Transfer sorted elements from temp to arr
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
	}

	// Function to count reverse pairs
	private int countPairs(int[] arr, int low, int mid, int high) {
		int right = mid + 1;
		int cnt = 0;

		for (int i = low; i <= mid; i++) {

			/*
			 * while right is less than equal to high and arr[i] is greater than 2 *
			 * arr[right] then increment right by 1
			 */
			while (right <= high && arr[i] > 2 * arr[right])
				right++;

			cnt += (right - (mid + 1));
		}
		// Return the count
		return cnt;
	}

	/*
	 * Merge sort function to sort the array and count reverse pairs
	 */
	private int mergeSort(int[] arr, int low, int high) {
		int cnt = 0;

		if (low >= high) {
			return cnt;
		}

		int mid = low + (high - low) / 2;

		// Sort left half
		cnt += mergeSort(arr, low, mid);

		// Sort right half
		cnt += mergeSort(arr, mid + 1, high);

		// Merge and count pairs
		cnt += countPairs(arr, low, mid, high);
		merge(arr, low, mid, high);

		// Return the count of reverse pairs
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 4, 1, 2, 7 };

		// Create an instance of Solution class
		ReversePairs sol = new ReversePairs();

		int cnt = sol.reversePairs(nums);

		// Print the count of reverse pairs
		System.out.println("The number of reverse pairs is: " + cnt);
	}
}
