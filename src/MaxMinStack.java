import java.util.Stack;

public class MaxMinStack {
	Stack<Integer> actualStack;
	Stack<Integer> max;
	Stack<Integer> min;

	public MaxMinStack() {
		actualStack = new Stack<Integer>();
		max = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int val) {
		actualStack.push(val);
		if (max.isEmpty() || val >= max.peek()) {
			max.push(val);
		}

		if (min.isEmpty() || val <= min.peek()) {
			min.push(val);
		}
	}

	public int pop() {
		if (!max.isEmpty() && actualStack.peek() == max.peek()) {
			max.pop();
		}

		if (!min.isEmpty() && actualStack.peek() == min.peek()) {
			min.pop();
		}

		return actualStack.pop();
	}

	public int getMax() {
		return max.peek();
	}

	public int getMin() {
		return min.peek();
	}

	public int size() {
		return actualStack.size();
	}
}
