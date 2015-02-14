import java.util.LinkedList;

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
				System.out.print(temp.val + " ");
				if (temp.left != null) {
					q.offer(temp.left);
				}

				if (temp.right != null) {
					q.offer(temp.right);
				}

				size--;
			}

			System.out.println();
		}
	}
}
