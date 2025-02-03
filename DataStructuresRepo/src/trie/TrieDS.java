package trie;

/**
 * time complexities:
 * 
 * Insert, Search, StartsWith:O(m) where m is the length of the word.
 * https://takeuforward.org/data-structure/implement-trie-1/
 */
class Trie {
	private TrieNode root;

	// Initialize the data structure
	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the Trie
	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	// Checks if the word is in the Trie
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	// Checks if there is any word in the Trie that starts with the prefix
	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}

	// Helper function to search a prefix or whole word
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			if (node.containsKey(ch)) {
				node = node.get(ch);
			} else {
				return null;
			}
		}
		return node;
	}

	// TrieNode definition
	private class TrieNode {
		private static final int R = 26; // Number of lowercase English letters
		private TrieNode[] links;
		private boolean isEnd;

		public TrieNode() {
			links = new TrieNode[R];
		}

		public boolean containsKey(char ch) {
			return links[ch - 'a'] != null;
		}

		public TrieNode get(char ch) {
			return links[ch - 'a'];
		}

		public void put(char ch, TrieNode node) {
			links[ch - 'a'] = node;
		}

		public void setEnd() {
			isEnd = true;
		}

		public boolean isEnd() {
			return isEnd;
		}
	}
}

public class TrieDS {

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println("Inserting words: Striver, Striving, String, Strike");
		trie.insert("striver");
		trie.insert("striving");
		trie.insert("string");
		trie.insert("strike");

		System.out.println("Search if Strawberry exists in trie: " + (trie.search("strawberry") ? "True" : "False"));

		System.out.println("Search if Strike exists in trie: " + (trie.search("strike") ? "True" : "False"));

		System.out.println("If words in Trie start with Stri: " + (trie.startsWith("stri") ? "True" : "False"));

	}

}
