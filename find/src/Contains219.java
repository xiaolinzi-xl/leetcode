package find;

import java.util.HashSet;

public class Contains219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> record = new HashSet<>();
		for(int i=0;i<nums.length;i++){
			if (record.contains(nums[i])) {
				return true;
			}
			record.add(nums[i]);
			if (record.size() == k+1) { // ±£³Ök·¶Î§
				record.remove(nums[i-k]);
			}
		}
		return false;
	}
}
