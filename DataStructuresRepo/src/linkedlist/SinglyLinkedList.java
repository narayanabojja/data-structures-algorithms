package linkedlist;

/**
 * Class representing a node in a singly linked list.
 */
class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	/**
	 * Constructor to initialize a singly linked list node with data.
	 *
	 * @param data The data to store in the node.
	 */
	public SinglyLinkedListNode(int data) {
		this.data = data;
	}
}

/**
 * Class representing a singly linked list with various operations.
 */
public class SinglyLinkedList {
	SinglyLinkedListNode root;

	/**
	 * Adds a new node with the given data at the beginning of the list.
	 * 
	 * Time Complexity: O(1) Space Complexity: O(1)
	 *
	 * @param data The data to be added.
	 */
	public void addFirst(int data) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		node.next = root;
		root = node;
	}

	/**
	 * Adds a new node with the given data after the specified node.
	 * 
	 * Time Complexity: O(1) Space Complexity: O(1)
	 *
	 * @param previous The node after which the new node is to be added.
	 * @param data     The data to be added.
	 */
	public void addAfter(SinglyLinkedListNode previous, int data) {
		if (previous == null) {
			return;
		}
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		newNode.next = previous.next;
		previous.next = newNode;
	}

	/**
	 * Adds a new node with the given data at the end of the list.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 *
	 * @param data The data to be added.
	 */
	public void addEnd(int data) {
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		if (root == null) {
			root = newNode;
			return;
		}
		SinglyLinkedListNode lastNode = root;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
	}

	/**
	 * Deletes the first node in the list.
	 * 
	 * Time Complexity: O(1) Space Complexity: O(1)
	 */
	public void deleteFirst() {
		if (root != null) {
			root = root.next;
		}
	}

	/**
	 * Deletes the last node in the list.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public void deleteLast() {
		if (root == null || root.next == null) {
			root = null;
			return;
		}
		SinglyLinkedListNode secondLast = root;
		while (secondLast.next.next != null) {
			secondLast = secondLast.next;
		}
		secondLast.next = null;
	}

	/**
	 * Searches for the given data iteratively and returns its position.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 *
	 * @param current The starting node.
	 * @param data    The data to search for.
	 * @return The position of the data, or -1 if not found.
	 */
	public int searchDataIterative(SinglyLinkedListNode current, int data) {
		int pos = 1;
		while (current != null) {
			if (current.data == data) {
				return pos;
			}
			pos++;
			current = current.next;
		}
		return -1;
	}

	/**
	 * Searches for the given data recursively and returns its position.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(n) (due to recursive stack)
	 *
	 * @param current The starting node.
	 * @param data    The data to search for.
	 * @return The position of the data, or -1 if not found.
	 */
	public int searchDataRecursive(SinglyLinkedListNode current, int data) {
		if (current == null) {
			return -1;
		}
		if (current.data == data) {
			return 1;
		}
		int res = searchDataRecursive(current.next, data);
		return (res == -1) ? -1 : 1 + res;
	}

	/**
	 * Reverses the singly linked list iteratively.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public void reverseSinglyLinkedList() {
		SinglyLinkedListNode current = root;
		SinglyLinkedListNode previous = null;
		while (current != null) {
			SinglyLinkedListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		root = previous;
	}

	/**
	 * Reverses the singly linked list recursively.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(n) (due to recursive stack)
	 *
	 * @param current  The current node being processed.
	 * @param previous The previous node in the reversed list.
	 * @return The new root node after reversal.
	 */
	public SinglyLinkedListNode reverseSinglyLinkedListRecursively(SinglyLinkedListNode current,
			SinglyLinkedListNode previous) {
		if (current != null) {
			SinglyLinkedListNode temp = current.next;
			current.next = previous;
			return reverseSinglyLinkedListRecursively(temp, current);
		}
		root = previous;
		return previous;
	}

	/**
	 * Prints the singly linked list iteratively.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public void printSinglyLinkedList() {
		SinglyLinkedListNode temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	/**
	 * Prints the singly linked list recursively.
	 * 
	 * Time Complexity: O(n) Space Complexity: O(n) (due to recursive stack)
	 *
	 * @param root The current node being processed.
	 */
	public void printSinglyLinkedListRecursive(SinglyLinkedListNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printSinglyLinkedListRecursive(root.next);
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.addFirst(1);
		sll.addFirst(2);
		sll.addFirst(3);
		sll.addFirst(4);
		sll.addFirst(5);
		sll.printSinglyLinkedList();

		System.out.println();
		int posIterative = sll.searchDataRecursive(sll.root, 2);
		System.out.println("\n2 pos: " + posIterative);
	}
}