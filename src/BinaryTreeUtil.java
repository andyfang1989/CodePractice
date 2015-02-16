import java.util.HashSet;
import java.util.Stack;

public class BinaryTreeUtil {
	private static boolean isBalanced = true;
	private static TreeNode LCA = null;

	/**
	 * 
	 * @param root
	 * @return check if a binary tree is balanced
	 */
	public static boolean checkBalanced(TreeNode root) {
		isBalanced = true;
		getDepthAndCheckBalanced(root);

		return isBalanced;
	}

	private static int getDepthAndCheckBalanced(TreeNode root) {
		if (root == null)
			return 0;

		if (root.getLeft() == null && root.getRight() == null)
			return 1;

		int leftDepth = getDepthAndCheckBalanced(root.getLeft());
		int rightDepth = getDepthAndCheckBalanced(root.getRight());
		if (Math.abs(leftDepth - rightDepth) > 1)
			isBalanced = false;

		return 1 + Math.max(leftDepth, rightDepth);
	}

	/**
	 * 
	 * @param root
	 *            the root node
	 * @param first
	 *            the first node
	 * @param second
	 *            the second node
	 * @return LCA without using parent pointer
	 */
	public static TreeNode getLCAWithoutParentPointer(TreeNode root,
			TreeNode first, TreeNode second) {
		if (root == null || first == null || second == null)
			throw new IllegalArgumentException(
					"there is null tree node in input!");

		if (first == second)
			return first;

		boolean isInputValid = validateNodes(root, first, second);
		if (isInputValid) {
			LCA = null;
			getLCAWithoutParentPointerWithValidInput(root, first, second);
			return LCA;
		} else {
			System.out.println("first or second is not a child of the root!");
			return null;
		}
	}

	private static int getLCAWithoutParentPointerWithValidInput(TreeNode root,
			TreeNode first, TreeNode second) {
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return (root == first || root == second) ? 1 : 0;
		int left = getLCAWithoutParentPointerWithValidInput(root.getLeft(),
				first, second);
		if (left == 2)
			return left;
		if (left == 1 && LCA == null) {
			LCA = root;
			return left;
		}
		getLCAWithoutParentPointerWithValidInput(root.getRight(), first, second);
		return 0;
	}

	private static boolean validateNodes(TreeNode root, TreeNode first,
			TreeNode second) {
		boolean firstFound = false;
		boolean secondFound = false;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.getLeft();
			} else {
				TreeNode temp = s.pop();
				if (temp == first)
					firstFound = true;
				if (temp == second)
					secondFound = true;
				if (firstFound && secondFound)
					return true;

				root = temp.getRight();
			}
		}

		return false;
	}

	/**
	 * 
	 * @param root
	 *            the root node
	 * @param first
	 *            the first node
	 * @param second
	 *            the second node
	 * @return LCA by using parent pointer
	 */
	public static TreeNode getLCAWithParentPointer(TreeNode root,
			TreeNode first, TreeNode second) {
		if (root == null || first == null || second == null)
			throw new IllegalArgumentException(
					"there is null tree node in input!");

		if (first == second)
			return first;

		HashSet<TreeNode> path1 = new HashSet<TreeNode>();
		HashSet<TreeNode> path2 = new HashSet<TreeNode>();
		while (first != null && second != null) {
			path1.add(first);
			path2.add(second);
			if (path1.contains(second))
				return second;

			if (path2.contains(first))
				return first;

			first = first.getParent();
			second = second.getParent();
		}

		return root;
	}

	/**
	 * 
	 * @param root
	 *            the root node
	 * @param first
	 *            the first node
	 * @param second
	 *            the second node
	 * @return LCA by using parent pointer
	 */
	public static TreeNode getLCAWithParentPointerBetter(TreeNode root,
			TreeNode first, TreeNode second) {
		if (root == null || first == null || second == null)
			throw new IllegalArgumentException(
					"there is null tree node in input!");

		if (first == second)
			return first;

		TreeNode temp = first;
		int firstDepth = 0;
		while (temp != null) {
			firstDepth++;
			temp = temp.getParent();
		}

		temp = second;
		int secondDepth = 0;
		while (temp != null) {
			secondDepth++;
			temp = temp.getParent();
		}

		if (firstDepth > secondDepth) {
			int offset = firstDepth - secondDepth;
			while (offset > 0) {
				first = first.getParent();
				offset--;
			}
		} else {
			int offset = secondDepth - firstDepth;
			while (offset > 0) {
				second = second.getParent();
				offset--;
			}
		}

		while (first != second) {
			first = first.getParent();
			second = second.getParent();
		}

		return first;
	}
}
