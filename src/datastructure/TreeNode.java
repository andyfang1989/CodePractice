package datastructure;
public class TreeNode {
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	private static int key = 1;
	private int val;

	public TreeNode(int val) {
		key++;
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
		left.setParent(this);
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
		right.setParent(this);
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
