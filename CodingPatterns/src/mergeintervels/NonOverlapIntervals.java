package mergeintervels;

import java.util.Arrays;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of
 * the intervals non-overlapping.
 * 
 * Note that intervals which only touch at a point are non-overlapping. For
 * example, [1, 2] and [2, 3] are non-overlapping.
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 * 
 */
public class NonOverlapIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(eraseOverlapIntervals(intervals));
	}

	/**
	 * Time & Space Complexity Time complexity: O ( n log ⁡ n ) 
	 * Space complexity: O(1) or O(n) depending on the sorting algorithm.
	 * 
	 * @param intervals
	 * @return
	 */
	public static int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int res = 0;
		int prevEnd = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			if (start >= prevEnd) {
				prevEnd = end;
			} else {
				res++;
				prevEnd = Math.min(end, prevEnd);
			}
		}
		return res;
	}
}
