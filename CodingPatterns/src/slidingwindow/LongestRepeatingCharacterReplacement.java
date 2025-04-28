package slidingwindow;

/**
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 * 
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * 
 * 
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));

	}

	public static int characterReplacement(String s, int k) {
		int left = 0;
		int maxLength = 0;
		int maxFreq = 0;
		int[] charArr = new int[26];
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			charArr[ch - 'A']++;
			maxFreq = Math.max(maxFreq, charArr[ch - 'A']);
			while (right - left + 1 - maxFreq > k) {
				charArr[s.charAt(left) - 'A']--;
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
	/**
	 * The intuition behind this logic lies in using a **sliding window approach**
	 * to find the longest substring where you can replace at most `k` characters to
	 * make all the characters in the substring the same. Let's break it down step
	 * by step:
	 * 
	 * ---
	 * 
	 * ### **Key Observations:** 1. **Fixed-Length Windows Concept:** - To make a
	 * substring valid (all characters the same with at most `k` replacements), the
	 * difference between the window size and the frequency of the most frequent
	 * character (`maxFreq`) in the window must be ≤ `k`. - Formula: `Window size -
	 * maxFreq <= k`. If this condition holds true, you can replace the other
	 * characters to match the most frequent character.
	 * 
	 * 2. **Sliding Window Adjustment:** - By expanding the window with `right`, and
	 * shrinking it with `left` when the condition is violated, you dynamically
	 * adjust the window size to ensure it always represents a valid substring.
	 * 
	 * ---
	 * 
	 * ### **Explanation of the Code:** 1. **Iterate through the string (using
	 * `right`):** - For each character, increase its frequency in the array
	 * `charArr` (which tracks the frequency of characters from 'A' to 'Z'). -
	 * Update `maxFreq` to represent the count of the most frequent character in the
	 * current window.
	 * 
	 * 2. **Check if the window is valid:** - If `right - left + 1 - maxFreq > k`,
	 * it means the current window requires more than `k` replacements to make all
	 * characters the same, so it’s invalid. - To fix this, increment `left` to
	 * shrink the window and reduce its size.
	 * 
	 * 3. **Update the maximum length:** - After adjusting the window, calculate the
	 * current valid window size (`right - left + 1`) and update the `maxLength` if
	 * this size is larger than the previous maximum.
	 * 
	 * ---
	 * 
	 * ### **Intuition Behind Expanding and Contracting:** 1. The window expands by
	 * moving `right`, allowing you to consider longer substrings. 2. When the
	 * substring becomes invalid, the window contracts by moving `left`, ensuring
	 * the substring remains valid. 3. This ensures the algorithm efficiently finds
	 * the maximum length of a valid substring without considering all possible
	 * substrings, avoiding an O(n²) brute-force approach.
	 * 
	 * ---
	 * 
	 * ### **Why It Works?** The algorithm always tries to include as many
	 * characters as possible in the current window while maintaining validity. By
	 * leveraging the sliding window approach, it balances exploration (expanding
	 * the window) with correction (shrinking the window when invalid).
	 * 
	 * Let me know if you'd like any part clarified further! 😊
	 */
	/**
	 * Let’s analyze the **time and space complexity** of the `characterReplacement`
	 * solution:
	 * 
	 * ---
	 * 
	 * ### **Time Complexity:** 1. **Outer Loop** (`for` loop over `right`): - The
	 * loop iterates through each character of the string `s`, and therefore runs
	 * **O(n)** times, where `n` is the length of `s`.
	 * 
	 * 2. **Inner Operations:** - The `while` loop adjusts the `left` pointer when
	 * the window size exceeds `maxFreq + k`. In the worst-case scenario, the `left`
	 * pointer moves across all characters, but this happens incrementally
	 * throughout the string's length. Therefore, the total cost of moving `left` is
	 * **O(n)**.
	 * 
	 * Overall, the **time complexity** is **O(n)** because both `right` and `left`
	 * pointers move across the entire string.
	 * 
	 * ---
	 * 
	 * ### **Space Complexity:** 1. **Character Frequency Array (`charArr`):** - The
	 * array `charArr` has a fixed size of 26 (for uppercase English letters),
	 * regardless of the input size. - Space required is **O(26)**, which simplifies
	 * to **O(1)** (constant space).
	 * 
	 * 2. **Other Variables:** - Only a few integer variables (`left`, `right`,
	 * `maxLength`, `maxFreq`) are used, all of which require constant space.
	 * 
	 * Overall, the **space complexity** is **O(1)**.
	 * 
	 * ---
	 * 
	 * ### **Summary:** - **Time Complexity:** O(n) - **Space Complexity:** O(1)
	 * 
	 * This is an efficient solution that works well even for large strings. Let me
	 * know if you'd like further clarification! 😊
	 */
}
