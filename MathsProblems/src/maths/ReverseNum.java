package maths;

/**
 * Time Complexity:The time complexity is O(d), where d is the number of digits
 * in the number n, because we process each digit once. Space Complexity:The
 * space complexity is O(1), as we are using a constant amount of space
 * regardless of the input size.
 */
public class ReverseNum {

	public static void main(String[] args) {
		int n = 25;
		int rev = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			rev = rev * 10 + lastDigit;
			n = n / 10;
		}
		System.out.println(rev);
	}

}
