package string;

/**
 * Given a string s, representing a large integer, the task is to return the
 * largest-valued odd integer (as a string) that is a substring of the given
 * string s.
 * 
 * The number returned should not have leading zero's. But the given input
 * string may have leading zero. Time Complexity:The time complexity is O(n)
 * where n is the length of the string s, due to the loop that iterates over
 * each character from the end of the string until it finds an odd digit. Space
 * Complexity:The space complexity is O(n) where n is the length of the
 * substring returned, which in the worst case could be the entire string.
 */
public class LargeOddNum {

	public static void main(String[] args) {
		String s = "5347";
		int index = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if ((s.charAt(i) - '0') % 2 == 1) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("");
		}
		int i = 0;
		while (i < index) {
			if (s.charAt(i) - '0' != 0) {
				break;
			}
			i++;
		}
		System.out.println(s.substring(i, index + 1));
	}

}
