import java.util.Arrays;
import java.util.Comparator;
/*
 * 贪心算法：按结尾时间最早的选择
 */
public class NonoverlappingIntervals {

	public static int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			/*
			 * 自定义排序：按ID来从小到大排序：小于，等于，大于：-1,0,1
			 */
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start)
					return -1;
				if (o1.start == o2.start) {
					if(o1.end == o2.end)
						return 0;
					return o1.end<o2.end ? -1 : 1;
				}
				return 1;
			}
		});
		// memo[i]表示从0到i区间能够成的最长不重叠的区间序列
		int[] memo = new int[intervals.length];
		Arrays.fill(memo, 1);
		for (int i = 1; i < intervals.length; i++) {
			for (int j = 0; j < i; j++) {
				if (intervals[i].start >= intervals[j].end) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
		
		Arrays.sort(memo);
		
		return intervals.length - memo[memo.length - 1];
	}
	
	public static int eraseOverlapIntervals2(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		
		Arrays.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.end < o2.end) 
					return -1;
				else if(o1.end > o2.end)
					return 1;
				return 0;
			}
		});
		
		int res = 1;
		int pre = 0;
		for(int i=1;i<intervals.length;i++){
			if (intervals[i].start >= intervals[pre].end) {
				res++;
				pre = i;
			}
		}
		
		return intervals.length-res;
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[2];
		intervals[0] = new Interval(3,2);
		intervals[1] = new Interval(1,2);
//		intervals[2] = new Interval(1,11);
//		intervals[3] = new Interval(2,12);
		
		System.out.println(eraseOverlapIntervals(intervals));
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return start + "--" + end;
	}
}