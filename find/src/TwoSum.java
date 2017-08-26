package find;

import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			if (record.containsKey(target-nums[i])) {
				int[] ans = {record.get(target-nums[i]),i};
				return ans;
			}
			record.put(nums[i], i);
		}
        return null;
    }
}
