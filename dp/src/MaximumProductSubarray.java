public class MaximumProductSubarray {
//
	public static int maxProduct(int[] nums) {
		int maxLocal = nums[0];
		int minLocal = nums[0];
		int max = nums[0];
		for(int i=1;i<nums.length;i++){
			int temp = maxLocal;
			maxLocal = Math.max(nums[i], Math.max(temp*nums[i], minLocal*nums[i]));
			minLocal = Math.min(nums[i], Math.min(temp*nums[i], minLocal*nums[i]));
			max = Math.max(max, maxLocal);
		}
		return max;
	}
	
//	暴力搜索-----时间超时
	public static int maxProduct2(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            int subMax = 0x80000000;
            int tmp = 1;
            for(int j=i;j>=0;j--){
                if(nums[j] != 0){
                    tmp *= nums[j];
                    subMax = Math.max(tmp,subMax);
                }else{
                    tmp = 1;
                    subMax = Math.max(0,subMax);
                }
            }
            max = Math.max(max,subMax);
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,-5,-2,-4,3};
		System.out.println(maxProduct(nums));
		System.out.println(maxProduct2(nums));
	}
}
