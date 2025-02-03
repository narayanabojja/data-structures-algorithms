package singly;

public class ReverseNodesKGroup {

	public static void main(String[] args) {
		// Create a linked list with
		// values 5, 4, 3, 7, 9 and 2
		SingleLinkedList head = new SingleLinkedList(5);
		head.next = new SingleLinkedList(4);
		head.next.next = new SingleLinkedList(3);
		head.next.next.next = new SingleLinkedList(7);
		head.next.next.next.next = new SingleLinkedList(9);
		head.next.next.next.next.next = new SingleLinkedList(2);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		printLinkedList(head);

		// Reverse the linked list
		head = kReverse(head, 4);

		// Print the reversed linked list
		System.out.print("Reversed Linked List: ");
		printLinkedList(head);
	}

	// Function to print the linked list
	static void printLinkedList(SingleLinkedList head) {
		SingleLinkedList temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Function to reverse a linked list
	// using the 3-pointer approach
	static SingleLinkedList reverseLinkedList(SingleLinkedList head) {
		// Initialize'temp' at
		// head of linked list
		SingleLinkedList temp = head;

		// Initialize pointer 'prev' to NULL,
		// representing the previous node
		SingleLinkedList prev = null;

		// Traverse the list, continue till
		// 'temp' reaches the end (NULL)
		while (temp != null) {
			// Store the next node in
			// 'front' to preserve the reference
			SingleLinkedList front = temp.next;

			// Reverse the direction of the
			// current node's 'next' pointer
			// to point to 'prev'
			temp.next = prev;

			// Move 'prev' to the current
			// node for the next iteration
			prev = temp;

			// Move 'temp' to the 'front' node
			// advancing the traversal
			temp = front;
		}

		// Return the new head of
		// the reversed linked list
		return prev;

	}

	// Function to get the Kth node from
	// a given position in the linked list
	static SingleLinkedList getKthNode(SingleLinkedList temp, int k) {
		// Decrement K as we already
		// start from the 1st node
		k -= 1;

		// Decrement K until it reaches
		// the desired position
		while (temp != null && k > 0) {
			// Decrement k as temp progresses
			k--;

			// Move to the next node
			temp = temp.next;
		}

		// Return the Kth node
		return temp;
	}

	// Function to reverse nodes in groups of K
	static SingleLinkedList kReverse(SingleLinkedList head, int k) {
		// Initialize a temporary
		// SingleLinkedList to traverse the list
		SingleLinkedList temp = head;

		// Initialize a pointer to track the
		// last SingleLinkedList of the previous group
		SingleLinkedList prevLast = null;

		// Traverse through the linked list
		while (temp != null) {

			// Get the Kth SingleLinkedList of the current group
			SingleLinkedList kThNode = getKthNode(temp, k);

			// If the Kth node is NULL
			// (not a complete group)
			if (kThNode == null) {

				// If there was a previous group,
				// link the last node to the current node
				if (prevLast != null) {
					prevLast.next = temp;
				}

				// Exit the loop
				break;
			}

			// Store the next node
			// after the Kth node
			SingleLinkedList nextNode = kThNode.next;

			// Disconnect the Kth node
			// to prepare for reversal
			kThNode.next = null;

			// Reverse the nodes from
			// temp to the Kth node
			reverseLinkedList(temp);

			// Adjust the head if the reversal
			// starts from the head
			if (temp == head) {
				head = kThNode;
			} else {
				// Link the last node of the previous
				// group to the reversed group
				prevLast.next = kThNode;
			}

			// Update the pointer to the
			// last node of the previous group
			prevLast = temp;

			// Move to the next group
			temp = nextNode;
		}

		// Return the head of the
		// modified linked list
		return head;
	}
}
