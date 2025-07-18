package singly;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 */
public class OddEvenList {

	public static void main(String[] args) {

		SingleLinkedList list1 = new SingleLinkedList(2);
		list1.next = new SingleLinkedList(4);
		list1.next.next = new SingleLinkedList(3);
		list1.next.next.next = new SingleLinkedList(5);
		list1.next.next.next.next = new SingleLinkedList(6);
		list1.next.next.next.next.next = new SingleLinkedList(4);

		SingleLinkedList newNode = oddEvenList(list1);
		SinglyLinkedListOps.printlist(newNode);

	}

	public static SingleLinkedList oddEvenList(SingleLinkedList head) {
		if (head == null) {
			return null;
		}
		SingleLinkedList odd = head;
		SingleLinkedList even = head.next;
		SingleLinkedList evenFirst = even;
		while (true) {
			if (even == null || even.next == null) {
				odd.next = evenFirst;
				break;
			}
			odd.next = even.next;
			odd = even.next;
			if (odd.next == null) {
				odd.next = evenFirst;
				even.next = null;
				break;
			}
			even.next = odd.next;
			even = odd.next;
		}
		return head;
	}
}
