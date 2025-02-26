package binarysearch;

/**
 * Given a sorted array nums and an integer x. Find the floor and ceil of x in
 * nums. The floor of x is the largest element in the array which is smaller
 * than or equal to x. The ceiling of x is the smallest element in the array
 * greater than or equal to x. If no floor or ceil exists, output -1.
 * 
 * Time Complexity:O(log n) due to the binary search algorithm. Space
 * Complexity:O(1) as it uses a constant amount of extra space.
 */
public class FloorAndCeil {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 4, 7, 8, 10 };
		int[] result = getFloorAndCeil(nums, 5);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] getFloorAndCeil(int[] nums, int x) {
		
		int floor = -1;
		int ceil = -1;
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			// If nums[mid]≤x, update the floor to nums[mid] and move right.
			if (nums[mid] <= x) {
				floor = nums[mid];
				l = mid + 1;
			} else { // If nums[mid]≥x, update the ceiling to nums[mid] and move left.
				ceil = nums[mid];
				r = mid - 1;
			}
		}
		return new int[] { floor, ceil };
	}
}
