public class IntegerBreak343 {

	public static int integerBreak(int n) {
		if (n == 1) {
			return 1;
		}
		int res = -1;
		for(int i=1;i<=n-1;i++) {
			res = Math.max(res, Math.max(i*(n-i),i*integerBreak(n-i)));
		}
		return res;
	}
	
	public static int integerBreak2(int n) {
		if (n == 1) {
			return 1;
		}

		int[] memo = new int[n+1];
		memo[1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				// j + i-j
				memo[i] = Math.max(memo[i], Math.max(j*(i-j), j*memo[i-j]));
			}
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(integerBreak2(n));
	}
}
