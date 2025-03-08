package maths;

/**
 * You are given an integer n. You need to check whether it is an armstrong
 * number or not. Return true if it is an armstrong number, otherwise return
 * false. An armstrong number is a number which is equal to the sum of the
 * digits of the number, raised to the power of the number of digits.
 */
public class Armstrong {

	public static void main(String[] args) {
		Armstrong as = new Armstrong();
		System.out.println(as.isArmstrong(153));
	}

	/**
	 * Time Complexity:The time complexity is O(d^2) since for each of the d digits,
	 * we perform a multiplication operation d times in the pow method, alongside
	 * looping through digits with countDigits. Space Complexity:The space
	 * complexity is O(1) as we are using a constant amount of extra space for
	 * storing integers, regardless of input size.
	 * 
	 * @param n
	 * @return
	 */
	public boolean isArmstrong(int n) {
		int originalNum = n;
		int count = countDigits(n);
		int numSum = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			numSum += pow(lastDigit, count);
			n = n / 10;
		}
		return numSum == originalNum;
	}

	int pow(int n, int c) {
		int mul = 1;
		for (int i = 1; i <= c; i++) {
			mul = mul * n;
		}
		return mul;
	}

	int countDigits(int n) {
		int count = 0;
		while (n > 0) {
			n = n / 10;
			count++;
		}
		return count;
	}
}
