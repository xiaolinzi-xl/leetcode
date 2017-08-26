/**
 * 最长公共子序列
 * x[n],y[m]
 * 
 * @author xiaolinzi
 *
 */
public class LIS {

	public static  int search(String x,String y,int idx,int idy) {
		if (idx >= x.length() || idy>=y.length()) 
			return 0;
		if (x.charAt(idx) == y.charAt(idy)) 
			return search(x, y, idx+1, idy+1) + 1;
		return Math.max(search(x, y, idx, idy+1), search(x, y, idx+1, idy));
	}
	
//	dp[i][j] = max(dp[i-1][j],dp[i][j-1])
//    = 1 + dp[i-1][j-1]	
	public static int lis(String x,String y) {
		int[][] dp = new int[x.length()+1][y.length()+1];
		for(int i=1;i<=x.length();i++){
			for(int j=1;j<=y.length();j++){
				if (x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[x.length()][y.length()];
	}
	
	public static void main(String[] args) {
		String xString = "ABCBDABC";
		String yString = "BDCABAC";
		System.out.println(search(xString, yString, 0, 0));
		System.out.println(lis(xString, yString));
	}
	
}
