package array;

/**
 * Given an array arr of size n, the task is to find the sum of all the elements
 * in the array. Time Complexity:The time complexity of the given code is O(n),
 * as there is a single for loop that iterates over each element of the array
 * once. Space Complexity:The space complexity of the given code is O(1), as it
 * uses a constant amount of extra space regardless of the input size.
 */
public class ArraySum {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 7, 8, 9 };
		int sumValue = 0;
		for (int i = 0; i < arr.length; i++) {
			sumValue += arr[i];
		}
		System.out.println(" Array sum: " + sumValue);
	}

}
