package sort;

public class SortUtils {
	
	private SortUtils() {
	}
	
	public static void swap(int x,int y,int[] arr) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
