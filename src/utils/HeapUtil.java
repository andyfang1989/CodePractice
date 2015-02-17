package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import datastructure.ComparablePair;
import datastructure.MaxHeap;
import datastructure.MinHeap;

public class HeapUtil {
	/**
	 * 
	 * @param lists
	 *            a list of list of comparable items with ascending order
	 * @return a list of merged items with ascending order
	 */
	public static <T extends Comparable<T>> List<T> sortKSortedLists(
			List<List<T>> lists) {
		MinHeap<ComparablePair<T, Integer>> heap = new MinHeap<ComparablePair<T, Integer>>();
		List<T> result = new ArrayList<T>();
		HashMap<Integer, Integer> indexTracker = new HashMap<Integer, Integer>();
		// check and remove empty list
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).size() == 0)
				lists.remove(i);
		}

		for (int i = 0; i < lists.size(); i++) {
			heap.push(new ComparablePair<T, Integer>(lists.get(i).get(0), i));
			indexTracker.put(i, 0);
		}

		while (!heap.isEmpty()) {
			ComparablePair<T, Integer> cur = heap.pop();
			result.add(cur.getT());
			int listNum = cur.getE();
			List<T> list = lists.get(listNum);
			int nextIndex = indexTracker.get(listNum) + 1;
			if (nextIndex < list.size()) {
				heap.push(new ComparablePair<T, Integer>(list.get(nextIndex),
						listNum));
				indexTracker.put(listNum, nextIndex);
			}
		}

		return result;
	}

	public static <T extends Comparable<T>> List<T> getKSmallestItems(
			List<T> list, int k) {
		if (list.size() < k)
			throw new IllegalArgumentException(
					"the size of the list should be larger than k");
		if (list.size() == k)
			return new ArrayList<T>(list);

		List<T> result = new ArrayList<T>();
		MaxHeap<T> heap = new MaxHeap<T>();
		int i = 0;
		for (i = 0; i < k; i++) {
			heap.push(list.get(i));
		}

		while (i < list.size()) {
			if (list.get(i).compareTo(heap.peek()) < 0) {
				heap.pop();
				heap.push(list.get(i));
			}

			i++;
		}

		while (!heap.isEmpty()) {
			result.add(heap.pop());
		}

		return result;
	}
}
