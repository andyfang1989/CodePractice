package datastructure;

import java.util.HashMap;

public class LRUCache {
	private ListNode least;
	private ListNode latest;
	private int capacity;
	private int size;
	private HashMap<String, ListNode> map;

	public LRUCache(int capacity) {
		this.map = new HashMap<String, ListNode>();
		this.capacity = capacity;
		this.size = 0;
	}

	public void add(String key, int price) {
		if (size < capacity) {
			if (map.containsKey(key)) {
				moveToLatest(key);
			} else {
				addToLatest(key, price);
			}
		} else {
			if (map.containsKey(key)) {
				moveToLatest(key);
			} else {
				removeLeast();
				addToLatest(key, price);
			}
		}
	}

	public int getPrice(String key) {
		if (map.containsKey(key)) {
			moveToLatest(key);
			return map.get(key).getVal();
		} else {
			System.out.println("The item with key: " + key
					+ " is not in the LRUCache.");
			return -1;
		}
	}

	private void moveToLatest(String key) {
		ListNode node = map.get(key);
		if (node != latest) {
			ListNode pre = node.getPre();
			ListNode next = node.getNext();
			pre.setNext(next);
			if (next != null)
				next.setPre(pre);
			node.setNext(latest);
			node.setPre(null);
			latest.setPre(node);
			latest = node;
			if (next == null)
				least = pre;
		}
	}

	private void addToLatest(String key, int val) {
		ListNode newNode = new ListNode(val);
		newNode.setKey(key);
		if (size == 0) {
			latest = newNode;
			least = newNode;
		} else {
			newNode.setNext(latest);
			latest.setPre(newNode);
			latest = newNode;
		}

		map.put(key, newNode);
		size++;
	}

	private void removeLeast() {
		if (size == 1) {
			map.remove(least.getKey());
			latest = null;
			least = null;
		} else {
			ListNode temp = least.getPre();
			temp.setNext(null);
			map.remove(least.getKey());
			least = temp;
		}

		size--;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printCache() {
		System.out.println("size is " + size + " capacity is " + capacity);
		ListNode temp = latest;
		while (temp != null) {
			System.out.println("key is: " + temp.getKey() + " price is: "
					+ temp.getVal());
			temp = temp.getNext();
		}
		System.out.println("print done");
	}
}
