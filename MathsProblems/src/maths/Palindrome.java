package maths;

/**
 * Time Complexity:O(d) where d is the number of digits in the number, as each
 * digit is processed once in the while loop. Space Complexity:O(1) as only a
 * fixed amount of extra space is used for variables, regardless of the input
 * size.
 */
public class Palindrome {

	public static void main(String[] args) {
		int n = 121;
		int originalNum = n;
		int rev = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			rev = rev * 10 + lastDigit;
			n = n / 10;
		}
		System.out.println(originalNum == rev);
	}

}
