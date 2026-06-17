package string;

/**
 * Given a string, compress it using the counts of repeated characters, e.g.,
 * "aabcccccaaa" becomes "a2b1c5a3" Time Complexity: O(n) Space Complexity: O(n)
 */
public class StringCompression {

	public static void main(String[] args) {
		String input = "aabcccccaaa";
		System.out.println(compress(input));
	}

	public static String compress(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuilder compressed = new StringBuilder();
		int count = 1;

		for (int i = 1; i <= str.length(); i++) {

			if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				compressed.append(str.charAt(i - 1));
				compressed.append(count);
				count = 1;
			}
		}

		return compressed.toString();
	}

}
