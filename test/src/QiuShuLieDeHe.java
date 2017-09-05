import java.util.Scanner;

/**
 * Created by xiaolinzi on 2017/8/28.
 */
public class QiuShuLieDeHe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            double ans = n;
            double tmp = n;
            for(int i=2;i<=m;i++){
                tmp = Math.sqrt(tmp);
                ans += tmp;
//                System.out.println(tmp);
            }
            System.out.printf("%.2f\n",ans);
        }
    }
}
