package array;

import java.util.ArrayList;

/**
 * Given two sorted arrays nums1 and nums2, return an array containing the
 * intersection of these two arrays. The intersection of two arrays is an array
 * where all values are present in both arrays. Time Complexity: O(M), where M
 * is the length of that array which has less elements.
 * 
 * Space Complexity: O(1), extra space to store answer is not considered.
 */
public class IntersectionArray {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 1, 2, 7 };
		int[] result = intersectionArray(nums1, nums2);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}

	public static int[] intersectionArray(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		// Traverse both arrays using two pointers approach
		while (i < nums1.length && j < nums2.length) {
			// nums1[i] == nums2[j]
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		// Convert List<Integer> to int[]
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;
	}
}
