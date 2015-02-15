import static org.junit.Assert.*;

public class TestStackQueue implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestStackQueue starts");
		TestMaxMinStack();
		TestPrintBinaryTreeByLevel();
		System.out.println("TestStackQueue ends");
	}

	private void TestMaxMinStack() {
		System.out.println("TestMaxMinStack starts");
		MaxMinStack s = new MaxMinStack();
		s.push(5);
		s.push(1);
		s.push(2);
		s.push(4);
		assertEquals(5, s.getMax());
		assertEquals(1, s.getMin());
		s.pop();
		assertEquals(5, s.getMax());
		assertEquals(1, s.getMin());
		s.push(7);
		assertEquals(7, s.getMax());
		assertEquals(1, s.getMin());
		s.pop();
		s.pop();
		s.pop();
		assertEquals(5, s.getMax());
		assertEquals(5, s.getMin());
		System.out.println("TestMaxMinStack ends");
	}

	private void TestPrintBinaryTreeByLevel() {
		System.out.println("TestPrintBinaryTreeByLevel starts");
		TreeNode root = new TreeNode(1);
		TreeNode second1 = new TreeNode(2);
		TreeNode second2 = new TreeNode(4);
		TreeNode third1 = new TreeNode(5);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(8);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setRight(third1);
		second2.setLeft(third2);
		third2.setLeft(fourth1);
		third2.setRight(fourth2);
		StackQueueUtil.printBinaryTreeByLevel(root);
		System.out.println("TestPrintBinaryTreeByLevel ends");
	}
}
