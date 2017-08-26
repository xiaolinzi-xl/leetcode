package array;

import java.util.Arrays;

public class TwoSum {
	public static int[] twoSum(int[] numbers,int target) {
		int[] ans = new int[2];
		int l = 0,r = numbers.length-1;
		while (l < r) {
			if (numbers[l] + numbers[r] == target) {
				ans[0] = l;
				ans[1] = r;
				break;
			}else if (numbers[l] + numbers[r] < target) {
				l++;
			}else{
				r--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(twoSum(arr, 10)));
	}
}
