package array;

/**
 * Given an array arr of size n, the task is to check if the given array is
 * sorted in (ascending / Increasing / Non-decreasing) order. If the array is
 * sorted then return True, else return False.
 * 
 * Time Complexity:The time complexity is O(n) because it iterates through the
 * array once to check if it's sorted. Space Complexity:The space complexity is
 * O(1) as it uses a constant amount of extra space.
 */
public class ArraySortedOrNot {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(arraySortedOrNot(arr, arr.length));
	}

	static boolean arraySortedOrNot(int[] arr, int n) {

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
