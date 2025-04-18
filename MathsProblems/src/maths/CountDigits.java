package maths;

/**
 * Time Complexity : O(log10(n)) or O(number of digits), where n is the input
 * number Auxiliary Space: O(1) or constant
 */
public class CountDigits {

	public static void main(String[] args) {
		int number = 45789;
		int count = 0;
		while (number > 0) {
			number /= 10;
			count++;
		}
		System.out.println("Digits count: " + count);
	}

}
