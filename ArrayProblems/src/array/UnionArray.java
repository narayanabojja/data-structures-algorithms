package array;

import java.util.ArrayList;

/**
 * Given two sorted arrays nums1 and nums2, return an array that contains the
 * union of these two arrays. The elements in the union must be in ascending
 * order. The union of two arrays is an array where all values are distinct and
 * are present in either the first array, the second array, or both. Time
 * Complexity: O(M+N), because both the arrays must be traversed once.
 * 
 * Space Complexity: O(M+N) The auxiliary space used is O(1) as no extra space
 * is used. However, considering the space for returning the output, the overall
 * space complexity will be O(M+N).
 */
public class UnionArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 1, 2, 7 };
		int[] result = unionArray(nums1, nums2);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] unionArray(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
		int m = nums1.length;
		int n = nums2.length;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			// Case 1 and 2
			if (nums1[i] <= nums2[j]) {
				if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
					list.add(nums1[i]);
				}
				i++;
			} else {// Case 3
				if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
					list.add(nums2[j]);
				}
				j++;
			}
		}
		// Add remaining elements of nums1, if any
		while (i < m) {
			if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
				list.add(nums1[i]);
			}
			i++;
		}
		// Add remaining elements of nums2, if any
		while (j < n) {
			if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
				list.add(nums2[j]);
			}
			j++;
		}
		// Convert List<Integer> to int[]
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;
	}
}
