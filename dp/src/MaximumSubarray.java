public class MaximumSubarray {
	public static int maxSubarray(int[] nums){
		int tmp = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			tmp += nums[i];
			if(tmp < 0){
				tmp = 0;
				max = Math.max(max, nums[i]);
			}else {
				max = Math.max(max, tmp);
			}
		}
		return max;
	}
	
/*
 * 动态规划：f(i) = max(nums(i),nums(i)+f(i-1))
 */
	public static int maxSubarray2(int[] nums){
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for(int i=1;i<nums.length;i++){
			dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static int maxSubarray3(int[] nums){
		int local = nums[0];
		int max = nums[0];
		for(int i=1;i<nums.length;i++){
			local = Math.max(local+nums[i], nums[i]);
			max = Math.max(max, local);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubarray(nums));
		System.out.println(maxSubarray2(nums));
		System.out.println(maxSubarray3(nums));
	}
}
