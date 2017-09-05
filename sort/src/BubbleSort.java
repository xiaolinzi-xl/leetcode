public class BubbleSort {
	
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			for(int j=1;j<n-i;j++){
				if(arr[j-1] > arr[j]){
					SortUtils.swap(j-1,j,arr);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,1,5,6,9,8,7};
		bubbleSort(arr);
		for(int x : arr)
			System.out.print(x + " ");
	}
}
