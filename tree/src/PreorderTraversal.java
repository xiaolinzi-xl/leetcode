import java.util.*;

/**
 * 先序遍历
 * Created by xiaolinzi on 2017/9/4.
 */
public class PreorderTraversal {
    ArrayList<Integer> ans = new ArrayList<>();

    public void previsit(TreeNode p){
        if(p == null)
            return ;
        ans.add(p.val);
        previsit(p.left);
        previsit(p.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return ans;
        previsit(root);
        return ans;
    }

//    递归版
    public void preorder(TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

//    非递归版
    public void preorder2(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);

        while (!queue.isEmpty()){
            root = queue.removeFirst();
            if (root != null){
                System.out.println(root.val);
                queue.addLast(root.right);
                queue.addLast(root.left);
            }
        }

    }

    public static void main(String[] args){

    }
}
