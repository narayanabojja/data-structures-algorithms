package singly;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * https://leetcode.com/problems/add-two-numbers/description/ Time complexity :
 * O(max(n, m)) Space complexity is O(max(n, m))
 */
public class AddTwoNumbers {

	public static SingleLinkedList addTwoList(SingleLinkedList list1, SingleLinkedList list2) {
		SingleLinkedList dummyHead = new SingleLinkedList(0);
		SingleLinkedList tail = dummyHead;
		int carry = 0;
		while (list1 != null || list2 != null || carry != 0) {
			int digit1 = list1 != null ? list1.data : 0;
			int digit2 = list2 != null ? list2.data : 0;
			int sum = digit1 + digit2 + carry;
			int digit = sum % 10;
			carry = sum / 10;
			SingleLinkedList newNode = new SingleLinkedList(digit);
			tail.next = newNode;
			tail = tail.next;
			list1 = list1 != null ? list1.next : null;
			list2 = list2 != null ? list2.next : null;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList(2);
		list1.next = new SingleLinkedList(4);
		list1.next.next = new SingleLinkedList(3);
		SingleLinkedList list2 = new SingleLinkedList(5);
		list2.next = new SingleLinkedList(6);
		list2.next.next = new SingleLinkedList(4);
		SingleLinkedList newNode = addTwoList(list1, list2);
		SinglyLinkedListOps.printlist(newNode);
	}

}
