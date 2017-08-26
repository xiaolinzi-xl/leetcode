package find;

import java.util.HashSet;
import java.util.Iterator;

public class Intersection {
	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> record = new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        	record.add(nums1[i]);
        HashSet<Integer> resultSet = new HashSet<>();
        for(int i=0;i<nums2.length;i++){
        	if (record.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
        }
        int[] result = new int[resultSet.size()];
        Iterator<Integer> it = resultSet.iterator();
        for(int i=0;i<result.length;i++){
        	result[i] = it.next();
        }
        return result;
    }
}
