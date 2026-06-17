package string;

/**
 * Time Complexity: O(n⋅n!) Auxiliary Space: O(n)
 * https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
 */
public class StringAllPermitations {
	public static void main(String[] args) {
		String s = "abc";
		permute(s.toCharArray(), 0, s.length() - 1);
	}

	// Helper method to generate permutations
	public static void permute(char[] str, int l, int r) {
		if (l == r) {
			System.out.println(new String(str));
		} else {
			for (int i = l; i <= r; i++) {
				swap(str, l, i); // Fix one character
				permute(str, l + 1, r); // Recur for the rest
				swap(str, l, i); // Backtrack
			}
		}
	}

	// Swap utility
	public static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	/**
	 * permute(A B C, l=0)
  ├─ swap A with A → A B C → permute(l=1)
  │    ├─ swap B with B → A B C → permute(l=2) → ABC
  │    └─ swap B with C → A C B → permute(l=2) → ACB
  ├─ swap A with B → B A C → permute(l=1)
  │    ├─ B A C → BAC
  │    └─ B C A → BCA
  └─ swap A with C → C B A → permute(l=1)
       ├─ C B A → CBA
       └─ C A B → CAB
	 */
}
