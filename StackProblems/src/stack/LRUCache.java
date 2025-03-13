package stack;

import java.util.*;

/**
 * Design a data structure that follows the constraints of Least Recently Used
 * (LRU) cache. Implement the LRUCache class:
 * 
 * LRUCache(int capacity): We need to initialize the LRU cache with positive
 * size capacity.
 * 
 * int get(int key): Returns the value of the key if the key exists, otherwise
 * return -1.
 * 
 * void put(int key,int value): Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * 
 * 
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Time Complexity: O(N) (where N is the number of queries) Since the Put and
 * Get method takes an average of constant time, the overall complexity to
 * process all the queries is O(N) time.
 * 
 * Space Complexity: O(cap) (where cap is the capacity of the LRU cache) Since
 * the doubly linked list can store at most of the capacity number of key-value
 * pairs, this takes O(cap) space.
 */
class Node {
	public int key, val;
	public Node next, prev;

	// Constructors
	Node() {
		key = val = -1;
		next = prev = null;
	}

	Node(int k, int value) {
		key = k;
		val = value;
		next = prev = null;
	}
}

// Class implementing LRU cache
public class LRUCache {
	private Map<Integer, Node> mpp; // Map data structure
	private int cap; // Capacity
	private Node head; // Dummy head pointer
	private Node tail; // Dummy tail pointer

	// Method to initialise cache with given capacity
	public LRUCache(int capacity) {
		cap = capacity; // Set the capacity
		mpp = new HashMap<>(); // Clear the cache

		head = new Node();
		tail = new Node();

		// Make the connections
		head.next = tail;
		tail.prev = head;
	}

	/*
	 * Private method to delete node from doubly linked list
	 */
	private void deleteNode(Node node) {

		// Get the previous and next pointers
		Node prevNode = node.prev;
		Node nextNode = node.next;

		// Remove pointers to node
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	// Private method to insert node after head
	private void insertAfterHead(Node node) {

		Node nextNode = head.next;
		head.next = node;
		nextNode.prev = node;
		node.prev = head;
		node.next = nextNode;
	}

	// Method to get the key from cache
	public int get(int key_) {
		// Return -1 if it is not present in cache
		if (!mpp.containsKey(key_))
			return -1;

		Node node = mpp.get(key_); // Get the node
		int val = node.val; // Get the value

		// Delete the node
		deleteNode(node);
		/*
		 * Insert this node to front as it was recently used
		 */
		insertAfterHead(node);

		// Return the stored value
		return val;
	}

	/*
	 * Method to update value if key exists, otherwise insert the key-value pair
	 */
	public void put(int key_, int value) {

		// Update the value if key is already present
		if (mpp.containsKey(key_)) {

			Node node = mpp.get(key_); // Get the node
			node.val = value; // Update the value

			// Delete the node
			deleteNode(node);

			/*
			 * Insert this node to front as it was recently used
			 */
			insertAfterHead(node);

			return;
		}

		// Check if the capacity limit has reached
		if (mpp.size() == cap) {

			// Get the least recently used node
			Node node = tail.prev;

			// Delete node from map
			mpp.remove(node.key);

			// Delete node from doubly linked list
			deleteNode(node);
		}

		// Create a new node
		Node newNode = new Node(key_, value);

		// Insert it in map
		mpp.put(key_, newNode);

		// Insert in doubly linked list
		insertAfterHead(newNode);
	}

	public static void main(String[] args) {
		// LRU Cache
		LRUCache cache = new LRUCache(2);

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
