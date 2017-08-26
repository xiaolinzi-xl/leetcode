public class PalindromePartition2 {
	 public static int minCut(String s) {
		 if (s == null || s.length() == 0) {
			return 0;
		 }
		 int len = s.length();
//		 dp[i] = min(dp[j]+1) 0<=j<i p[i][j] = true
		 int[] dp = new int[len+1];
		 for(int i=0;i<len+1;i++)
			 dp[i] = i - 1;
//		 mat[i][j] = s[i] == s[j] && mat[i+1][j-1] 
		 boolean[][] mat = new boolean[len][len];
		 for(int i=len-1;i>=0;i--){
			 for(int j=i;j<len;j++){
				 if (j == i) {
					mat[i][j] = true;
				}else if (j == i+1) {
					mat[i][j] = (s.charAt(i) == s.charAt(j));
				}else {
					mat[i][j] = ((s.charAt(i) == s.charAt(j)) && mat[i+1][j-1]);
				}
			 }
		 }
		 for(int i=1;i<=len;i++){
			 for(int j=0;j<len;j++){
				 if (mat[j][i-1]) {
					dp[i] = Math.min(dp[i], dp[j]+1);
				}
			 }
		 }
		 return dp[len];
	 }
	 
	 public static void main(String[] args) {
		String string = "aab";
		System.out.println(minCut(string));
	}
}