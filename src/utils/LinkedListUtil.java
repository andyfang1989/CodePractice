package utils;
import datastructure.ListNode;

public class LinkedListUtil {
	/**
	 * 
	 * @param first
	 *            an ascending linked list
	 * @param second
	 *            an ascending linked list
	 * @return a merged ascending linked list
	 */
	public static ListNode mergeAscendingSinglyLinkedList(ListNode first,
			ListNode second) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (first != null || second != null) {
			if (first != null && second != null) {
				if (first.getVal() < second.getVal()) {
					cur.setNext(first);
					first = first.getNext();
				} else {
					cur.setNext(second);
					second = second.getNext();
				}
				cur = cur.getNext();
			} else if (first != null) {
				cur.setNext(first);
				break;
			} else {
				cur.setNext(second);
				break;
			}
		}

		ListNode result = dummy.getNext();
		dummy.setNext(null);
		return result;
	}

	/**
	 * 
	 * @param list
	 *            a linked list
	 * @return a reversed linked list, please note that the input linked list
	 *         will be changed.
	 */
	public static ListNode reverseSinglyLinkedList(ListNode list) {
		if (list == null || list.getNext() == null)
			return list;

		ListNode pre = list;
		ListNode cur = list.getNext();
		while (cur != null) {
			ListNode temp = cur.getNext();
			cur.setNext(pre);
			pre = cur;
			cur = temp;
		}

		list.setNext(null);
		return pre;
	}

	/**
	 * 
	 * @param list
	 *            a linked list
	 * @return null if there is no cycle, or the starting node of the cycle.
	 */
	public static ListNode checkCycle(ListNode list) {
		if (list == null || list.getNext() == null)
			return null;

		ListNode fast = list;
		ListNode slow = list;
		while (fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				ListNode head = list;
				while (head != slow) {
					head = head.getNext() ;
					slow = slow.getNext() ;
				}

				return head;
			}

			if (fast == null)
				return null;
		}

		return null;
	}
}
