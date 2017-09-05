/**
 * 比较两个二叉树是否相等
 * Created by xiaolinzi on 2017/9/4.
 */
public class SameTree100 {

    boolean isSameTree(TreeNode p,TreeNode q){
        if (p==null && q==null)
            return true;
        if (p!=null && q!=null && p.val == q.val)
            return isSameTree(p.left,q.left);
        return false;
    }

}

