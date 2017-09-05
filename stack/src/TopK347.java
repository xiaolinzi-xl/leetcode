import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopK347 {
	public static int[] topKFrequent(int[] nums,int k) {

		HashMap<Integer, Integer> freq = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if (freq.containsKey(nums[i])) {
				freq.put(nums[i], freq.get(nums[i])+1);
			}else {
				freq.put(nums[i], 1);
			}
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Set<Map.Entry<Integer,Integer>> freqMap = freq.entrySet();
		for(Map.Entry<Integer, Integer> entry : freqMap) {
			if (pq.size() == k) {
				if (entry.getValue() > pq.peek().times) {
					pq.poll();
					pq.add(new Pair(entry.getValue(), entry.getKey()));
				}
			}else {
				pq.add(new Pair(entry.getValue(), entry.getKey()));
			}
		}
		int[] ans = new int[pq.size()];
		int index = 0;
		while (!pq.isEmpty()) {
			ans[index++] = pq.poll().num; 
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,2,3,2,2,2,2,2,3,3,3,3,3,3,4,4,4};
		System.out.println(Arrays.toString(topKFrequent(nums, 2)));
	}
}

class Pair implements Comparable<Pair>{
	int num;
	int times;
	public Pair(int times,int num) {
		this.num = num;
		this.times = times;
	}
	
	@Override
	public int compareTo(Pair other) {
		return (this.times < other.times) ? -1 : ((this.times == other.times) ? 0 : 1);
	}
}
