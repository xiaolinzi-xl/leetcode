package sort;

public class QuickSort {
	
	public static void quickSort(int[] arr,int left,int right) {
		if (left >= right) {
			return ;
		}
		int q = partition(arr, left, right);
		quickSort(arr, left, q-1);
		quickSort(arr, q+1, right);
	}
	
	public static int partition(int[] arr,int left,int right) {
		int element = arr[left];
		// [left+1,lt)<e,(rt,right]>e
		int lt = left + 1;
		int rt = right;
		while (true) {
			while (lt<=rt && arr[lt] < element) {
				lt++;
			}
			while (rt>=lt && arr[rt] > element) {
				rt--;
			}
			if (lt >= rt) {
				break;
			}
			SortUtils.swap(lt, rt, arr);
			lt++;
			rt--;
		}
		SortUtils.swap(left, rt, arr);
		return rt;
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 1, 5, 6, 9, 8, 7 };
		quickSort(arr, 0, arr.length-1);
		for (int x : arr)
			System.out.print(x + " ");
	}
}
