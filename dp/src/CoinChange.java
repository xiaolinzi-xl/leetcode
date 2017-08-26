import java.util.Arrays;

public class CoinChange {
	
	public static final int maxValue = 100000000;
	
	public static int search(int idx,int[] coins,int amount) {
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return maxValue;
		}
		if (idx >= coins.length) {
			return maxValue;
		}
		return Math.min(search(idx, coins, amount-coins[idx])+1, search(idx+1, coins, amount));
	}
	
	public static int coinChange(int[] coins, int amount) {
		int res = search(0, coins, amount);
		if (res < maxValue) 
			return res;
		return -1;
	}
	
//	f(i,j) = min(f(i-1,j),f(i,j-coin(i))+1)
	
	public static int coinChange2(int[] coins,int amount){
		if(amount == 0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
		int maxValue = amount + 1;
		for(int i=0;i<dp.length;++i)
			dp[i][0] = maxValue;
		for(int j=0;j<dp[0].length;++j)
			dp[0][j] = maxValue;
		for(int i=1;i<=coins.length;++i){
			for(int j=1;j<=amount;++j){
				if (j < coins[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else if (j == coins[i-1]) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
				}
			}
		}
        if(dp[coins.length][amount] == maxValue)
            return -1;
		return dp[coins.length][amount];
	}
	
//	滚动数组
	public static int coinChange3(int[] coins,int amount) {
		if (amount == 0) 
			return 0;
		int maxValue = amount + 1;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, maxValue);
		for(int i=1;i<=coins.length;++i){
			for(int j=1;j<=amount;++j){
				if (j == coins[i-1]) {
					dp[j] = 1;
				}else if (j > coins[i-1]) {
					dp[j] = Math.min(dp[j], dp[j-coins[i-1]]+1);
				}
			}
		}
		return dp[amount] >= maxValue ? -1 : dp[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println("digui----" + coinChange(coins, amount));
		System.out.println("dp----" + coinChange2(coins, amount));
		System.out.println(coinChange3(coins, amount));
	}
}
