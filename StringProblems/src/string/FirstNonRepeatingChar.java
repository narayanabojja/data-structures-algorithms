package string;

/**
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(firstUniqChar(s));
	}

	public static int firstUniqChar(String s) {
		int[] freqArray = new int[26];
		for (char ch : s.toCharArray()) {
			freqArray[ch - 'a']++;
		}
		int i = 0;
		for (char ch : s.toCharArray()) {
			if (freqArray[ch - 'a'] == 1) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
