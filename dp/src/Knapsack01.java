/**
 * 01背包问题
 * @author xiaolinzi
 *
 */
public class Knapsack01 {
	
	public static int search(int idx,int S,int[] w,int[] v,int W){
		if (idx>=w.length || S+w[idx] > W) 
			return 0;
		return Math.max(search(idx+1, S, w, v, W), search(idx+1, S+w[idx], w, v, W)+v[idx]);
	}
	
	// f[i][j] = max(f[i-1][j-w[i]]+v[i],f[i-1][j])
	public static int knaspack(int[] w,int[] v,int W) {
		int[][] dp = new int[w.length+1][W+1];
		for(int i=1;i<=w.length;++i){
			for(int j=1;j<=W;++j){
				dp[i][j] = dp[i-1][j];
				if (j-w[i-1]>=0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i-1]]+v[i-1]);
				}
			}
		}
		return dp[w.length][W];
	}
	
//	带滚动数组
	public static int knaspack2(int[] w,int[] v,int W) {
		int[] dp = new int[W+1];
		for(int i=1;i<=w.length;++i){
			for(int j=W;j>=w[i-1];--j){
				dp[j] = Math.max(dp[j], dp[j-w[i-1]]+v[i-1]);
			}
		}
		return dp[W];
	}
	
	public static void main(String[] args) {
		int[] w = {2,3,4,5,6};
		int[] v = {2,3,4,5,6};
		int W = 14;
		System.out.println("res----" + search(0, 0, w, v, W));
		System.out.println("dp----" + knaspack(w, v, W));
		System.out.println("gundong----" + knaspack2(w, v, W));
	}
}
