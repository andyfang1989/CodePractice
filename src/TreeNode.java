public class TreeNode {
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	static int key = 1;
	int val;

	public TreeNode(int val) {
		key++;
		this.val = val;
	}
}
