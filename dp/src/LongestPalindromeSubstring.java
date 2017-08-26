public class LongestPalindromeSubstring {
	
	public static String longestPalindrome(String s) {
		if (s==null || s.length()==0) {
			return null;
		}
		int n = s.length();
		int maxLen = 1;
		int index1,index2;
		index1 = index2 = n - 1;
		/*
		 * dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
		 * len = j - i + 1  dp[i][j] = true
		 * 
		 */
		boolean[][] dp = new boolean[n][n];
		for(int i=n-1;i>=0;i--){
			int tmp = 0;
			for(int j=i;j<n;j++){
				if (i == j) {
					dp[i][j] = true;
				}else if (j == i+1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				}else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
				}
				if (dp[i][j]) {
					tmp = j - i + 1;
					if (tmp >= maxLen) {
						maxLen = tmp;
						index1 = i;
						index2 = j;
					}
				}
			}
		}
		return s.substring(index1, index2+1);
	}
	
	public static void main(String[] args) {
		String string = "babad";
		System.out.println(longestPalindrome(string));
	}
}
