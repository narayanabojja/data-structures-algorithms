package linkedlist;

/**
 * Class representing a node in a doubly linked list.
 */
class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode next;
	DoublyLinkedListNode prev;

	/**
	 * Constructor to create a new node with the given data.
	 *
	 * @param data The value to store in the node.
	 */
	public DoublyLinkedListNode(int data) {
		super();
		this.data = data;
	}
}

/**
 * Class representing a doubly linked list.
 */
public class DoublyLinkedList {
	
	private DoublyLinkedListNode head;

	/**
	 * Inserts a new node with the given data at the beginning of the list.
	 *
	 * Time Complexity: O(1) Space Complexity: O(1)
	 *
	 * @param data The data to insert.
	 * @return The new head of the list.
	 */
	public DoublyLinkedListNode addFirst(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		return head;
	}

	/**
	 * Inserts a new node with the given data after the specified node.
	 *
	 * Time Complexity: O(1) Space Complexity: O(1)
	 *
	 * @param prev The node after which the new node should be inserted.
	 * @param data The data for the new node.
	 */
	public void addAfter(DoublyLinkedListNode prev, int data) {
		if (prev == null) {
			return;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = prev.next;
		newNode.prev = prev;
		prev.next = newNode;
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}

	/**
	 * Inserts a new node with the given data before the specified node.
	 *
	 * Time Complexity: O(1) Space Complexity: O(1)
	 *
	 * @param next The node before which the new node should be inserted.
	 * @param data The data for the new node.
	 */
	public void addBefore(DoublyLinkedListNode next, int data) {
		if (next == null) {
			return;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = next;
		newNode.prev = next.prev;
		next.prev = newNode;
		if (newNode.prev != null) {
			newNode.prev.next = newNode;
		}
	}

	/**
	 * Appends a new node with the given data at the end of the list.
	 *
	 * Time Complexity: O(n), where n is the number of nodes in the list Space
	 * Complexity: O(1)
	 *
	 * @param data The data for the new node.
	 */
	public void addEnd(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		if (head == null) {
			head = newNode;
			return;
		}
		DoublyLinkedListNode lastNode = head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
		newNode.prev = lastNode;
	}

	/**
	 * Prints the elements of the doubly linked list from head to tail.
	 *
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public void printDoublyLinkedList() {
		DoublyLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Reverses the doubly linked list in-place.
	 *
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public void reverse() {
		DoublyLinkedListNode temp = null;
		DoublyLinkedListNode current = head;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}
	}

	/**
	 * Deletes the head node of the list.
	 *
	 * Time Complexity: O(1) Space Complexity: O(1)
	 */
	public void deleteHead() {
		if (head == null) {
			return;
		}
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
	}

	/**
	 * Deletes the last node of the list.
	 *
	 * Time Complexity: O(n) Space Complexity: O(1)
	 */
	public void deleteEnd() {
		if (head == null) {
			return;
		}
		DoublyLinkedListNode last = head;
		while (last.next != null) {
			last = last.next;
		}
		if (last.prev != null) {
			last.prev.next = null;
		} else {
			// Only one node in list
			head = null;
		}
		last.prev = null;
	}

	/**
	 * Main method to demonstrate usage of the DoublyLinkedList.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFirst(4);
		DoublyLinkedListNode node5 = dll.addFirst(5);
		dll.addFirst(1);
		dll.addFirst(7);
		dll.addAfter(node5, 10);
		dll.addBefore(node5, 6);
		dll.addEnd(9);
		dll.printDoublyLinkedList();
		// dll.reverse();
		dll.deleteEnd();
		dll.printDoublyLinkedList();
	}
}
