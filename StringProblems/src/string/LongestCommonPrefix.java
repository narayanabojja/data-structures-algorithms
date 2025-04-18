package string;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Time Complexity:The time complexity is O(n*log(n) + m) where n is the number
 * of strings and m is the length of the shortest string, due to sorting and
 * matching of characters. Space Complexity:The space complexity is O(1) if not
 * considering the input array and output storage, otherwise it's O(n*L) where L
 * is the average length of the strings if including input storage.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix lc = new LongestCommonPrefix();
		String[] str = { "flowers", "flow", "fly", "flight" };
		System.out.println(lc.longestCommonPrefix(str));
	}

	/**
	 * To determine the longest common prefix among a set of strings, consider the
	 * following approach: when a list of strings is sorted lexicographically, the
	 * first string and the last string in this sorted list will have the longest
	 * common prefix. This is because, in a sorted list, the closest strings in
	 * terms of lexicographical order are adjacent, making their common prefix the
	 * longest possible for the entire list. For example, if the sorted list is
	 * ["apple", "applet", "banana"], comparing the first and last string in the
	 * sorted order gives the common prefix shared by all strings in the list.
	 * 
	 * @param v
	 * @return
	 */
	public String longestCommonPrefix(String[] v) {
		// Use StringBuilder to build the result
		StringBuilder ans = new StringBuilder();

		// Sort the array to get the lexicographically smallest and largest strings
		Arrays.sort(v);
		// First string (smallest in sorted order)
		String first = v[0];
		// Last string (largest in sorted order)
		String last = v[v.length - 1];

		// Compare characters of the first and last strings
		for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
			// If characters don't match, return the current prefix
			if (first.charAt(i) != last.charAt(i)) {
				return ans.toString();
			}
			// Append the matching character to the result
			ans.append(first.charAt(i));
		}

		// Return the longest common prefix found
		return ans.toString();
	}
}
