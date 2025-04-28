package singly;

/**
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form:
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the
 * list's nodes. Only nodes themselves may be changed.
 * 
 * - Time Complexity:- Finding the middle takes (O(n)). - Reversing the second
 * half also takes (O(n)). - Merging the two halves is (O(n)). Overall time
 * complexity is (O(n)).
 * 
 * - Space Complexity:- The solution modifies the list in place without using
 * any auxiliary data structures. Hence, the space complexity is (O(1)).
 * 
 * 
 * 
 * 
 */
public class ReOrderList {

	public static void main(String[] args) {

		SingleLinkedList head = new SingleLinkedList(1);
		head.next = new SingleLinkedList(2);
		head.next.next = new SingleLinkedList(3);
		head.next.next.next = new SingleLinkedList(4);
		reorderList(head);
		printList(head);
	}

	public static void reorderList(SingleLinkedList head) {
		if (head == null || head.next == null) {
			return;
		}

		// Step 1: Find the middle of the linked list
		SingleLinkedList slow = head;
		SingleLinkedList fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half of the linked list
		SingleLinkedList prev = null;
		SingleLinkedList curr = slow.next;
		slow.next = null; // break the list into two halves
		while (curr != null) {
			SingleLinkedList nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}

		// Step 3: Merge the two halves
		SingleLinkedList first = head;
		SingleLinkedList second = prev;
		while (second != null) {
			SingleLinkedList temp1 = first.next;
			SingleLinkedList temp2 = second.next;

			first.next = second;
			second.next = temp1;

			first = temp1;
			second = temp2;
		}
	}

	static void printList(SingleLinkedList head) {
		SingleLinkedList current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}
