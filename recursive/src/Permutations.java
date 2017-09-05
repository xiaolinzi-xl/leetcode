import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaolinzi
 *
 */
public class Permutations {
	
	public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public static List<Boolean> visited = new ArrayList<>();
	
	public static void search(int[] nums,int idx,List<Integer> p){
		if (idx == nums.length) {
			ans.add(new ArrayList<Integer>(p));
			return;
		}
		for(int i=0;i<nums.length;++i){
			if (!visited.get(i)) {
				visited.set(i, true);
				p.add(nums[i]);
				search(nums, idx+1, p);
				p.remove((Integer)nums[i]);
				visited.set(i, false);
			}
		}
	}
	
	 public static List<List<Integer>> permute(int[] nums) {
		 if (nums.length == 0) {
			return ans;
		 }
		 for(int i=0;i<nums.length;++i){
			 visited.add(false);
		 }
		 List<Integer> p = new ArrayList<>();
		 search(nums, 0, p);
		 return ans;
	 }
	 
	 public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}
}
