package array;

import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2. Both arrays are sorted in
 * non-decreasing order.Merge both the arrays into a single array sorted in
 * non-decreasing order. The final sorted array should be stored inside the
 * array nums1 and it should be done in-place. nums1 has a length of m + n,
 * where the first m elements denote the elements of nums1 and rest are 0s.
 * nums2 has a length of n. Time Complexity:O(n), where n is the number of
 * elements in nums2, as the while loop iterates at most n times. Space
 * Complexity:O(1), as the algorithm uses a constant amount of extra space.
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };

		//sorting approach
		int m = 3;
		for (int i = 0; i < nums2.length; i++) {
			nums1[m + i] = nums2[i];
		}
		Arrays.sort(nums1);
		for (int i : nums1) {
			System.out.print(i + " ");
		}
	}
	//Optimal approach 
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
	}
	
}
