/**
 * dp要无后效性,最优子结构
 * 重复计算，冗余。
 * 本质是递归
 * @author xiaolinzi
 *
 */
public class HouseRobber {
	
	public static int rob(int[] nums) {
		return solve(nums.length-1, nums);
	}
	
//	时间超时
	public static int solve(int idx,int[] nums){
		if (idx < 0) 
			return 0;
//		对于每一家有两种策略，抢或者不抢
		int max = Math.max(nums[idx]+solve(idx-2, nums), solve(idx-1, nums));
		return max;
	}
	
	public static int solve2(int idx, int[] nums) {
		if (idx >= nums.length) {
			return 0;
		}
		int max = Math.max(nums[idx]+solve2(idx+2, nums), solve2(idx+1, nums));
		return max;
	}
	
//	dp[i] = max(dp[i-1],dp[i-2]+nums[i])
	
	public static int rob2(int[] nums) {
		if (nums.length == 0) 
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i=1;i<nums.length;++i){
			if (i-2>=0) {
				dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
			}else {
				dp[i] = Math.max(dp[i-1], nums[i]);
			}
		}
		return dp[dp.length-1];
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(rob(nums));
		System.out.println(rob2(nums));
		System.out.println(solve2(0, nums));
	}
}
