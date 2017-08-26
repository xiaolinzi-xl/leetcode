import java.util.ArrayList;
import java.util.Arrays;

/*
 * 动态规划：f(i)以i结尾的最大上升子序列
 * f(i) = max(f(i),f(j)+1) j<i && nums[j] < nums[i]
 */
public class LongestIncreasingSubsequence {
	
	public static int[] p = new int[10000];
	
//	以idx结尾的最长上升子序列----加了一个最大值边界
	public int robot(int idx,int[] nums){
		int ans = 0;
		for(int i=0;i<idx;i++){
			if (nums[idx] > nums[i]) {
				ans = Math.max(ans, robot(i, nums));
			}
		}
		return ans + 1;
	}
	
	
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] lenMax = new int[nums.length];
		Arrays.fill(lenMax, 1);
		int ans = lenMax[0];
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					lenMax[i] = Math.max(lenMax[i], lenMax[j]+1);
				}
			}
			ans = Math.max(ans, lenMax[i]);
		}
//		System.out.println(Arrays.toString(lenMax));
		return ans;
	}
	
//	O(nlg(n))
	public static int lengthOfLIS2(int[] nums){
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : nums){
			int insertPos = lowerBound(arr, 0, arr.size(), x);
			if (insertPos >= arr.size()) {
				arr.add(x);
			}else {
				arr.set(insertPos, x);
			}
		}
		System.out.println(arr.toString());
		return arr.size();
	}

	public static int lowerBound(ArrayList<Integer> arr,int left,int right,int target) {
		while (left != right) {
			int mid = left + (right - left) / 2;
			if (target > arr.get(mid)) {
				++left;
			}else {
				right = mid;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(lengthOfLIS(nums));
		System.out.println(lengthOfLIS2(nums));
	}
}
