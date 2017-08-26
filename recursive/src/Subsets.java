package recursive;

import java.util.ArrayList;
import java.util.List;
/*
 * 子集:[1,2,3] {[],[1],[2],[3],[1,2],[1,3],[1,2,3],[2,3]}
 */
public class Subsets {
	
	private boolean[] v;
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    
//    dfs深度优先遍历
    public void robot(int idx,int[] nums){
        if(idx == nums.length){
            List<Integer> r = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(v[i])
                    r.add(nums[i]);
            }
            res.add(r);
            return;
        }
        v[idx] = true;
        robot(idx+1,nums); // 取
        v[idx] = false;
        robot(idx+1,nums); // 不取----状态回溯
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        v = new boolean[nums.length];
        robot(0,nums);
        return res;
    }
    
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		Subsets test = new Subsets();
		System.out.println(test.subsets(nums));
		
	}
    
}
