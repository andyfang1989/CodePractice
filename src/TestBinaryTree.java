import static org.junit.Assert.*;

public class TestBinaryTree implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestBinaryTree starts");
		TestCheckBalanced();
		System.out.println("TestBinaryTree ends");
	}

	private void TestCheckBalanced() {
		System.out.println("TestCheckBalanced starts");
		TreeNode root = new TreeNode(1);
		TreeNode second1 = new TreeNode(2);
		TreeNode second2 = new TreeNode(4);
		TreeNode third1 = new TreeNode(5);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(8);
		root.left = second1;
		root.right = second2;
		second1.right = third1;
		second2.left = third2;
		assertTrue(BinaryTreeUtil.checkBalanced(root));
		root = new TreeNode(1);
		second1 = new TreeNode(2);
		second2 = new TreeNode(4);
		third1 = new TreeNode(5);
		third2 = new TreeNode(6);
		fourth1 = new TreeNode(7);
		fourth2 = new TreeNode(8);
		root.left = second1;
		root.right = second2;
		second1.left = third1;
		second1.right = third2;
		third1.left = fourth1;
		third2.right = fourth2;
		assertFalse(BinaryTreeUtil.checkBalanced(root));
		System.out.println("TestCheckBalanced ends");
	}
}
