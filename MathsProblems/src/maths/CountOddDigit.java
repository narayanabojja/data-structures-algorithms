package maths;

/**
 * Time Complexity : O(log10(n)) or O(number of digits), where n is the input
 * number Auxiliary Space: O(1) or constant
 */
public class CountOddDigit {

	public static void main(String[] args) {
		int n = 25;
		int count = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			if (lastDigit % 2 != 0) {
				count++;
			}
			n = n / 10;
		}
		System.out.println(count);
	}

}
