package singly;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * 
 */
public class CopyListRandomPointer {

	Map<SingleLinkedList, SingleLinkedList> mp = new HashMap<>();

	public SingleLinkedList copyRandomList(SingleLinkedList head) {
		if (head == null) {
			return null;
		}
		if (mp.containsKey(head)) {
			return mp.get(head);
		}
		SingleLinkedList temp = new SingleLinkedList(head.data);
		mp.put(head, temp);
		temp.next = copyRandomList(head.next);
		temp.random = copyRandomList(head.random);
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
