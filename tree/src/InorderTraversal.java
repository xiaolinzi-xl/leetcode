import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 * Created by xiaolinzi on 2017/9/4.
 */
public class InorderTraversal {
    ArrayList<Integer> ans = new ArrayList<>();

    public void invisit(TreeNode p){
        if(p == null)
            return ;
        invisit(p.left);
        ans.add(p.val);
        invisit(p.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return ans;
        invisit(root);
        return ans;
    }

//    非递归版中序遍历
    public void inorder2(TreeNode root){

    }

}
