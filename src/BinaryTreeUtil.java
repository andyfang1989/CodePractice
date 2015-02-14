public class BinaryTreeUtil {
	static boolean isBalanced = true;

	public static boolean checkBalanced(TreeNode root) {
		isBalanced = true;
		getDepthAndCheckBalanced(root);

		return isBalanced;
	}

	private static int getDepthAndCheckBalanced(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		int leftDepth = getDepthAndCheckBalanced(root.left);
		int rightDepth = getDepthAndCheckBalanced(root.right);
		if (Math.abs(leftDepth - rightDepth) > 1)
			isBalanced = false;

		return 1 + Math.max(leftDepth, rightDepth);
	}
}
