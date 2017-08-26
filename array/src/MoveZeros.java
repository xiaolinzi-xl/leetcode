package array;

import java.util.Arrays;

public class MoveZeros {
	public static void moveZeroes(int[] nums) {
		int[] nonZeroes = new int[nums.length];
		int k = 0;
		for(int i=0;i<nums.length;i++){
			if (nums[i] != 0) {
				nonZeroes[k++] = nums[i];
			}
		}
		for(int i=0;i<k;i++){
			nums[i] = nonZeroes[i];
		}
		for(int i=k;i<nums.length;i++){
			nums[i] = 0;
		}
	}
	
	public static void moveZeroes2(int[] nums) {
		int k = 0; // [0-k)均为非0
		for(int i=0;i<nums.length;i++){
			if (nums[i] != 0) {
				nums[k++] = nums[i];
			}
		}
		for(int i=k;i<nums.length;i++){
			nums[i] = 0;
		}
	}
	
	public static void moveZeroes3(int[] nums) {
		int k = 0; // nums[0,k)为非零元素，[k,i]为0
		for(int i=0;i<nums.length;i++){
			if (nums[i] != 0) {
				if (i != k) {
					int tmp = nums[k];
					nums[k] = nums[i];
					nums[i] = tmp;
					k++;
				}else{
					k++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,3,0,12,0,9,0,0};
		moveZeroes3(arr);
		System.out.println(Arrays.toString(arr));
	}
}
