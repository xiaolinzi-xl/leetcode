/**
 * n*m的棋盘，从左下到右上,问有多少种走法
 * 走楼梯：f(n) = f(n-1) + f(n-2)
 * 递归主要为了看待问题，拆解问题
 * 
 * @author xiaolinzi
 *
 */
public class Xiaobing {
	
	public static int f(int n,int m) {
		if (n==1 || m==1) 
			return 1;
		return f(n-1,m) + f(n, m-1);  // 走一步
//		走两步：f(n-1,m)+f(n,m-1)+f(n-2,m)+f(n,m-2)  判定n==0||m==0
	}
	
//	dp[n,m] = dp[n-1][m]+dp[n][m-1]
//			= 1 n=1 || m=1
	
	public static int f2(int n,int m) {
		int[][] dp = new int[n+1][m+1];
		for(int i=1;i<=n;++i)
			dp[i][1] = 1;
		for(int i=1;i<=m;++i)
			dp[1][i] = 1;
		for(int i=2;i<=n;++i){
			for(int j=2;j<=m;++j){
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) {
	//	System.out.println("re---" + f(100, 100)); 时间太长了
		System.out.println("dp---" + f2(100, 100));
	}
}
