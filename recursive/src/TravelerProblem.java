package recursive;
/**
 * 旅行商问题：np问题
 * @author xiaolinzi
 *
 */
public class TravelerProblem {
	
	private static int n;
	private static boolean[] visited;
	private static int[][] map;
	private static int min = 100000000;
	
	public static int search(int idx,int count){
		if (count == n) {
			return 0;
		}
		for(int i=0;i<n;++i){
			if (!visited[i]) {
				visited[i] = true;
				int t = search(i, count+1) + map[idx][i];
				min = Math.min(min, t);
				visited[i] = false;
			}
		}
		return min;
	}
}
