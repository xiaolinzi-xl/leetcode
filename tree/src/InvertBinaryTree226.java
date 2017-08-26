package tree;

public class InvertBinaryTree226 {
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) 
			return null;
		invertTree(root.left);
		invertTree(root.right);
//		��������������λ��
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}
