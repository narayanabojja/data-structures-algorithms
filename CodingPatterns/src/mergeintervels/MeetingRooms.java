package mergeintervels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time interval objects consisting of start and end
 * times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a
 * person could add all meetings to their schedule without any conflicts.
 * 
 * https://neetcode.io/solutions/meeting-rooms
 */
class Interval {
	int start;
	int end;

	Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}

public class MeetingRooms {

	public static void main(String[] args) {
		Interval i3 = new Interval(15, 20);
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		List<Interval> intervals = new ArrayList<>();
		intervals.addAll(Arrays.asList(i1, i2, i3));
		System.out.println(canAttendMeetings(intervals));
	}

	/**
	 * Time & Space Complexity Time complexity:O(nlogn) Space complexity: O(1) or
	 * O(n) depending on the sorting algorithm.
	 * 
	 * @param intervals
	 * @return
	 */
	public static boolean canAttendMeetings(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
		for (int i = 1; i < intervals.size(); i++) {
			Interval prev = intervals.get(i - 1);
			Interval next = intervals.get(i);
			if (prev.end > next.start) {
				return false;
			}
		}
		return true;
	}
}
