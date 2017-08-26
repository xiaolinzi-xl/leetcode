public class Fib {
	
	// 1,1,2,3
	// f(n) = f(n-1) + f(n-2)
	// f(n) = f(n-1) * n
	
	public static int fib(int n) {
		if (n <= 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
//	动态规划
	public static int fib2(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=n;++i){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(fib(3));
		System.out.println(fib2(3));
	}
}
