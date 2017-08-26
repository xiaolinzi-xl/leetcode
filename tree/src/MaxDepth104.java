package tree;

public class MaxDepth104 {
	public static int maxDepth(TreeNode root) {
		if (root == null) 
			return 0;
		int leftMaxDepth = maxDepth(root.left);
		int rightMaxDepth = maxDepth(root.right);
		return Math.max(leftMaxDepth, rightMaxDepth) + 1;
	}
	
}


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}

