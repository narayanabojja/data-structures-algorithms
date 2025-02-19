package recursion;

/**
 * Given an integer num, repeatedly add all its digits until the result has only
 * one digit, and return it.
 *  Time Complexity O(log n) – This is because each
 * recursive call processes a number with fewer digits than the previous call,
 * leading to logarithmic time complexity in terms of the number of digits.
 * 
 * SpaceComplexity O(log n) – This space is required for the recursion stack,
 * which grows with the number of digits in the number.
 */
public class AddDigits {

	public static void main(String[] args) {
		AddDigits ad = new AddDigits();
		System.out.println(ad.addDigits(529));
	}

	public int addDigits(int num) {
		if (num < 10) {
			return num;
		}
		int sum = 0;
		while (num > 0) {
			int lastDigit = num % 10;
			sum += lastDigit;
			num = num / 10;
		}
		return addDigits(sum);
	}
}
