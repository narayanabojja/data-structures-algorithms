package heap;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it. Total
 * time complexity: (O(N log K)) Space complexity: O(K)
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode list : lists) {
			if (list != null) {
				minHeap.add(list);
			}
		}
		ListNode dummy = new ListNode(-1, null);
		ListNode current = dummy;
		while (!minHeap.isEmpty()) {
			ListNode temp = minHeap.poll();
			current.next = temp;
			current = current.next;
			if (temp.next != null) {
				minHeap.add(temp.next);
			}
		}
		return dummy.next;
	}

	public void printList(ListNode head) {
		ListNode custom = head;
		while (custom != null) {
			System.out.print(custom.val + " ");
			custom = custom.next;
		}
	}

	public static void main(String[] args) {
		// Create linked lists
		ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(6)));
		ListNode head2 = new ListNode(1, new ListNode(5));
		ListNode head3 = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(7))));
		ListNode head4 = new ListNode(8);
		ListNode[] lists = new ListNode[4];
		lists[0] = head1;
		lists[1] = head2;
		lists[2] = head3;
		lists[3] = head4;
		MergeKLists mergeKLists = new MergeKLists();
		ListNode head = mergeKLists.mergeKLists(lists);
		mergeKLists.printList(head);
	}
	/**
	 * The **time complexity** and **space complexity** for the provided solution
	 * are as follows:
	 * 
	 * ### **Time Complexity** - The main operation involves a priority queue
	 * (min-heap), which stores up to \(K\) elements, where \(K\) is the number of
	 * linked lists. - Insertion and removal operations on the priority queue take
	 * \(O(\log K)\) time. - Each of the \(N\) nodes (total number of nodes across
	 * all lists) is processed once, and for each node, we perform priority queue
	 * operations (either insert or remove). - **Total time complexity**: \(O(N \log
	 * K)\).
	 * 
	 * ### **Space Complexity** - The priority queue at any time can hold up to
	 * \(K\) elements (the heads of \(K\) lists initially, and subsequently the next
	 * nodes from the lists). Hence, the space required for the priority queue is
	 * \(O(K)\). - Additionally, the solution uses \(O(1)\) extra space apart from
	 * the priority queue (for variables like `current`, `dummy`, etc.). - **Total
	 * space complexity**: \(O(K)\).
	 * 
	 * Let me know if you'd like further clarification or optimizations! 😊
	 */
}
