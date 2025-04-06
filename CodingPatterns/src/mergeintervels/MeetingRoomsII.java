package mergeintervels;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of meeting time interval objects consisting of start and end
 * times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the
 * minimum number of days required to schedule all meetings without any
 * conflicts.
 * https://neetcode.io/solutions/meeting-rooms-ii
 * 
 */
public class MeetingRoomsII {

	public static void main(String[] args) {
		int[][] intervals = { { 0, 40 }, { 5, 10 }, { 15, 20 } };
		System.out.println(minMeetingDays(intervals));
	}

	/**
	 * Time & Space Complexity Time complexity: O(nlogn) Space complexity:O(n)
	 * 
	 * @param intervals
	 * @return
	 */
	public static int minMeetingDays(int[][] intervals) {
		List<int[]> events = new ArrayList<>();

		// Create start and end events
		for (int[] interval : intervals) {
			events.add(new int[] { interval[0], 1 }); // Meeting start
			events.add(new int[] { interval[1], -1 }); // Meeting end
		}

		// Sort events by time, resolving ties by sorting end (-1) before start (+1)
		events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int daysNeeded = 0, count = 0;

		// Traverse events and find the maximum number of overlapping meetings
		for (int[] event : events) {
			count += event[1];
			daysNeeded = Math.max(daysNeeded, count);
		}

		return daysNeeded; // Peak overlap = minimum number of days needed
	}
	/**
	 * This method calculates the minimum number of meeting rooms required to hold
	 * all meetings without overlap. Here's the step-by-step explanation:
	 * 
	 * ---
	 * 
	 * ### **Step-by-Step Logic**:
	 * 
	 * 1. **Create a List of Timings (`time`):** - For each meeting interval (`i`),
	 * you record: - A **start time** with a value of `1` (indicating one meeting
	 * starts at this time). - An **end time** with a value of `-1` (indicating one
	 * meeting ends at this time). - This creates a list of events, where each event
	 * is represented as an array `[time, 1/-1]`.
	 * 
	 * Example: If the intervals are `[(1, 5), (2, 6), (8, 9)]`, the `time` list
	 * becomes: ``` [[1, 1], [5, -1], [2, 1], [6, -1], [8, 1], [9, -1]] ```
	 * 
	 * ---
	 * 
	 * 2. **Sort the `time` List:** - The list is sorted based on: 1. **Ascending
	 * order of time** (`a[0] - b[0]`). 2. If two events have the same time, sort by
	 * the second value (`a[1] - b[1]`), so that: - `1` (start) comes before `-1`
	 * (end) if they occur at the same time. - After sorting, the list looks like:
	 * ``` [[1, 1], [2, 1], [5, -1], [6, -1], [8, 1], [9, -1]] ```
	 * 
	 * ---
	 * 
	 * 3. **Iterate Through the Sorted Events:** - A variable `count` keeps track of
	 * the **number of ongoing meetings** at any given time. - Another variable
	 * `res` keeps track of the **maximum value of `count`** (i.e., the peak number
	 * of simultaneous meetings).
	 * 
	 * For each event in `time`: - If it's a `start` event (`1`), increment `count`.
	 * - If it's an `end` event (`-1`), decrement `count`. - Update `res` to the
	 * maximum of its current value and `count`.
	 * 
	 * Example: ``` [[1, 1], [2, 1], [5, -1], [6, -1], [8, 1], [9, -1]] Step 1:
	 * count = 1 (start at time 1), res = 1 Step 2: count = 2 (start at time 2), res
	 * = 2 Step 3: count = 1 (end at time 5), res = 2 Step 4: count = 0 (end at time
	 * 6), res = 2 Step 5: count = 1 (start at time 8), res = 2 Step 6: count = 0
	 * (end at time 9), res = 2 ```
	 * 
	 * ---
	 * 
	 * 4. **Return the Result:** - At the end, `res` contains the maximum number of
	 * ongoing meetings at any point, which equals the minimum number of meeting
	 * rooms required.
	 * 
	 * ---
	 * 
	 * ### **Why It Works:** This approach essentially simulates a "timeline,"
	 * where: - Each `start` event adds a meeting to the room. - Each `end` event
	 * frees up a room. The **peak number of ongoing meetings** is the answer.
	 * 
	 * ---
	 * 
	 *
	 */
}
