package mergeintervels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] result = merge(intervals);
		for (int[] interval : result) {
			for (int is : interval) {
				System.out.print(is + " ");
			}
			System.out.println();
		}
	}

	/**
	 * If we sort the intervals by their start value, then each set of intervals
	 * that can be merged will appear as a contiguous "run" in the sorted list.
	 * 
	 * 
	 * Time Complexity: O(n log n) Space Complexity: O(n)
	 * 
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int intervalStart = intervals[0][0];
		int intervalEnd = intervals[0][1];
		List<int[]> mergedList = new ArrayList<>();

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] > intervalEnd) {
				mergedList.add(new int[] { intervalStart, intervalEnd });
				intervalStart = intervals[i][0];
				intervalEnd = intervals[i][1];
			} else {
				intervalEnd = Math.max(intervalEnd, intervals[i][1]);
			}
		}
		mergedList.add(new int[] { intervalStart, intervalEnd });
		return mergedList.toArray(new int[mergedList.size()][]);
	}
}
