/**
 * 给你先序和中序遍历的结果，构造一棵树---leetcode 105
 * Created by xiaolinzi on 2017/9/4.
 */
public class ConstructTree {
    int[] pre;
    int[] in;

    public TreeNode build(int st1,int ed1,int st2,int ed2){
        if(st1 > ed1){
            return null;
        }
        TreeNode r = new TreeNode(pre[st1]);
        int find = -1;
        for(int i=st2;i<=ed2;i++){
            if(in[i] == r.val){
                find = i;
                break;
            }
        }
        // in st2 --- find-1 find+1 ed2
//         pre  c= find-st2 [st1+1,st1+c] [st1+c+1,ed1]
        if(find == -1)
            return null;
        int c = find - st2;
        r.left = build(st1+1,st1+c,st2,find-1);
        r.right = build(st1+c+1,ed1,find+1,ed2);

        return r;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;

        TreeNode r = build(0,pre.length-1,0,in.length-1);
        return r;
    }
}
