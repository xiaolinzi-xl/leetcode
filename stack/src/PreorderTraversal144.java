package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 二叉树的先序遍历
 */
public class PreorderTraversal144 {
	public static void preorder(TreeNode head) {
		if (head != null) {
			System.out.print(head.val + " ");
			preorder(head.left);
			preorder(head.right);
		}
	}
	
	// 非递归先序遍历算法
	public static int[] preorderTraversal(TreeNode root) {
		ArrayList<Integer> resList = new ArrayList<>();
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur != null) {
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
				resList.add(cur.val);
			}
		}
		int[] res = new int[resList.size()];
		for(int i=0;i<res.length;i++)
			res[i] = resList.get(i);
		return res;
	}
	
	public static int[] preorderTraversal2(TreeNode root) {
		ArrayList<Integer> resList = new ArrayList<>();
		if (root == null) {
			return null;
		}
		Stack<Command> stack = new Stack<>();
		stack.push(new Command("go", root));
		while (!stack.isEmpty()) {
			Command cur = stack.pop();
			if (cur.string == "print") {
				resList.add(cur.node.val);
			}else {
				if (cur.node.right != null) {
					stack.push(new Command("go", cur.node.right));
				}
				if (cur.node.left != null) {
					stack.push(new Command("go", cur.node.left));
				}
				stack.push(new Command("print", cur.node));
			}
		}
		int[] res = new int[resList.size()];
		for(int i=0;i<res.length;i++)
			res[i] = resList.get(i);
		return res;
	}
	
	public static int[] inorderTraversal(TreeNode root) {
		ArrayList<Integer> resList = new ArrayList<>();
		if (root == null) {
			return null;
		}
		Stack<Command> stack = new Stack<>();
		stack.push(new Command("go", root));
		while (!stack.isEmpty()) {
			Command cur = stack.pop();
			if (cur.string == "print") {
				resList.add(cur.node.val);
			}else {
				if (cur.node.right != null) {
					stack.push(new Command("go", cur.node.right));
				}
				stack.push(new Command("print", cur.node));
				if (cur.node.left != null) {
					stack.push(new Command("go", cur.node.left));
				}
			}
		}
		int[] res = new int[resList.size()];
		for(int i=0;i<res.length;i++)
			res[i] = resList.get(i);
		return res;
	}
	
	public static int[] postorderTraversal(TreeNode root) {
		ArrayList<Integer> resList = new ArrayList<>();
		if (root == null) {
			return null;
		}
		Stack<Command> stack = new Stack<>();
		stack.push(new Command("go", root));
		while (!stack.isEmpty()) {
			Command cur = stack.pop();
			if (cur.string == "print") {
				resList.add(cur.node.val);
			}else {
				stack.push(new Command("print", cur.node));
				if (cur.node.right != null) {
					stack.push(new Command("go", cur.node.right));
				}
				if (cur.node.left != null) {
					stack.push(new Command("go", cur.node.left));
				}
			}
		}
		int[] res = new int[resList.size()];
		for(int i=0;i<res.length;i++)
			res[i] = resList.get(i);
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		int[] arr = preorderTraversal2(root);
		preorder(root);
		System.out.println();
		System.out.println(Arrays.toString(arr));
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

class Command{
	String string;
	TreeNode node;
	public Command(String string,TreeNode node) {
		this.node = node;
		this.string = string;
	}
}
