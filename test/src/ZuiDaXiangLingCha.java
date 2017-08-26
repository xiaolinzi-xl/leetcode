package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 求最大相邻差----无序数组
 * @author xiaolinzi
 *
 */
public class ZuiDaXiangLingCha {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
//		桶排序
		int d = (max-min) / n;
		int len = n + 1;
		@SuppressWarnings("unchecked")
		List<Integer>[] tong = new ArrayList[len];
		for(int i=0;i<tong.length;i++){
			tong[i] = new ArrayList<>();
		}
		for(int i=0;i<arr.length;i++){
			int index = (arr[i] - min) / d;
			tong[index].add(arr[i]);
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<tong.length;i++){
			if(tong[i].size() == 0){
				int left = i-1;
				Collections.sort(tong[i-1]);
				while(tong[i+1].size() == 0){
					i++;
				}
				Collections.sort(tong[i+1]);
				
				ans = Math.max(ans, tong[i+1].get(0)-tong[left].get(tong[left].size()-1));
			}
		}
		System.out.println(Arrays.toString(tong));
		System.out.println(ans);
		
		scanner.close();
	}
}
