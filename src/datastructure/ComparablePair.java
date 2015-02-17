package datastructure;
public class ComparablePair<T extends Comparable<T>, E> implements Comparable<ComparablePair<T, E>> {
	private T t;
	private E e;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

	public ComparablePair(T t, E e) {
		this.t = t;
		this.e = e;
	}

	@Override
	public int compareTo(ComparablePair<T, E> o) {
		if (t.compareTo(o.getT()) < 0)
			return -1;
		else if (t.compareTo(o.getT()) > 0)
			return 1;
		else
			return 0;
	}
}