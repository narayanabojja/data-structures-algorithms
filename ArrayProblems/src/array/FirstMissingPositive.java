package array;

/**
 * Given an unsorted array arr[] with both positive and negative elements, the
 * task is to find the smallest positive number missing from the array.
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/#better-approach-using-auxiliary-space-on-time-and-on-space
 * 
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] arr = { 2, -3, 4, 1, 1, 7 };
		System.out.println(missingNumberUsingCyclicSort(arr));
	}

	/**
	 * The idea is to create a visited array, to keep track of which numbers from
	 * the original array were present. For each positive number in the input array,
	 * we mark its corresponding position in the visited array. After that, we go
	 * through the visited array to find the first position that isn’t visited. The
	 * first unvisited index tells us the first missing positive number. Note that
	 * we are marking numbers within the range from 1 to n only.
	 * 
	 * @param arr
	 * @return
	 */
	static int missingNumber(int[] arr) {
		int n = arr.length;

		// To mark the occurrence of elements
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i++) {

			// if element is in range from 1 to n
			// then mark it as visited
			if (arr[i] > 0 && arr[i] <= n)
				vis[arr[i] - 1] = true;
		}

		// Find the first element which is unvisited
		// in the original array
		for (int i = 1; i <= n; i++) {
			if (!vis[i - 1]) {
				return i;
			}
		}

		// if all elements from 1 to n are visited
		// then n+1 will be first positive missing number
		return n + 1;
	}

	// O(n) Time and O(1) Space
	/**
	 * The idea is similar to Cycle Sort and move each element in the array to its
	 * correct position based on its value. So for each number, say x, such that 1
	 * <= x <= n, is placed at the (x – 1)th index.
	 * 
	 * 
	 * Finally, iterate through the array and check if the numbers are in the
	 * expected indexes or not. The first place where the number doesn’t match its
	 * index gives us the first missing positive number. If all the numbers from 1
	 * to n, are at their correct indexes, then the next number i.e., n + 1, is the
	 * smallest missing positive number.
	 * 
	 * @param arr
	 * @return
	 */
	static int missingNumberUsingCyclicSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}
}
