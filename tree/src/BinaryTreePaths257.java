package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
			return ans;
		}
        if (root.left == null && root.right == null) {
			ans.add(root.val + "");
			return ans;
		}
        List<String> leftAns = binaryTreePaths(root.left);
        for(int i=0;i<leftAns.size();i++) {
        	ans.add(root.val + "->" + leftAns.get(i));
        }
        List<String> rightAns = binaryTreePaths(root.right);
        for(int i=0;i<rightAns.size();i++) {
        	ans.add(root.val + "->" + rightAns.get(i));
        }
        return ans;
    }
}
