import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
	private ArrayList<T> heap;

	public MaxHeap() {
		this.heap = new ArrayList<T>();
	}

	public T peek() {
		if (heap.size() == 0)
			return null;
		else
			return heap.get(0);
	}

	public void push(T t) {
		heap.add(t);
		shiftUp();
	}

	public T pop() {
		if (heap.size() == 0)
			return null;
		if (heap.size() == 1) {
			T temp = heap.get(0);
			heap.remove(0);
			return temp;
		} else {
			T temp = heap.get(0);
			heap.set(0, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);
			shiftDown();
			return temp;
		}
	}

	public boolean isEmpty() {
		return heap.size() == 0;
	}

	private void shiftUp() {
		int index = heap.size() - 1;
		while (index > 0) {
			int p = (index - 1) / 2;
			if (p >= 0 && heap.get(p).compareTo(heap.get(index)) < 0) {
				swap(p, index);
				index = p;
			} else {
				break;
			}
		}
	}

	private void shiftDown() {
		int p = 0;
		int l = 1;
		while (l <= heap.size() - 1) {
			int r = l + 1;
			int max = l;
			if (r <= heap.size() - 1 && heap.get(l).compareTo(heap.get(r)) < 0) {
				max = r;
			}

			if (heap.get(p).compareTo(heap.get(max)) < 0) {
				swap(p, max);
				p = max;
				l = 2 * p + 1;
			} else {
				break;
			}
		}
	}

	private void swap(int i, int j) {
		T temp = heap.get(j);
		heap.set(j, heap.get(i));
		heap.set(i, temp);
	}
}
