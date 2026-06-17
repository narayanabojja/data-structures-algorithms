package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an array, you need to perform k operations:
 * 
 * On odd-numbered operations (1st, 3rd, 5th, ...): → take the last element,
 * remove it, and insert it into the middle of the array
 * 
 * On even-numbered operations (2nd, 4th, 6th, ...): → take the first element,
 * remove it, and insert it into the middle of the array
 * 
 * Time complexity: O(k × n) Space Complexity: O(n)
 */
public class ArrayRearrangement {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int k = 4; // number of operations

		System.out.println("Original array: " + Arrays.toString(arr));
		int[] result = performOperations(arr, k);
		System.out.println("Rearranged array: " + Arrays.toString(result));

	}

	public static int[] performOperations(int[] arr, int k) {
		// Using LinkedList for efficient removals and insertions
		LinkedList<Integer> list = new LinkedList<>();
		for (int num : arr) {
			list.add(num);
		}

		for (int op = 1; op <= k; op++) {
			if (op % 2 == 1) {
				// Odd operation: move last to middle
				int last = list.removeLast();
				int mid = list.size() / 2;
				list.add(mid, last);
			} else {
				// Even operation: move first to middle
				int first = list.removeFirst();
				int mid = list.size() / 2;
				list.add(mid, first);
			}
		}

		// Convert back to array
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
