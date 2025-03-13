package stack;

import java.util.*;

/**
 * Internal class representing a cache node.
 */
class Node {
	int key, value, freq;

	/**
	 * Constructs a new node with key, value, and an initial frequency of 1.
	 * 
	 * @param key   The key of the node.
	 * @param value The value of the node.
	 */
	Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.freq = 1;
	}
}

class LFUCache {

	private final int capacity;
	private int minFreq;
	private final Map<Integer, Node> cache;
	private final Map<Integer, LinkedHashSet<Node>> freqMap;

	/**
	 * Initializes the LFU Cache with a given capacity.
	 * 
	 * @param capacity Maximum number of key-value pairs the cache can hold.
	 */
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.minFreq = 0;
		this.cache = new HashMap<>();
		this.freqMap = new HashMap<>();
	}

	/**
	 * Retrieves the value associated with the given key. Updates the frequency of
	 * the accessed key.
	 * 
	 * @param key The key to look for.
	 * @return The value associated with the key, or -1 if not found.
	 */
	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		Node node = cache.get(key);
		updateFrequency(node); // Increase frequency count
		return node.value;
	}

	/**
	 * Inserts a key-value pair into the cache. If the key already exists, updates
	 * its value and frequency. If the cache is full, removes the least frequently
	 * used element before adding a new one.
	 * 
	 * @param key   The key to insert or update.
	 * @param value The value to be stored.
	 */
	public void put(int key, int value) {
		if (capacity == 0)
			return;

		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.value = value; // Update value
			updateFrequency(node); // Increase frequency count
		} else {
			if (cache.size() >= capacity) {
				evictLFU(); // Remove least frequently used node
			}
			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			minFreq = 1; // Reset min frequency to 1 for the new node
			freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
		}
	}

	/**
	 * Updates the frequency of a given node. Moves the node from its current
	 * frequency list to the next higher frequency list.
	 * 
	 * @param node The node to update.
	 */
	private void updateFrequency(Node node) {
		int freq = node.freq;
		freqMap.get(freq).remove(node); // Remove node from current frequency list
		if (freqMap.get(freq).isEmpty() && freq == minFreq) {
			minFreq++; // Update minimum frequency if necessary
		}
		node.freq++; // Increase node frequency
		freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
	}

	/**
	 * Removes the least frequently used (LFU) node from the cache. If multiple
	 * nodes have the same frequency, the oldest one is removed.
	 */
	private void evictLFU() {
		if (freqMap.containsKey(minFreq) && !freqMap.get(minFreq).isEmpty()) {
			Node nodeToRemove = freqMap.get(minFreq).iterator().next(); // Get the oldest node
			freqMap.get(minFreq).remove(nodeToRemove);
			cache.remove(nodeToRemove.key); // Remove node from cache
		}
	}

	public static void main(String[] args) {
		// LRU Cache
		LFUCache cache = new LFUCache(2);

		// Queries
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.print(cache.get(1) + " ");
		cache.put(3, 3);
		System.out.print(cache.get(2) + " ");
		cache.put(4, 4);
		System.out.print(cache.get(1) + " ");
		System.out.print(cache.get(3) + " ");
		System.out.print(cache.get(4) + " ");
	}
}
