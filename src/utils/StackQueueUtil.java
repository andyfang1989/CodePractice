package utils;
import java.util.LinkedList;

import datastructure.TreeNode;

public class StackQueueUtil {
	/**
	 * print a binary tree by its level from the root to bottom
	 * 
	 * @param root
	 */
	public static void printBinaryTreeByLevel(TreeNode root) {
		if (root == null)
			return;

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				TreeNode temp = q.poll();
				System.out.print(temp.getVal() + " ");
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}

				if (temp.getRight() != null) {
					q.offer(temp.getRight());
				}

				size--;
			}

			System.out.println();
		}
	}
}
