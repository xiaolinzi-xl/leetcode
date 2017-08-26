package tree;

public class PathSum112 {
	public static boolean hasPathSum(TreeNode root,int sum) {
		if (root == null) 
			return false;
		if (root.left == null && root.right == null) 
			return root.val == sum;
		if (hasPathSum(root.left, sum - root.val)) 
			return true;
		if (hasPathSum(root.right, sum - root.val))
			return true;
		return false;
	}

}