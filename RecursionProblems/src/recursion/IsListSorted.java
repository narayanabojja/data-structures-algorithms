package recursion;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return true if the array nums is sorted in
 * non-decreasing order or else false. Time Complexity:The time complexity of
 * the code is O(n) because each element in the list is accessed exactly once in
 * a single pass. Space Complexity:The space complexity is O(n) due to the
 * recursive call stack consuming space proportional to the size of the list.
 */
public class IsListSorted {

	public static void main(String[] args) {
		IsListSorted is = new IsListSorted();
		System.out.println(is.isListSorted(Arrays.asList(1, 2, 3, 4, 5), 0));
	}

	public boolean isSorted(List<Integer> nums) {
		return isListSorted(nums, 0);
	}

	boolean isListSorted(List<Integer> nums, int i) {
		if (i == nums.size() - 1) {
			return true;
		}
		if (nums.get(i) > nums.get(i + 1)) {
			return false;
		}
		return isListSorted(nums, i + 1);
	}
}
