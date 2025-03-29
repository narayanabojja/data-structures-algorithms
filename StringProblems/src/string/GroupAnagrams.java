package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * https://leetcode.com/problems/group-anagrams/description/
 * 
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams ga = new GroupAnagrams();
		System.out.println(ga.groupAnagramsCharFrequency(anagrams));
	}

	/**
	 * Instead of sorting each word, we:
	 * 
	 * Create a frequency array of size 26 (for lowercase English letters).
	 * 
	 * Convert this frequency array into a unique key (e.g., "2#1#0#0#0#...").
	 * 
	 * Use this key to group anagrams in a HashMap.
	 * 
	 * This avoids sorting and improves efficiency. Time Complexity: We traverse the
	 * word (O(k), where k is the max length of a word). For n words, the total
	 * complexity is:
	 * 
	 * O(n * k) for iterating and building frequency arrays.
	 * 
	 * Space Complexity: We store up to n unique keys (in the worst case). Each
	 * value is a list of words → O(n * k) (in worst case, all words are unique).
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagramsCharFrequency(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		// HashMap to store frequency-based key and list of anagrams
		Map<String, List<String>> anagramGroups = new HashMap<>();

		for (String word : strs) {
			// Create frequency array
			int[] charCount = new int[26];
			for (char c : word.toCharArray()) {
				charCount[c - 'a']++;
			}

			// Convert frequency array to a unique key
			StringBuilder keyBuilder = new StringBuilder();
			for (int count : charCount) {
				keyBuilder.append(count).append("#"); // Unique delimiter
			}
			String key = keyBuilder.toString();

			// Store in HashMap
			anagramGroups.putIfAbsent(key, new ArrayList<>());
			anagramGroups.get(key).add(word);
		}

		return new ArrayList<>(anagramGroups.values());
	}

	/**
	 * Create a HashMap<String, List<String>> to store grouped anagrams.
	 * 
	 * For each word:
	 * 
	 * Convert it into a sorted string (which serves as a key).
	 * 
	 * If this key exists in the map, add the word to its corresponding list.
	 * 
	 * If not, create a new list.
	 * 
	 * Return the values of the map as a list of lists
	 * 
	 * Sorting each word: O(k log k), where k is the length of the word. Iterating
	 * through words: O(n), where n is the number of words. Overall: O(n * k log k)
	 * Space Complexity: Storing n words in a HashMap → O(n * k)
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		// HashMap to store sorted string as key and list of anagrams as values
		Map<String, List<String>> anagramGroups = new HashMap<>();

		for (String word : strs) {
			// Convert word into a sorted string
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			String sortedWord = new String(charArray);

			// Add to the corresponding list in HashMap
			anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
			anagramGroups.get(sortedWord).add(word);
		}

		// Return grouped anagrams
		return new ArrayList<>(anagramGroups.values());
	}
}
