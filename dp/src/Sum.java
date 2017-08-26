import java.util.Scanner;

/**
 * 从给定数组中挑选几个数和为m的方式
 * 对于每个数都有两种决策，放或者不放
 * dp[n][m] = dp[n-1][m] + dp[n-1][m-arr[i]]
 * @author xiaolinzi
 *
 */
public class Sum {
	
	/*
	 * 递归版
	 */
	public static int search(int[] arr,int sum,int idx) {
		if (idx == arr.length ||sum < 0) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}
		return search(arr, sum-arr[idx], idx+1) + search(arr, sum, idx+1);
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n,sum;
		n = scanner.nextInt();
		sum = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}
		
		System.out.println("digui---" + search(arr, sum, 0));
		
		int[][] dp = new int[n+1][sum+1];
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				dp[i][j] = dp[i-1][j];
				if (j == arr[i-1]) {
					dp[i][j] += 1;
				}
				if (j > arr[i-1]) {
					dp[i][j] += dp[i-1][j-arr[i-1]];
				}
			}
		}
		System.out.println(dp[n][sum]);
		
//		滚动数组
		int[] dp2 = new int[sum+1];
		for(int i=1;i<=n;i++){
			for(int j=sum;j>=arr[i-1];j--){
				if (j == arr[i-1]) {
					dp2[j] += 1;
				}
				if(j > arr[i-1]){
					dp2[j] += dp2[j-arr[i-1]];
				}
			}
		}
		System.out.println(dp2[sum]);
		scanner.close();
	}
}
