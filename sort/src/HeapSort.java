public class HeapSort {
	
	public static void heapSort(int[] arr) {
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--)
			mainHeap(arr, n, i);
		for(int i=n-1;i>0;i--){
			SortUtils.swap(i, 0, arr);
			mainHeap(arr, i, 0);
		}
	}
	
	public static void mainHeap(int[] arr,int n,int pos) {
		int left = 2 * pos + 1;
		int right = left + 1;
		if (left < n) {
			int maxIndex = left;
			if (right < n && arr[right] > arr[left]) {
				maxIndex = right;
			}
			if (arr[pos] < arr[maxIndex]) {
				SortUtils.swap(pos, maxIndex, arr);
				mainHeap(arr, n, maxIndex);
			}
		}
		 
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 1, 5, 6, 9, 8, 7 };
		heapSort(arr);
		for (int x : arr)
			System.out.print(x + " ");
	}
}
