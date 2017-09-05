import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderTraversal102 {
	public static int[][] levelOrder(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
		LinkedList<LevelNode> q = new LinkedList<>();
		q.add(new LevelNode(root, 0));
		while (!q.isEmpty()) {
			LevelNode levelNode = q.removeFirst();
			TreeNode node = levelNode.node;
			int level = levelNode.level;
			if (level == ansList.size()) {
				ansList.add(new ArrayList<>());
			}
			ansList.get(level).add(node.val);
			if (node.left != null) {
				q.add(new LevelNode(node.left, level+1));
			}
			if (node.right != null) {
				q.add(new LevelNode(node.right, level+1));
			}
		}
		return null;
	}
}

class LevelNode{
	TreeNode node;
	int level;
	
	public LevelNode(TreeNode node,int level) {
		this.level = level;
		this.node = node;
	}
}
