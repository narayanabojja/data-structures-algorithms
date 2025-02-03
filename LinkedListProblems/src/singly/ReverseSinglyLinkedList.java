package singly;

/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseSinglyLinkedList {
	/**
	 * time complexity: O(n) Space complexity : O(1)
	 * 
	 */
	public SingleLinkedList reverseSinglyLinkedList(SingleLinkedList head) {
		if (head == null || head.next == null) {
			return head;
		}
		SingleLinkedList current = head;
		SingleLinkedList previous = null;
		while (current != null) {
			SingleLinkedList temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		head = previous;
		return head;
	}

	/**
	 * time complexity: O(n) Space complexity : O(n)
	 * 
	 */
	public SingleLinkedList reverseListRecursively(SingleLinkedList head) {
		// Base case: if the list is empty or has only one node, return it
		if (head == null || head.next == null) {
			return head;
		}
		// Reverse the sublist starting from the second node recursively
		SingleLinkedList reversedList = reverseListRecursively(head.next);
		// Reverse the pointers: make the next node point to the current node
		head.next.next = head;
		head.next = null;
		// Return the new head of the reversed list
		return reversedList;
	}

	public static void main(String[] args) {
		SingleLinkedList head = new SingleLinkedList(1);
		head.next = new SingleLinkedList(2);
		///head.next.next = new SingleLinkedList(3);
		//head.next.next.next = new SingleLinkedList(4);
		//head.next.next.next.next = new SingleLinkedList(5);
		var reverseSinglyLinkedList = new ReverseSinglyLinkedList();
//		head = reverseSinglyLinkedList.reverseSinglyLinkedList(head);
//		SinglyLinkedListOps.printlist(head);
		//head = reverseSinglyLinkedList.reverseListRecursively(head);
		//SinglyLinkedListOps.printlist(head);
		head = reverseBetween(head, 1, 2);
		SinglyLinkedListOps.printlist(head);
	}
	   public static SingleLinkedList reverseBetween(SingleLinkedList head, int left, int right) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        SingleLinkedList leftNode = null;
	        SingleLinkedList leftNodePrev = null;
	        SingleLinkedList rightNodePrev = null;
	        SingleLinkedList temp = head;
	        SingleLinkedList prevNode = null;
	        int pos = 1;
	        while(pos != right) {
	            if(temp.data == left) {
	                leftNodePrev = prevNode;
	                leftNode = temp;
	            }
	            prevNode = temp;
	            temp = temp.next;
	            pos++;
	        }
            if(pos == right) {
                rightNodePrev = temp.next;
            }
	        SingleLinkedList prev = rightNodePrev;
	        SingleLinkedList current = leftNode;
	        pos = 1;
	        while(pos != right) {
	            SingleLinkedList temp1 = current.next;
	            current.next = prev;
	            prev = current;
	            current = temp1;
	            pos++;
	        }
	        current.next = prev;
	        if(leftNodePrev !=null) {
		        leftNodePrev.next = current;
		        return head;
	        }

	        return current;
	    }
}
