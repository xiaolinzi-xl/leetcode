package sort;

public class InserrtSort {

	public static void insertSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int element = arr[i];
			int j = i;
			for (; j > 0 && arr[j - 1] > element; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = element;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 1, 5, 6, 9, 8, 7 };
		insertSort(arr);
		for (int x : arr)
			System.out.print(x + " ");
	}
}
