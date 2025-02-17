package maths;

/**
 * Time Complexity:The time complexity of the given code is O(log n) because the
 * number of iterations is proportional to the number of digits in n. Space
 * Complexity:The space complexity of the given code is O(1) because it uses a
 * constant amount of space regardless of the input size.
 */
public class LargestDigit {

	public static void main(String[] args) {
		int n = 25;
		int largest = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			largest = Math.max(largest, lastDigit);
			n = n / 10;
		}
		System.out.println(largest);

	}

}
