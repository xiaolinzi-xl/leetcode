public class SortColors {
//	��������
	public static void sortColors(int[] nums) {
		int[] count = new int[3]; // ���0,1,2��Ƶ��
		for(int i=0;i<nums.length;i++){
			count[nums[i]]++;
		}
		int index = 0;
		for(int i=0;i<count[0];i++){
			nums[index++] = 0;
		}
		for(int i=0;i<count[1];i++){
			nums[index++] = 1;
		}
		for(int i=0;i<count[2];i++){
			nums[index++] = 2;
		}
	}
	
	public static void sortColor2(int[] nums) {
		int zero = -1; // nums[0,zero] = 0
		int two = nums.length; // nums[two,n-1] = 2
		for(int i=0;i<two;){
			if (nums[i] == 1) {
				i++;
			}else if (nums[i] == 2) {
				int tmp = nums[two-1];
				nums[two-1] = nums[i];
				nums[i] = tmp;
				two--;
			}else {
				int tmp = nums[zero+1];
				nums[zero+1] = nums[i];
				nums[i] = tmp;
				zero++;
				i++;
			}
		}
	}

}
