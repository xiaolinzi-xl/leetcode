package find;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersection2 {
	public static int[] intersection(int[] nums1, int[] nums2){
		if(nums1.length==0 || nums2.length == 0)
            return new int[0];
        HashMap<Integer, Integer> record = new HashMap<>();
		for(int i=0;i<nums1.length;i++){
			if (record.containsKey(nums1[i])) {
				record.put(nums1[i], record.get(nums1[i])+1);
			}else{
				record.put(nums1[i], 1);
			}
		}
		ArrayList<Integer> resultList = new ArrayList<>();
		for(int i=0;i<nums2.length;i++){
			if (record.containsKey(nums2[i]) && record.get(nums2[i]) > 0) {
				resultList.add(nums2[i]);
				record.put(nums2[i], record.get(nums2[i])-1);
			}
		}
		int[] result = new int[resultList.size()];
		for(int i=0;i<result.length;i++)
			result[i] = resultList.get(i);
		return result;
	}
}
