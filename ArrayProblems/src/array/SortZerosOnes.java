package array;

/**
 * Dutch National Flag Problem. Given an array arr[] consisting of only 0s, 1s,
 * and 2s. The task is to sort the array, i.e., put all 0s first, then all 1s
 * and all 2s in last. Time Complexity: O(n) Auxiliary Space: O(1)
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class SortZerosOnes {

	public static void main(String[] args) {

		int[] arr = { 2, 0, 2, 1, 1, 0 };

		int low = 0;
		int mid = 0;
		int right = arr.length - 1;
		int temp = 0;

		while (mid <= right) {
			switch (arr[mid]) {
			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;

				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[right];
				arr[right] = arr[mid];
				arr[mid] = temp;
				right--;

			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}
