/**
 * 是否是一个映射树，镜面对称
 * Created by xiaolinzi on 2017/9/4.
 */
public class SymettricTree {

    public boolean fun(TreeNode p,TreeNode q){
        if(p == null && q == null)
            return true;
        if(p!=null && q!=null && p.val == q.val){
            return fun(p.left,q.right) && fun(p.right,q.left);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return fun(root.left,root.right);
    }
}
