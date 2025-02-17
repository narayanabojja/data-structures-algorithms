package twopointers;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * https://leetcode.com/problems/merge-sorted-array/description/
 * 
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		MergeSortedArray ms = new MergeSortedArray();
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		ms.merge(nums1, 3, nums2, 3);
		for (int i : nums1) {
			System.out.print(i + " ");
		}
	}

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
