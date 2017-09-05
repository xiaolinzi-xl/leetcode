public class MergeSort {
	
	public static void mergeSort(int[] arr,int left,int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);
		merge(arr, left, mid, right);
	}
	
	public static void merge(int[] arr,int left,int mid,int right) {
		int[] tmp = new int[right-left+1];
		for(int i=left;i<=right;i++){
			tmp[i-left] = arr[i];
		}
		int i = left;
		int j = mid + 1;
		for(int k=left;k<=right;k++){
			if (i > mid) {
				arr[k] = tmp[j-left];
				j++;
			}else if (j > right) {
				arr[k] = tmp[i-left];
				i++;
			}else if (tmp[i-left] <= tmp[j-left]) {
				arr[k] = tmp[i-left];
				i++;
			}else {
				arr[k] = tmp[j-left];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 1, 5, 6, 9, 8, 7 };
		mergeSort(arr, 0, arr.length-1);
		for (int x : arr)
			System.out.print(x + " ");
	}
}
