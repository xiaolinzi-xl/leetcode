import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xiaolinzi on 2017/8/28.
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 *
 * 思路：深度优先搜索：对于每个数字只有两种决策，选或者不选，将选择的数字保存在list里面，方便输出。
 * 边界条件为当遍历到n+1时，就终止递归。题目默认优先选择数字。
 */
public class Qiuhe {
    public static void search(int n,int m,int idx,int sum,List<Integer> list){
        if(sum == m){
            int len = list.size();
            for(int i=0;i<len-1;i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(len-1));
            return ;
        }
        if(idx > n)
            return ;

        list.add(idx);
        search(n,m,idx+1,sum+idx,list); // 取
        list.remove(Integer.valueOf(idx));

        search(n,m,idx+1,sum,list); // 不取
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        search(n,m,1,0,list);
    }
}
