package tests;

import static org.junit.Assert.*;
import datastructure.TreeNode;
import utils.BinaryTreeUtil;

public class TestBinaryTree implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestBinaryTree starts");
		TestCheckBalanced();
		TestGetLCAWithoutParentPointer();
		TestGetLCAWithParentPointer();
		TestGetLCAWithParentPointerBetter();
		TestCheckBST();
		TestGetFirstElementLargerThanKInBST();
		TestGetKLargestElementsInBST();
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

	private void TestGetLCAWithParentPointerBetter() {
		System.out.println("TestGetLCAWithParentPointerBetter starts");
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
		assertEquals(root, BinaryTreeUtil.getLCAWithParentPointerBetter(root,
				third1, fourth2));
		assertEquals(second1, BinaryTreeUtil.getLCAWithParentPointerBetter(
				root, third1, third2));
		assertEquals(fourth1, BinaryTreeUtil.getLCAWithParentPointerBetter(
				root, fourth1, fourth2));
		assertEquals(fourth2, BinaryTreeUtil.getLCAWithParentPointerBetter(
				root, fourth2, fourth2));
		System.out.println("TestGetLCAWithParentPointerBetter ends");
	}

	private void TestCheckBST() {
		System.out.println("TestCheckBST starts");
		TreeNode root = new TreeNode(5);
		TreeNode second1 = new TreeNode(4);
		TreeNode second2 = new TreeNode(8);
		TreeNode third1 = new TreeNode(2);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(5);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setLeft(third1);
		second1.setRight(fourth2);
		second2.setLeft(third2);
		third2.setRight(fourth1);
		assertTrue(BinaryTreeUtil.checkBST(root));
		fourth1.setLeft(new TreeNode(9));
		assertFalse(BinaryTreeUtil.checkBST(root));
		System.out.println("TestCheckBST ends");
	}
	
	private void TestGetFirstElementLargerThanKInBST() {
		System.out.println("TestGetFirstElementLargerThanKInBST starts");
		TreeNode root = new TreeNode(5);
		TreeNode second1 = new TreeNode(4);
		TreeNode second2 = new TreeNode(8);
		TreeNode third1 = new TreeNode(2);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(5);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setLeft(third1);
		second1.setRight(fourth2);
		second2.setLeft(third2);
		third2.setRight(fourth1);
		assertTrue(BinaryTreeUtil.getFirstElementLargerThanKInBST(root, 4) == 5);
		assertTrue(BinaryTreeUtil.getFirstElementLargerThanKInBST(root, 6) == 7);
		System.out.println("TestGetFirstElementLargerThanKInBST ends");
	}
	
	private void TestGetKLargestElementsInBST() {
		System.out.println("TestGetKLargestElementsInBST starts");
		TreeNode root = new TreeNode(5);
		TreeNode second1 = new TreeNode(4);
		TreeNode second2 = new TreeNode(8);
		TreeNode third1 = new TreeNode(2);
		TreeNode third2 = new TreeNode(6);
		TreeNode fourth1 = new TreeNode(7);
		TreeNode fourth2 = new TreeNode(5);
		root.setLeft(second1);
		root.setRight(second2);
		second1.setLeft(third1);
		second1.setRight(fourth2);
		second2.setLeft(third2);
		third2.setRight(fourth1);
		int[] result = BinaryTreeUtil.getKLargestElementsInBST(root, 2);
		assertEquals(result[0], 8);
		assertEquals(result[1], 7);
		System.out.println("TestGetKLargestElementsInBST ends");
	}
}
