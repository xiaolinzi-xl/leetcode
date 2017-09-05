public class ShellSort {
	
	public static void shellSort(int[] arr) {
		int n = arr.length;
		int gap = n / 2;
		for(;gap>0;gap/=2){
			for(int i=gap;i<n;i+=gap){
				int element = arr[i];
				int j = i;
				for(;j>0 && arr[j-gap] > element;j-=gap){
					arr[j] = arr[j-gap];
				}
				arr[j] = element;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 1, 5, 6, 9, 8, 7 };
		shellSort(arr);
		for (int x : arr)
			System.out.print(x + " ");
	}
}
