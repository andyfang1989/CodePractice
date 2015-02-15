import static org.junit.Assert.*;

public class TestBinaryTree implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestBinaryTree starts");
		TestCheckBalanced();
		TestGetLCAWithoutParentPointer();
		TestGetLCAWithParentPointer();
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
		root.setLeft(second1);
		;
		root.setRight(second2);
		second1.setRight(third1);
		second2.setLeft(third2);
		assertTrue(BinaryTreeUtil.checkBalanced(root));
		root = new TreeNode(1);
		second1 = new TreeNode(2);
		second2 = new TreeNode(4);
		third1 = new TreeNode(5);
		third2 = new TreeNode(6);
		fourth1 = new TreeNode(7);
		fourth2 = new TreeNode(8);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setLeft(third1);
		second1.setRight(third2);
		third1.setLeft(fourth1);
		third2.setRight(fourth2);
		assertFalse(BinaryTreeUtil.checkBalanced(root));
		System.out.println("TestCheckBalanced ends");
	}

	private void TestGetLCAWithoutParentPointer() {
		System.out.println("TestGetLCAWithoutParentPointer starts");
		TreeNode root = new TreeNode(0);
		TreeNode second1 = new TreeNode(2);
		TreeNode second2 = new TreeNode(4);
		TreeNode third1 = new TreeNode(5);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(8);
		TreeNode fifth = new TreeNode(9);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setLeft(third1);
		second1.setRight(third2);
		second2.setRight(fourth1);
		fourth1.setLeft(fourth2);
		assertNull(BinaryTreeUtil.getLCAWithoutParentPointer(root, second1,
				fifth));
		assertEquals(second1,
				BinaryTreeUtil.getLCAWithoutParentPointer(root, third1, third2));
		assertEquals(fourth1, BinaryTreeUtil.getLCAWithoutParentPointer(root,
				fourth1, fourth2));
		assertEquals(fourth2, BinaryTreeUtil.getLCAWithoutParentPointer(root,
				fourth2, fourth2));
		System.out.println("TestGetLCAWithoutParentPointer ends");
	}

	private void TestGetLCAWithParentPointer() {
		System.out.println("TestGetLCAWithParentPointer starts");
		TreeNode root = new TreeNode(0);
		TreeNode second1 = new TreeNode(2);
		TreeNode second2 = new TreeNode(4);
		TreeNode third1 = new TreeNode(5);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(8);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setLeft(third1);
		second1.setRight(third2);
		second2.setRight(fourth1);
		fourth1.setLeft(fourth2);
		assertEquals(root,
				BinaryTreeUtil.getLCAWithParentPointer(root, third1, fourth2));
		assertEquals(second1,
				BinaryTreeUtil.getLCAWithParentPointer(root, third1, third2));
		assertEquals(fourth1,
				BinaryTreeUtil.getLCAWithParentPointer(root, fourth1, fourth2));
		assertEquals(fourth2,
				BinaryTreeUtil.getLCAWithParentPointer(root, fourth2, fourth2));
		System.out.println("TestGetLCAWithParentPointer ends");
	}
}
