import java.util.Scanner;

/**
 * Created by xiaolinzi on 2017/8/28.
 */
public class PinCouMianE {
    public static int[] coins = {1,5,10,20,50,100};

    public static int search(int n,int idx){
        if(n == 0)
            return 1;
        if(idx >= coins.length || n < 0)
            return 0;

        return search(n,idx+1) + search(n-coins[idx],idx);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(search(n,0));
    }
}
