package string;

/**
 * Time Complexity O(n + m) Space Complexity O(m) (for LPS array)
 */
public class KMPSubstringSearch {

	// Builds the Longest Prefix Suffix (LPS) array
	private static int[] buildLPS(String pattern) {
		int m = pattern.length();
		int[] lps = new int[m];

		int len = 0;
		int i = 1;

		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				lps[i++] = ++len;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i++] = 0;
				}
			}
		}

		return lps;
	}

	// KMP search for first occurrence
	public static int search(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();

		if (m == 0)
			return 0;

		int[] lps = buildLPS(pattern);

		int i = 0, j = 0; // i -> text, j -> pattern

		while (i < n) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				if (j == m) {
					return i - j; // match found
				}
			} else {
				if (j != 0) {
					j = lps[j - 1]; // jump using LPS
				} else {
					i++;
				}
			}
		}

		return -1; // not found
	}

	public static void main(String[] args) {
		String text = "abxabcabcaby";
		String pattern = "abcaby";

		int index = search(text, pattern);
		if (index != -1) {
			System.out.println("Pattern found at index: " + index);
		} else {
			System.out.println("Pattern not found.");
		}
	}
}
