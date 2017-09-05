public class BinarySearch {
	public static  int binarySearch(Integer[] arr,int n,int target) {
		int l = 0,r = n-1;
		while(l <= r){
			int mid = (l + r) / 2;
			if (arr[mid] == target) {
				return mid;
			}else if (arr[mid] < target) {
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
		return -1;
	}
	
	public static int binarySearch2(Integer[] arr,int n,int target) {
		int l = 0,r = n;
		while(l < r){
		//	int mid = (l+r) / 2;
			//int mid = l + (r - l) / 2;
			int mid = l + (r-l)/2;
			if (arr[mid] == target) {
				return mid;
			}else if (target > arr[mid]) {
				l = mid + 1;
			}else{
				r = mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int n = 100000;
		Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10000);
		System.out.println(binarySearch2(arr, arr.length, 8));
	}

}