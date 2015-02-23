package datastructure;

public class ListNode {
	private ListNode next;
	private ListNode pre;
	private int val;
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ListNode getPre() {
		return pre;
	}

	public void setPre(ListNode pre) {
		this.pre = pre;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode(int val) {
		this.val = val;
	}
}
