public class PartitionEqualSubsetSum416 {
	
	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) 
			return false;
		boolean[][] values = new boolean[nums.length][sum/2+1];
		for(int i=0;i<=sum/2;i++) {
			values[0][i] = (i == nums[0]);
		}
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<=sum/2;j++) {
				values[i][j] = values[i-1][j];
				if (j >= nums[i]) {
					values[i][j] |= values[i-1][j-nums[i]];
				}
			}
		}
		return values[nums.length-1][sum/2];
	}
	
	public static boolean canPartition2(int[] nums) {
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		boolean[] memo = new boolean[sum/2+1];
		for(int i=0;i<=sum/2;i++)
			memo[i] = (i == nums[0]);
		for(int i=1;i<nums.length;i++) {
			for(int j=sum/2;j>=nums[i];j--) {
				memo[j] = memo[j] || memo[j-nums[i]];
			}
		}
		return memo[sum/2];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,5,2,3};
		System.out.println(canPartition(nums));
		System.out.println(canPartition2(nums));
	}

}
