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
				if (first.val < second.val) {
					cur.next = first;
					first = first.next;
				} else {
					cur.next = second;
					second = second.next;
				}
				cur = cur.next;
			} else if (first != null) {
				cur.next = first;
				break;
			} else {
				cur.next = second;
				break;
			}
		}

		ListNode result = dummy.next;
		dummy.next = null;
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
		if (list == null || list.next == null)
			return list;

		ListNode pre = list;
		ListNode cur = list.next;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}

		list.next = null;
		return pre;
	}

	/**
	 * 
	 * @param list
	 *            a linked list
	 * @return null if there is no cycle, or the starting node of the cycle.
	 */
	public static ListNode checkCycle(ListNode list) {
		if (list == null || list.next == null)
			return null;

		ListNode fast = list;
		ListNode slow = list;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode head = list;
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}

				return head;
			}

			if (fast == null)
				return null;
		}

		return null;
	}
}
