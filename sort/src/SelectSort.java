package sort;

public class SelectSort {
	
	public static void selectSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			int minIndex = i;
			int j=i+1;
			for(;j<n;j++){
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			SortUtils.swap(i, minIndex, arr);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,1,5,6,9,8,7};
		selectSort(arr);
		for(int x : arr)
			System.out.print(x + " ");
	}
}
