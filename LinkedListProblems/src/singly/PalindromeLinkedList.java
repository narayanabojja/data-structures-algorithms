package singly;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise. 
 * 
 */
public class PalindromeLinkedList {
	/**
	 * Time Complexity : O(n) Space Complexity: O(1)
	 */
	public static boolean isPalindrome(SingleLinkedList head) {
		SingleLinkedList slow = head;
		SingleLinkedList fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		SingleLinkedList temp = reverse(slow);
		SingleLinkedList temp1 = head;
		while (temp != null) {
			if (temp1.data != temp.data) {
				return false;
			}
			temp = temp.next;
			temp1 = temp1.next;
		}
		return true;
	}

	public static SingleLinkedList reverse(SingleLinkedList head) {
		SingleLinkedList current = head;
		SingleLinkedList prev = null;
		while (current != null) {
			SingleLinkedList temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList(1);
		list.next = new SingleLinkedList(2);
		list.next.next = new SingleLinkedList(2);
		list.next.next.next = new SingleLinkedList(1);
		System.out.println(isPalindrome(list));
	}

}
