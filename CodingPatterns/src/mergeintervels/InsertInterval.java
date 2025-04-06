package mergeintervels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 */
public class InsertInterval {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[][] result = insert(intervals, new int[] { 2, 5 });
		for (int[] interval : result) {
			for (int is : interval) {
				System.out.print(is + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * ### **Time Complexity**: 1. **Adding `intervals` and `newInterval` to
	 * `result`**: - Iterating through `intervals` takes **O(n)**, where `n` is the
	 * length of the `intervals` array. - Adding `newInterval` is an **O(1)**
	 * operation.
	 * 
	 * 2. **Sorting `result`:** - Sorting the `result` list using
	 * `Collections.sort()` takes **O(m log m)**, where `m = n + 1` (total number of
	 * intervals after adding `newInterval`).
	 * 
	 * 3. **Merging Intervals:** - The `for` loop iterates over the merged list
	 * (`result`), which takes **O(m)**.
	 * 
	 * Thus, the **overall time complexity** is **O(n + m log m)**, which simplifies
	 * to **O(n log n)** since `m = n + 1`.
	 * 
	 * ---
	 * 
	 * ### **Space Complexity**: 1. **Result List (`result`):** - The `result` list
	 * contains `m = n + 1` intervals, requiring **O(m)** space.
	 * 
	 * 2. **Temporary Merged List (`newResult`):** - The `newResult` list will
	 * contain the merged intervals, requiring **O(k)** space in the worst case,
	 * where `k` is the number of merged intervals. - In the worst case, `k = m`, so
	 * **O(m)**.
	 * 
	 * 3. **Sorting Overhead:** - Sorting may require additional space for temporary
	 * structures, but this is typically negligible in practice.
	 * 
	 * Thus, the **overall space complexity** is **O(m)**.
	 * 
	 * ---
	 * 
	 * ### **Summary**: - **Time Complexity:** **O(n log n)** - **Space
	 * Complexity:** **O(n)**
	 * 
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		for (int[] interval : intervals) {
			result.add(interval);
		}
		result.add(newInterval);
		Collections.sort(result, (a, b) -> a[0] - b[0]);
		int inervalStart = result.get(0)[0];
		int inervalEnd = result.get(0)[1];
		List<int[]> newResult = new ArrayList<>();
		for (int i = 1; i < result.size(); i++) {
			if (result.get(i)[0] > inervalEnd) {
				newResult.add(new int[] { inervalStart, inervalEnd });
				inervalStart = result.get(i)[0];
				inervalEnd = result.get(i)[1];
			} else {
				inervalEnd = Math.max(inervalEnd, result.get(i)[1]);
			}
		}
		newResult.add(new int[] { inervalStart, inervalEnd });
		return newResult.toArray(new int[newResult.size()][]);
	}
}
