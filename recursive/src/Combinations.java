package recursive;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	
//	从1-n选择k个数
	public static List<List<Integer>> combine(int n,int k) {
		if (n <= 0 || k<=0 || k > n) {
			return res;
		}
		List<Integer> c = new ArrayList<>();
		generateCombinations(n, k, 1, c);
		return res;
	}
	
	public static void generateCombinations(int n,int k,int start,List<Integer> c) {
		if (c.size() == k) {
			res.add(new ArrayList<Integer>(c));
			return;
		}
//		k-c.size()个空位，回溯剪枝
		for(int i=start;i<=n-(k-c.size())+1;i++) {
			c.add(i);
			generateCombinations(n, k, i+1, c);
			c.remove((Integer)i);
		}
	}
	
	public static void main(String[] args) {
		combine(6, 4);
		System.out.println(res);
	}
}
